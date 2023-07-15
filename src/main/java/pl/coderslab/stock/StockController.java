package pl.coderslab.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.portfolio.PortfolioAsset;
import pl.coderslab.portfolio.PortfolioAssetService;

import javax.validation.Valid;
import java.time.LocalDateTime;

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
    public String processStockForm(@Valid Stock stock, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
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
    public String processStockDetailsForm(@Valid @ModelAttribute("portfolioAsset") PortfolioAsset portfolioAsset, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "stock/addStockDetails";
        }
        portfolioAsset.setPurchaseDate(LocalDateTime.now());
        portfolioAssetService.savePortfolioAsset(portfolioAsset);

        return "redirect:/stock";
    }
}