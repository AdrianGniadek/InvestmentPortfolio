package pl.coderslab.portfolio;

public interface PortfolioAssetService {
    void savePortfolioAsset(PortfolioAsset portfolioAsset);

    PortfolioAsset getPortfolioAssetById(Long id);
}
