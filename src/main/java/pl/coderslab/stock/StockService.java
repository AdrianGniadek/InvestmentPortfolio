package pl.coderslab.stock;

import java.util.List;

public interface StockService {

    List<Stock> getAllStocks();

    Stock getStockById(Long id);

    void saveStock(Stock stock);

    void updateStock(Stock stock);

    void deleteStock(Long id);
    boolean isStockNameTaken(String name);

    boolean isStockSymbolTaken(String symbol);
}
