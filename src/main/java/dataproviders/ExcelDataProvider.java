package dataproviders;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class ExcelDataProvider {
    @DataProvider(name= "loginData",parallel = true)
    public Object[][] getLoginData(){
        String path="src/test/resources/testData/loginData.xlsx";
        return ExcelUtils.getExcelData(path,"Sheet1");
    }
}
