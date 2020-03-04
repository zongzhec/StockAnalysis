package zongzhe.stockanalysis.controller;

import zongzhe.stockanalysis.entity.MarketClosePrice;
import zongzhe.stockanalysis.helper.ConfigHelper;
import zongzhe.stockanalysis.helper.StockAnalysisHelper;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import foo.zongzhe.common.utils.*;

public class StockAnalysisController {

    private static final String FILE_NAME = "indexValue.xlsx";
    private static double[] priceThresholds;


    public static void main(String args[]) throws IOException {
        LogUtil.logInfo("Link start!");

        // Step 0: Initialize
        ConfigHelper confHelper = new ConfigHelper();
        confHelper.initBasePrices();
        priceThresholds = new double[MarketClosePrice.INDEX_THRESGOLD.length];

        // Step 1: Read prices from Excel
        StockAnalysisHelper helper = new StockAnalysisHelper();
        List<MarketClosePrice> mcpList = helper.getPriceFromExcel(FILE_NAME);
        MarketClosePrice mcp = mcpList.get(0);
        LogUtil.logInfo(String.format("First index num: %s, name: %s, value: %f", mcp.getStockNum(), mcp.getStockName(), mcp.getPrices().get(0)));

        // Step 2: Sort the index values
        helper.sortPrices(mcpList);
        mcp = mcpList.get(0);
        LogUtil.logInfo(String.format("Largest index num: %s, name: %s, value: %f", mcp.getStockNum(), mcp.getStockName(), mcp.getPrices().get(0)));

        // Step 3: Get price threshold from history index
        priceThresholds = helper.getPriceThresholdFromIndex(MarketClosePrice.INDEX_THRESGOLD, mcpList);

        // Step 4: Get threshold and apply calculation
        helper.calWithThreshold(mcpList, priceThresholds);

        // Step 5: Get threshold from configuration and apply calculation
        helper.calWithThreshold(mcpList, MarketClosePrice.PRICE_THRESHOLD);
    }
}
