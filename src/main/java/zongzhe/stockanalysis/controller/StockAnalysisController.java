package zongzhe.stockanalysis.controller;

import zongzhe.stockanalysis.entity.MarketClosePrice;
import zongzhe.stockanalysis.helper.StockAnalysisHelper;
import foo.zongzhe.common.utils.*;
import java.util.List;

public class StockAnalysisController {

    public static final String INPUT_PATH = "Z:/HistoricalMktClosePrice.xlsx";


    public static void main(String args[]) {
        LogUtil.printInfo("Link start!");

        // Step 1: Read prices from Excel
        StockAnalysisHelper helper = new StockAnalysisHelper();
        List<MarketClosePrice> priceList = helper.getPriceFromExcel(INPUT_PATH);

    }
}
