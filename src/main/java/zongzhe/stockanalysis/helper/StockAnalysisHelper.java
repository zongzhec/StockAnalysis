package zongzhe.stockanalysis.helper;

import foo.zongzhe.common.utils.LogUtil;
import foo.zongzhe.file.utils.ExcelUtil;
import zongzhe.stockanalysis.entity.MarketClosePrice;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockAnalysisHelper {

    public List<MarketClosePrice> getPriceFromExcel(String fileName) throws IOException {
        List<MarketClosePrice> priceList = new ArrayList<>();

        ExcelUtil excelUtil = new ExcelUtil();

        String[][] contents = excelUtil.readExcelValues(fileName, 0);
        LogUtil.logInfo("first value: " + contents[0][0]);
        return priceList;
    }
}
