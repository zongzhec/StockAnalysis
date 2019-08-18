package zongzhe.stockanalysis.controller;

import zongzhe.stockanalysis.entity.MarketClosePrice;
import zongzhe.stockanalysis.helper.StockAnalysisHelper;

import java.io.IOException;
import java.util.List;
import foo.zongzhe.common.utils.*;

public class StockAnalysisController {

    public static final String FILE_NAME = "indexValue.xlsx";


    public static void main(String args[]) throws IOException {
        LogUtil.logInfo("Link start!");

        // Step 1: Read prices from Excel
        StockAnalysisHelper helper = new StockAnalysisHelper();
        List<MarketClosePrice> priceList = helper.getPriceFromExcel(FILE_NAME);

    }
}
