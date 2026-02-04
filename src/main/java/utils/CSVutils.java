package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVutils {
    public static Object[][] readCSV(String filePath)  {
        List<Object[]> data = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            boolean isheader=true;
            while ((line=br.readLine())!=null){
                if (isheader){
                    isheader=false;
                    continue;
                }
                String[] value= line.split(",");
                data.add(value);
            }
        }catch (Exception e){
            throw new RuntimeException("Failed to read the file: "+ filePath,e );

        }
        return data.toArray(new Object[0][]);
    }
}
