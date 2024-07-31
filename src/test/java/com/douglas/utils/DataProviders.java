package com.douglas.utils;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "excelData")
    public static Object[][] getExcelData() {
        String excelPath = System.getProperty("user.dir") + "//src//test//resources//Douglas_TestData.xlsx"; // Update this with the path to your Excel file
        String sheetName = "Sheet1"; 
        ExcelUtils excelUtils = new ExcelUtils(excelPath, sheetName);
        return excelUtils.getSheetData();
    }
}
