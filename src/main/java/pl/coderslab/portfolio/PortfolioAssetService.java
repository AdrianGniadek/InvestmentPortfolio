package pl.coderslab.portfolio;

import pl.coderslab.stock.Stock;

public interface PortfolioAssetService {
    void savePortfolioAsset(PortfolioAsset portfolioAsset);

    PortfolioAsset getPortfolioAssetById(Long id);

    Iterable<PortfolioAsset> getPortfolioAssetsByStock(Stock stock);
    void deletePortfolioAsset(Long id);
}
