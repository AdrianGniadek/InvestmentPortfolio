package pl.coderslab.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class
StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        Optional<Stock> stockOptional = stockRepository.findById(id);
        return stockOptional.orElse(null);
    }

    @Override
    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public void updateStock(Stock stock) {
        Optional<Stock> stockOptional = stockRepository.findById(stock.getId());
        if (stockOptional.isPresent()) {
            Stock existingStock = stockOptional.get();
            existingStock.setSymbol(stock.getSymbol());
            existingStock.setName(stock.getName());
            existingStock.setPrice(stock.getPrice());
            stockRepository.save(existingStock);
        }
    }

    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
