package com.test.murali;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class excelTest {

    public static void main(String[] args) throws IOException {
        Map<String, String> excelData = new HashMap<String, String>();
        excelData=readWriteExcel("Login","hello");
        System.out.println(excelData.get("Name"));
        System.out.println(excelData.get("Age"));
        System.out.println(excelData.get("DOB"));
    }

    public static Map<String, String> readWriteExcel(String sheetName,String TestName) throws EncryptedDocumentException, InvalidFormatException, IOException, IOException {
        File f = new File("/Users/muralic/Personal/SeleniumPract/src/test/java/resources/Book.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String, String> rowData = new HashMap<>();

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(0);

            for (int j = 0; j < row.getLastCellNum(); j++) {
                String key = row.getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(0).getStringCellValue();
                if(value.equalsIgnoreCase(TestName)){
                    CellType celltype=sheet.getRow(i).getCell(j).getCellType();
                    switch (celltype) {
                        case  NUMERIC:
                            if(DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(j))) {
                                Date date = sheet.getRow(i).getCell(j).getDateCellValue();
                                DateFormat df = SimpleDateFormat.getDateInstance();
                                //logger.trace("Found date " + df.format(date));
                                System.out.println(df.format(date));
                                value = df.format(date);
                            }else{
                                value = sheet.getRow(i).getCell(j).getNumericCellValue() + "\t";
                            }
                            break;
                        case STRING :
                            value = sheet.getRow(i).getCell(j).getStringCellValue() + "\t";
                            break;
                        case FORMULA:
                            value=sheet.getRow(i).getCell(j).getNumericCellValue()+"\t";
                            break;
                    }
                    rowData.put(key, value);
                }

                }
            }

        return rowData;
    }

    }

