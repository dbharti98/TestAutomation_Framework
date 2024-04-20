package com.saucedemo.util;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.io.File;

/**
 * A class has method to fetch data from excel sheet
 */
public class ExcelUtil {
    static Fillo fillo = new Fillo();
    static Connection connection;

    static String testDataFile = "TestData.xls";

    /**
     * Create and get Connection with specified file
     *
     * @param fileName : name of the file
     * @return : connection
     */
    public static Connection createAndGetConnection(String fileName) throws Exception {
        try {
            String fileSeparator = File.separator;
            String testDataFilePath = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
                    + "TestData" + fileSeparator + fileName;
            File file = new File(testDataFilePath);
            connection = fillo.getConnection(file.getAbsolutePath());
        } catch (FilloException e) {
            e.printStackTrace();
            throw new Exception(String.format("Test data not found"));
        }
        return connection;
    }

    /**
     * Get Test Data from Sheet
     *
     * @param sheetName
     * @return
     * @throws Exception
     */
    public static Recordset getTestData(String sheetName) throws Exception {
        connection = createAndGetConnection(testDataFile);
        String strQuery = String.format("Select * from %s", sheetName);
        Recordset recordset = connection.executeQuery(strQuery);
        connection.close();
        return recordset;
    }
}