package com.saucedemo.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static String reportBaseDirectory;
    private static ExtentReports extent;
    private static final String fileSeparator = System.getProperty("file.separator");
    public static final String REPORT_FILE_PATH = System.getProperty("user.dir") +
            fileSeparator + "Reports";

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static void createInstance() {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
        ExtentManager.initDirectories();
        setReportBaseDirectory(REPORT_FILE_PATH);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
                System.getProperty("user.dir") + "/Reports/" + timeStamp + "-" + "SauceDemo_Report.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setJS("$('.brand-logo').text('FarEye');");
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java", System.getProperty("java.specification.version"));
        extent.setSystemInfo("User", System.getProperty("user.name"));
    }

    public synchronized static void setReportBaseDirectory(String reportBaseDirectory) {
        ExtentManager.reportBaseDirectory = reportBaseDirectory;
    }

    public static void initDirectories() {
        try {
            createFolder(REPORT_FILE_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createFolder(String folderPath) {
        File file = new File(folderPath);
        if (!file.exists()) file.mkdirs();
    }
}