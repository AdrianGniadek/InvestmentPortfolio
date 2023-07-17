package pl.coderslab.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.stock.Stock;

public interface PortfolioAssetRepository extends JpaRepository<PortfolioAsset, Long> {
    Iterable<PortfolioAsset> findByStock(Stock stock);
}
