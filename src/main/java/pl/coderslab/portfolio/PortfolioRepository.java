package pl.coderslab.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Portfolio findByUserUsername(String username);
    @Query("SELECT p FROM Portfolio p WHERE p.user.username = :username")
    List<Portfolio> findAllPortfoliosByUserUsername(@Param("username") String username);
}
