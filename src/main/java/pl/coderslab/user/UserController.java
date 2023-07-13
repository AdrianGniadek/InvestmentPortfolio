package pl.coderslab.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.portfolio.Portfolio;
import pl.coderslab.portfolio.PortfolioService;

@Controller
public class UserController {
    private final UserService userService;
    private PortfolioService portfolioService;

    public UserController(UserService userService, PortfolioService portfolioService) {
        this.userService = userService;
        this.portfolioService = portfolioService;
    }
    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        userService.saveUser(user);

        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioName("admin");
        portfolio.setUser(user);
        portfolioService.save(portfolio);
        return "admin";
    }
    @GetMapping("/login")
    public String login(){
        return "admin/admin-login";
    }

}