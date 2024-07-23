package demo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {

    public static void writeDataToExcel(HashMap<String, String> data, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Product Data");

        int rowNum = 0;
        Row headerRow = sheet.createRow(rowNum++);
        Cell headerCell1 = headerRow.createCell(0);
        headerCell1.setCellValue("Product Name");
        Cell headerCell2 = headerRow.createCell(1);
        headerCell2.setCellValue("Product Price");

        for (Map.Entry<String, String> entry : data.entrySet()) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(entry.getKey());
            Cell cell2 = row.createCell(1);
            cell2.setCellValue(entry.getValue());
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
