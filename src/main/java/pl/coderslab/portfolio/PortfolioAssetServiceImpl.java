package pl.coderslab.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioAssetServiceImpl implements PortfolioAssetService {

    private final PortfolioAssetRepository portfolioAssetRepository;
    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioAssetServiceImpl(PortfolioAssetRepository portfolioAssetRepository, PortfolioService portfolioService) {
        this.portfolioAssetRepository = portfolioAssetRepository;
        this.portfolioService = portfolioService;
    }

    @Override
    public void savePortfolioAsset(PortfolioAsset portfolioAsset) {
        portfolioAssetRepository.save(portfolioAsset);
    }

    @Override
    public PortfolioAsset getPortfolioAssetById(Long id) {
        return portfolioAssetRepository.findById(id).orElse(null);
    }
}