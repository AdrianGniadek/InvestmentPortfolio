package pl.coderslab.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StockController {

    private final StockRepository stockRepository;

    @Autowired
    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping("/stock")
    public String showAllStocks(Model model) {
        Iterable<Stock> stocks = stockRepository.findAll();
        model.addAttribute("stocks", stocks);
        return "stock/allStocks";
    }
    @GetMapping("/stock/form")
    public String showStockForm(Model model) {
        model.addAttribute("stock", new Stock());
        return "stock/stockForm";
    }
}
