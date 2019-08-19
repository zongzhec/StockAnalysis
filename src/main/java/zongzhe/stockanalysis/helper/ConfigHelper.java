package zongzhe.stockanalysis.helper;

import java.util.HashMap;

public class ConfigHelper {

    // Store the thresholds of each stock
    public HashMap<String, Integer> basePrices;

    public void initBasePrices(){
        basePrices = new HashMap<>();
        basePrices.put(Constants.STOCK_NUM_500_ETF, 1000);
        basePrices.put(Constants.STOCK_NUM_HONGLI_ETF, 1000);
        basePrices.put(Constants.STOCK_NUM_HENGSHENG_ETF, 1000);
        basePrices.put(Constants.STOCK_NUM_NAZHI_ETF, 1000);
        basePrices.put(Constants.STOCK_NUM_YINHANG_ETF, 500);
        basePrices.put(Constants.STOCK_NUM_HUABAO_YOUQI, 0);
        basePrices.put(Constants.STOCK_NUM_JUNGONG_ETF, 500);
        basePrices.put(Constants.STOCK_NUM_500_YIYAO, 500);
        basePrices.put(Constants.STOCK_NUM_QUANSHANG_ETF, 1000);
    }

    public HashMap<String, Integer> getBasePrices() {
        return this.basePrices;
    }

    public void setBasePrices(HashMap<String, Integer> basePrices) {
        this.basePrices = basePrices;
    }




}
