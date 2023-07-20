package pl.coderslab.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.portfolio.PortfolioAsset;
import pl.coderslab.portfolio.PortfolioAssetService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;
    private final PortfolioAssetService portfolioAssetService;

    @Autowired
    public StockController(StockService stockService, PortfolioAssetService portfolioAssetService) {
        this.stockService = stockService;
        this.portfolioAssetService = portfolioAssetService;
    }

    @GetMapping("")
    public String showAllStocks(Model model) {
        Iterable<Stock> stocks = stockService.getAllStocks();
        model.addAttribute("stocks", stocks);
        return "stock/allStocks";
    }

    @GetMapping("/add")
    public String showStockForm(Model model) {
        model.addAttribute("stock", new Stock());
        return "stock/stockForm";
    }

    @PostMapping("/add")
    public String processStockForm(@Valid Stock stock, BindingResult bindingResult, Model model) {
        boolean isNameTaken = stockService.isStockNameTaken(stock.getName());
        boolean isSymbolTaken = stockService.isStockSymbolTaken(stock.getSymbol());

        if (isNameTaken && isSymbolTaken) {
            model.addAttribute("nameError", "Portfolio with this name already exists!");
            model.addAttribute("symbolError", "Portfolio with this symbol already exists!");
            return "stock/stockForm";
        } else if (isNameTaken) {
            model.addAttribute("nameError", "Portfolio with this name already exists!");
            return "stock/stockForm";
        } else if (isSymbolTaken) {
            model.addAttribute("symbolError", "Portfolio with this symbol already exists!");
            return "stock/stockForm";
        }

        stockService.saveStock(stock);
        return "redirect:/stock";
    }
    @GetMapping("/addDetails")
    public String showStockDetailsForm(@RequestParam("stockId") Long stockId, Model model) {
        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        model.addAttribute("stock", stock);
        model.addAttribute("portfolioAsset", new PortfolioAsset());
        return "stock/addStockDetails";
    }

    @PostMapping("/addDetails")
    public String processStockDetailsForm(@RequestParam("stockId") Long stockId, @Valid @ModelAttribute("portfolioAsset")
    PortfolioAsset portfolioAsset, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "stock/addStockDetails";
        }

        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        portfolioAsset.setStock(stock);
        portfolioAssetService.savePortfolioAsset(portfolioAsset);
        PortfolioAsset updatedPortfolioAsset = portfolioAssetService.getPortfolioAssetById(portfolioAsset.getId());
        model.addAttribute("stock", stock);
        model.addAttribute("portfolioAsset", updatedPortfolioAsset);

        return "redirect:/stock/stockDetails/" + stockId;
    }
    @GetMapping("/stockDetails/{stockId}")
    public String showStockDetails(@PathVariable("stockId") Long stockId, Model model) {
        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        model.addAttribute("stock", stock);
        Iterable<PortfolioAsset> portfolioAssets = portfolioAssetService.getPortfolioAssetsByStock(stock);
        List<PortfolioAsset> portfolioAssetList = new ArrayList<>();
        portfolioAssets.forEach(portfolioAssetList::add);
        Collections.sort(portfolioAssetList, Comparator.comparing(PortfolioAsset::getPurchaseDate).reversed());
        model.addAttribute("portfolioAssets", portfolioAssetList);

        return "stock/stockDetailsView";
    }
    @GetMapping("/edit/{stockId}")
    public String showEditNameAndSymbolForm(@PathVariable("stockId") Long stockId, Model model) {
        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        model.addAttribute("stock", stock);
        return "stock/editStock";
    }

    @PostMapping("/edit/{stockId}")
    public String processEditNameAndSymbolForm(@PathVariable("stockId") Long stockId,
    @RequestParam("name") String name, @RequestParam("symbol") String symbol) {
        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        stock.setName(name);
        stock.setSymbol(symbol);
        stockService.saveStock(stock);
        return "redirect:/stock";
    }

    @GetMapping("/delete/{stockId}")
    public String showDeleteForm(@PathVariable("stockId") Long stockId, Model model) {
        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        model.addAttribute("stock", stock);
        return "stock/deleteStock";
    }

    @PostMapping("/delete/{stockId}")
    public String deleteStock(@PathVariable("stockId") Long stockId) {
        Stock stock = stockService.getStockById(stockId);
        if (stock != null) {
            stockService.deleteStock(stock.getId());
        }
        return "redirect:/stock";
    }
    @GetMapping("/editDetails/{stockId}/{portfolioAssetId}")
    public String showEditStockDetailsForm(@PathVariable("stockId") Long stockId,
    @PathVariable("portfolioAssetId") Long portfolioAssetId, Model model) {
        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        model.addAttribute("stock", stock);
        PortfolioAsset existingPortfolioAsset = portfolioAssetService.getPortfolioAssetById(portfolioAssetId);
        if (existingPortfolioAsset == null || !existingPortfolioAsset.getStock().getId().equals(stockId)) {
            return "redirect:/stock";
        }
        model.addAttribute("portfolioAsset", existingPortfolioAsset);

        return "stock/editStockDetails";
    }

    @PostMapping("/editDetails/{stockId}/{portfolioAssetId}")
    public String processEditStockDetailsForm(@PathVariable("stockId") Long stockId,
                                              @PathVariable("portfolioAssetId") Long portfolioAssetId, @Valid @ModelAttribute("portfolioAsset") PortfolioAsset portfolioAsset,
                                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "stock/editStockDetails";
        }

        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        PortfolioAsset existingPortfolioAsset = portfolioAssetService.getPortfolioAssetById(portfolioAssetId);
        if (existingPortfolioAsset == null || !existingPortfolioAsset.getStock().getId().equals(stockId)) {
            return "redirect:/stock";
        }
        existingPortfolioAsset.setQuantity(portfolioAsset.getQuantity());
        existingPortfolioAsset.setAssetValue(portfolioAsset.getAssetValue());
        existingPortfolioAsset.setPurchaseDate(portfolioAsset.getPurchaseDate());
        portfolioAssetService.savePortfolioAsset(existingPortfolioAsset);

        return "redirect:/stock/stockDetails/" + stockId;
    }

    @GetMapping("/deleteDetails/{stockId}/{portfolioAssetId}")
    public String showDeleteStockDetailsForm(@PathVariable("stockId") Long stockId,
    @PathVariable("portfolioAssetId") Long portfolioAssetId, Model model) {
        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        model.addAttribute("stock", stock);
        PortfolioAsset existingPortfolioAsset = portfolioAssetService.getPortfolioAssetById(portfolioAssetId);
        if (existingPortfolioAsset == null || !existingPortfolioAsset.getStock().getId().equals(stockId)) {
            return "redirect:/stock";
        }
        model.addAttribute("portfolioAsset", existingPortfolioAsset);

        return "stock/deleteStockDetails";
    }

    @PostMapping("/deleteDetails/{stockId}/{portfolioAssetId}")
    public String deleteStockDetails(@PathVariable("stockId") Long stockId,
                                     @PathVariable("portfolioAssetId") Long portfolioAssetId) {
        Stock stock = stockService.getStockById(stockId);
        if (stock == null) {
            return "redirect:/stock";
        }
        PortfolioAsset existingPortfolioAsset = portfolioAssetService.getPortfolioAssetById(portfolioAssetId);
        if (existingPortfolioAsset == null || !existingPortfolioAsset.getStock().getId().equals(stockId)) {
            return "redirect:/stock";
        }
        portfolioAssetService.deletePortfolioAsset(portfolioAssetId);

        return "redirect:/stock/stockDetails/" + stockId;
    }
}