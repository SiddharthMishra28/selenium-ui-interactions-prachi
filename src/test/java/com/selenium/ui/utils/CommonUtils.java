package com.selenium.ui.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CommonUtils {

    WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void typeIntoField(By field, String text) {
        driver.findElement(field).sendKeys(text);
    }

    public void clickElement(By id){
        driver.findElement(id).click();
    }

    public void assertStringMatch(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }

    public static String[][] readExcel(String xlPath, String xlSheetName) {
        try {
            FileInputStream fis = new FileInputStream(new File(xlPath));
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(xlSheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            String[][] data = new String[rowCount][colCount];
            System.out.println(rowCount+" | "+colCount);
            for(int i=1; i<=rowCount; i++) {
                for(int j=0; j<colCount; j++) {
                    data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            return data;
        } catch (IOException e) {
            System.out.println("Error while Reading Test Data");
        }
        return null;
    }
}
