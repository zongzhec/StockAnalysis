package zongzhe.stockanalysis.entity;

import java.util.List;

public class MarketClosePrice {

    public static final Double[] PRICE_THRESHOLD = {0.005, 0.01, 0.1, 0.2, 0.3, 0.4, 0.5};

    private String stockNum;
    private String stockName;
    private List<Double> prices;

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public List<Double> getPrices() {
        return prices;
    }

    public void setPrices(List<Double> prices) {
        this.prices = prices;
    }


}
