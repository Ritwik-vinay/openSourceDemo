package dataproviders;

import enums.DataSourceType;
import org.testng.annotations.DataProvider;
import utils.CSVutils;
import utils.ExcelUtils;

public class UnifiedDataProvider {
    @DataProvider(name = "loginData", parallel = true)
    public static Object[][] getLoginDataUnified(){
        DataSourceType source = getDataSource();
        switch (source){
            case CSV:
                return CSVutils.readCSV(
                        "src/test/resources/testData/loginData.csv");
            case EXCEL:
                return ExcelUtils.getExcelData(
                        "src/test/resources/testData/loginData.xlsx","Sheet1"
                );
            default:
                throw new RuntimeException("Unsupported Data Source");

        }
    }
    
    public static DataSourceType getDataSource(){
        return DataSourceType.EXCEL;
    }
}
