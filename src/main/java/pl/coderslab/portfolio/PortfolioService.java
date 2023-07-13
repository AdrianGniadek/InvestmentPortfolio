package pl.coderslab.portfolio;

import java.util.List;

public interface PortfolioService {
    Portfolio save(Portfolio portfolio);
    String getPortfolioNameForLoggedInUser();
    List<Portfolio> getAllPortfoliosForLoggedInUser();
}