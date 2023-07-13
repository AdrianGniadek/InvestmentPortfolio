package pl.coderslab.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PortfolioController {
    @GetMapping("/")
    public String start() {
        return "portfolio/portfolioView";
    }
}
