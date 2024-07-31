package com.douglas.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String excelPath, String sheetName) {
        try (FileInputStream file = new FileInputStream(excelPath)) {
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getSheetData() {
        List<Object[]> data = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        // Skip the header row
        int firstRow = 1;
        int lastRow = sheet.getPhysicalNumberOfRows();

        for (int i = firstRow; i < lastRow; i++) {
            Row row = sheet.getRow(i);
            List<Object> rowData = new ArrayList<>();
            row.forEach(cell -> rowData.add(formatter.formatCellValue(cell)));
            data.add(rowData.toArray(new Object[0]));
        }

        return data.toArray(new Object[0][0]);
    }

}
