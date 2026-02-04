package dataproviders;

import org.testng.annotations.DataProvider;
import utils.CSVutils;

public class CSVDataProvider {
    @DataProvider(name= "loginData",parallel = true)
    public Object[][] getLoginData(){
        String path= "src/test/resources/testData/loginData.csv";
        return CSVutils.readCSV(path);
    }
}
