package com.douglas.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.douglas.testcases.searchTest;

public class ExcelReader {

	
	public static List<LinkedHashMap<String, String>> getUserRegData1() throws IOException {

        Workbook wb = WorkbookFactory.create(new File(System.getProperty("user.dir") + "//src//test//resources//Douglas_TestData.xlsx"));

        Sheet s = wb.getSheet("Sheet1");

        List<LinkedHashMap<String, String>> allData = new ArrayList<>();
        int rowNum = s.getPhysicalNumberOfRows();
        System.out.println("Physical rows: " + rowNum);

        // Iterate over each row (starting from row 1 to skip the header)
        for (int j = 1; j < rowNum; j++) {
            LinkedHashMap<String, String> data = new LinkedHashMap<>();
            Row row = s.getRow(j);

            for (int k = 0; k < row.getLastCellNum(); k++) {
                String keyCell = s.getRow(0).getCell(k).getStringCellValue();
                String valueCell = row.getCell(k).getStringCellValue();
                
                System.out.println("KEY CELL VAL: " + keyCell);
                System.out.println("Value of the excel: " + valueCell);
                
                data.put(keyCell, valueCell);
            }
            
            allData.add(data);
            
        }
        wb.close();
        
        return allData;
    }


public static void main(String args[]) throws InterruptedException, IOException
{
	
	List<LinkedHashMap<String, String>> da= ExcelReader.getUserRegData1();
	System.out.println("marke data "+da.get(2).get("Marke"));
	System.out.println(da);
}
}
