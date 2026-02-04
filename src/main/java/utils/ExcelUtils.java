package utils;

import jdk.jfr.internal.consumer.OngoingStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static Object[][] getExcelData(String filePath, String sheetName){
        List<Object> data= new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook= WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount= sheet.getPhysicalNumberOfRows();
            int colCount= sheet.getRow(0).getPhysicalNumberOfCells();
            for (int i=0; i<rowCount;i++){
                Row row = sheet.getRow(i);
                Object[] rowData = new Object[colCount];
                for (int j=0; j<colCount;j++){
                    rowData[j]= row.getCell(j).toString();
                }
                data.add(rowData);
            }

        }catch (Exception e){
            throw new RuntimeException("Failed to run the Excel",e);
        }
        return data.toArray(new Object[0][]);
    }
}
