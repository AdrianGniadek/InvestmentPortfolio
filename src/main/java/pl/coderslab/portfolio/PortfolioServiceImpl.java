package pl.coderslab.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.coderslab.user.User;
import pl.coderslab.user.UserRepository;
import pl.coderslab.user.UserService;

import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public PortfolioServiceImpl(PortfolioRepository portfolioRepository, UserService userService, UserRepository userRepository) {
        this.portfolioRepository = portfolioRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }
    @Override
    public String getPortfolioNameForLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        List<Portfolio> portfolios = portfolioRepository.findAllPortfoliosByUserUsername(username);

        if (portfolios.isEmpty()) {
            return null;
        } else if (portfolios.size() == 1) {
            return portfolios.get(0).getPortfolioName();
        } else {
            return portfolios.get(0).getPortfolioName();
        }
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
        List<User> usersWithActivePortfolio = userRepository.findByActivePortfolio(portfolio);

        if (!usersWithActivePortfolio.isEmpty()) {
            for (User user : usersWithActivePortfolio) {
                user.setActivePortfolio(null);
                userRepository.save(user);
            }
        }
        portfolioRepository.delete(portfolio);
    }


    @Override
    public void setActivePortfolio(Portfolio portfolio) {
        User loggedInUser = userService.getLoggedInUser();
        loggedInUser.setActivePortfolio(portfolio);
        userService.saveUser(loggedInUser);
    }
    @Override
    public Portfolio getPortfolioForLoggedInUser() {
        User loggedInUser = userService.getLoggedInUser();
        return loggedInUser.getActivePortfolio();
    }
}
