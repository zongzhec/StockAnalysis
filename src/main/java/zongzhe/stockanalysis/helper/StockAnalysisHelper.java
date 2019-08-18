package zongzhe.stockanalysis.helper;

import foo.zongzhe.common.utils.LogUtil;
import foo.zongzhe.common.utils.StringUtil;
import foo.zongzhe.file.utils.ExcelUtil;
import zongzhe.stockanalysis.entity.MarketClosePrice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StockAnalysisHelper {

    public List<MarketClosePrice> getPriceFromExcel(String fileName) throws IOException {
        List<MarketClosePrice> mcpList = new ArrayList<>();

        // Read from Excel
        ExcelUtil excelUtil = new ExcelUtil();
        String[][] contents = excelUtil.readExcelValues(fileName, 0);
        LogUtil.logInfo("first value: " + contents[0][1]);

        for (int col = 0; col < contents[0].length; col++) {
            MarketClosePrice mcp = new MarketClosePrice();
            List<Double> priceList = new ArrayList<>();
            for (int row = 0; row < contents.length && !StringUtil.isEmpty(contents[row][col]); row++) {
                switch (row) {
                    case 0:
                        mcp.setStockNum(contents[row][col]);
                        break;
                    case 1:
                        mcp.setStockName(contents[row][col]);
                        break;
                    default:
                        priceList.add(Double.parseDouble(contents[row][col]));
                        break;
                }
            }
            mcp.setPrices(priceList);
            mcpList.add(mcp);
        }
        return mcpList;
    }

    public void sortPrices(List<MarketClosePrice> mcpList) {
        for (MarketClosePrice mcp : mcpList) {
            mcp.getPrices().sort(Collections.reverseOrder());
        }
    }

    public void calWithThreshold(List<MarketClosePrice> mcpList) {
        Double[] priceThes = MarketClosePrice.PRICE_THRESHOLD;
        for(MarketClosePrice mcp:mcpList){
            LogUtil.logInfo(mcp.getStockNum() + ", " + mcp.getStockName());
            List<Double> priceList = mcp.getPrices();
            for (Double threshold: priceThes){
                int index = (int) (priceList.size() * threshold);
                LogUtil.logInfo(threshold + ": " + priceList.get(index));
            }
        }
    }
}
