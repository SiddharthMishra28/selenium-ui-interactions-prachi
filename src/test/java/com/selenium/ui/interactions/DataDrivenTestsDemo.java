package com.selenium.ui.interactions;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataDrivenTestsDemo {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(new File("./src/test/resources/TestData.xlsx"));
            Workbook wb = new XSSFWorkbook(fis);
            Sheet loginDataSheet = wb.getSheet("login");
            int lastRowNum = loginDataSheet.getLastRowNum();
            int lastColNum = loginDataSheet.getRow(0).getLastCellNum();
            for(int i=1; i<=lastRowNum; i++) {
                for(int j=0; j<lastColNum; j++) {
                    System.out.println(loginDataSheet.getRow(i).getCell(j).getStringCellValue());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dataProvider = "logindata")
    public void loginTest(String userId, String password) {
        System.out.println("User ID "+userId+" Password "+password);
    }

    @DataProvider(name = "logindata")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"abcd", "defg"},
                {"rerewwe", "werewrw"},
                {"sadsad", "adada"}
        };
    }
}
