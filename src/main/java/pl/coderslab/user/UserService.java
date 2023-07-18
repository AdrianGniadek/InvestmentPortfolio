package pl.coderslab.user;

import pl.coderslab.portfolio.Portfolio;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
    User getLoggedInUser();
    void setActivePortfolioForUser(User user, Portfolio portfolio);
}