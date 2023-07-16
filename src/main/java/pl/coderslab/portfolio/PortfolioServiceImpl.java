package pl.coderslab.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.coderslab.user.User;
import pl.coderslab.user.UserService;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final UserService userService;

    @Autowired
    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, UserService userService) {
        this.portfolioRepository = portfolioRepository;
        this.userService = userService;
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }
    @Override
    public String getPortfolioNameForLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Portfolio portfolio = portfolioRepository.findByUserUsername(username);
        return portfolio != null ? portfolio.getPortfolioName() : null;
    }
    @Override
    public List<Portfolio> getAllPortfoliosForLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Portfolio> portfolios = portfolioRepository.findAllPortfoliosByUserUsername(username);
        return portfolios;
    }
    @Override
    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElse(null);
    }


    @Override
    public void deletePortfolio(Portfolio portfolio) {
        portfolioRepository.delete(portfolio);
    }

    @Override
    public void setActivePortfolio(Portfolio portfolio) {
        User loggedInUser = userService.getLoggedInUser();
        loggedInUser.setActivePortfolio(portfolio);
        userService.saveUser(loggedInUser);
    }
}
