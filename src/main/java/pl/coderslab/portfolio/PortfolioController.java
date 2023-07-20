package pl.coderslab.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;

import java.security.Principal;
import java.util.List;

@Controller
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final UserService userService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService, UserService userService) {
        this.portfolioService = portfolioService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String start(Model model) {
        String portfolioName = portfolioService.getPortfolioNameForLoggedInUser();
        Portfolio portfolio = portfolioService.getPortfolioForLoggedInUser();
        model.addAttribute("portfolioName", portfolioName);
        model.addAttribute("portfolio", portfolio);
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
    public String updatePortfolio(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            Model model) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);

        if (!portfolio.getPortfolioName().equals(name) && portfolioService.isPortfolioNameTaken(name)) {
            List<Portfolio> portfolios = portfolioService.getAllPortfoliosForLoggedInUser();
            model.addAttribute("portfolios", portfolios);
            model.addAttribute("nameError", "Portfolio with this name already exists!");
            model.addAttribute("portfolio", portfolio);
            return "portfolio/editPortfolioView";
        }

        portfolio.setPortfolioName(name);
        portfolio.setDescription(description);
        portfolioService.save(portfolio);
        return "redirect:/portfolios";
    }

    @GetMapping("/portfolio/delete/{id}")
    public String confirmDeletePortfolio(@PathVariable("id") Long id, Model model) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        if (portfolio == null) {
            return "errorPage";
        }
        model.addAttribute("portfolio", portfolio);
        return "portfolio/deletePortfolioView";
    }

    @PostMapping("/portfolio/delete/{id}")
    public String deletePortfolio(@PathVariable("id") Long id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        if (portfolio == null) {
            return "errorPage";
        }
        List<Portfolio> userPortfolios = portfolioService.getAllPortfoliosForLoggedInUser();
        if (userPortfolios.size() > 1) {
            portfolioService.deletePortfolio(portfolio);
        } else {
            return "errorPage";
        }
        return "redirect:/portfolios";
    }

    @GetMapping("/portfolio/switch/{id}")
    public String confirmSwitchPortfolio(@PathVariable("id") Long id, Model model) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        if (portfolio == null) {
            return "errorPage";
        }
        model.addAttribute("portfolio", portfolio);
        return "portfolio/switchPortfolioView";
    }

    @PostMapping("/portfolio/switch/{id}")
    public String switchPortfolio(@PathVariable("id") Long id) {
        Portfolio portfolio = portfolioService.getPortfolioById(id);
        if (portfolio == null) {
            return "errorPage";
        }
        portfolioService.setActivePortfolio(portfolio);
        return "redirect:/";
    }
    @GetMapping("/add")
    public String showAddPortfolioForm() {
        return "portfolio/addPortfolio";
    }

    @PostMapping("/add")
    public String addPortfolio(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            Model model) {
        if (portfolioService.isPortfolioNameTaken(name)) {
            model.addAttribute("register", "failed");
            return "portfolio/addPortfolio";
        }

        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioName(name);
        portfolio.setDescription(description);

        User loggedInUser = userService.getLoggedInUser();
        portfolio.setUser(loggedInUser);

        portfolioService.save(portfolio);
        return "redirect:/portfolios";
    }
}

