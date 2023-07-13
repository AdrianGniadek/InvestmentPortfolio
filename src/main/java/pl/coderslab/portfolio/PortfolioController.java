package pl.coderslab.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PortfolioController {
    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/")
    public String start(Model model) {
        String portfolioName = portfolioService.getPortfolioNameForLoggedInUser();
        model.addAttribute("portfolioName", portfolioName);
        return "portfolio/portfolioView";
    }
    @GetMapping("/portfolios")
    public String showPortfolios(Model model) {
        List<Portfolio> portfolios = portfolioService.getAllPortfoliosForLoggedInUser();
        model.addAttribute("portfolios", portfolios);
        return "portfolio/allPortfoliosView";
    }
}

