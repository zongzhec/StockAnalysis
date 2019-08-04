package zongzhe.stockanalysis.controller;

import foo.zongzhe.utils.LogUtil;
import zongzhe.stockanalysis.entity.MarketClosePrice;
import zongzhe.stockanalysis.helper.StockAnalysisHelper;

import java.util.List;

public class StockAnalysisController {

    public static final String INPUT_PATH = "Z:/HistoricalMktClosePrice.xlsx";


    public static void main(String args[]) {
        LogUtil logUtil = new LogUtil();
        logUtil.info("Link start!");

        // Step 1: Read prices from Excel
        StockAnalysisHelper helper = new StockAnalysisHelper();
        List<MarketClosePrice> priceList = helper.getPriceFromExcel(INPUT_PATH);

    }
}
