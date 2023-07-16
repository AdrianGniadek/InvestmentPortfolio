package pl.coderslab.stock;

import pl.coderslab.portfolio.PortfolioAsset;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String symbol;

    private String name;

    private BigDecimal price;
    @OneToMany(mappedBy = "stock")
    private List<PortfolioAsset> portfolioAssets;

    public List<PortfolioAsset> getPortfolioAssets() {
        return portfolioAssets;
    }

    public void setPortfolioAssets(List<PortfolioAsset> portfolioAssets) {
        this.portfolioAssets = portfolioAssets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
