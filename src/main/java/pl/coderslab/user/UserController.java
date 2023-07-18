package pl.coderslab.user;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.portfolio.Portfolio;
import pl.coderslab.portfolio.PortfolioService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
        userService.setActivePortfolioForUser(user, portfolio);
        return "admin";
    }
    @GetMapping("/login")
    public String login(){
        return "admin/admin-login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        SecurityContextHolder.clearContext();
        return "admin/admin-logout";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user",new User());
        return "admin/register";
    }
    @PostMapping("/register")
    public String addProcess(@RequestParam String confirm, @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/register";
        }
        if(userService.findByUserName(user.getUsername()) != null)
        {
            model.addAttribute("register","failed");
            user.setUsername("");
            user.setPassword("");
            return "admin/register";
        }
        if(!user.getPassword().equals(confirm)){
            model.addAttribute("pass","failed");
            return "admin/register";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }
}