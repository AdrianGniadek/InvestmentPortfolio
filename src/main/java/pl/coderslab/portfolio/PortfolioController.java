package pl.coderslab.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/portfolio/edit/{id}")
    public String editPortfolio(@PathVariable("id") Long id, Model model) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        if (portfolio == null) {
            return "redirect:/portfolios";
        }
        model.addAttribute("portfolio", portfolio);

        return "portfolio/editPortfolioView";
    }
    @PostMapping("/portfolio/edit/{id}")
    public String updatePortfolio(@PathVariable("id") Long id, @RequestParam("name") String name) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        portfolio.setPortfolioName(name);
        portfolioService.save(portfolio);
        return "redirect:/portfolios";
    }

    @GetMapping("/portfolio/delete/{id}")
    public String deletePortfolio(@PathVariable("id") Long id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);

        if (portfolio == null) {
            return "errorPage";
        }

        portfolioService.deletePortfolio(portfolio);

        return "redirect:/portfolios";
    }

    @GetMapping("/portfolio/switch/{id}")
    public String switchPortfolio(@PathVariable("id") Long id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        if (portfolio == null) {
            return "errorPage";
        }
        portfolioService.setActivePortfolio(portfolio);

        return "redirect:/";
    }
}

