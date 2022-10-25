package com.project.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExampleWithExtentReportTest {
    ExtentReports extentReports = new ExtentReports();
    ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("target/report_.html");

    WebDriver driver;

    @BeforeTest
    public void config(){
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("This is my first Report v1.0 ");

        extentReports.attachReporter(extentSparkReporter);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com.ar");
    }

    @AfterTest
    public void tearDown(){
        extentReports.flush();
        driver.quit();
    }

    @Test
    public void TestCase_001(){
        String expectedTitle = "Google";
        ExtentTest extentTest = extentReports.createTest("Verificar que el título sea: "+ expectedTitle)
                .assignAuthor("Jonathan Brull Schroeder")
                .assignCategory("Functional Test Cases")
                .assignDevice("Windows");


        String actualTitle = driver.getTitle();
        extentTest.info("Capture page title as: " + actualTitle);
        if (actualTitle.equals(expectedTitle)){
            extentTest.pass("Título de la página validado y verificado: "+actualTitle);
        } else {
            extentTest.fail("Título de la página falló: "+actualTitle);
        }

        Assert.assertEquals(actualTitle, expectedTitle, "\n **************** \n Title not match \n ****************");
    }

    @Test
    public void TestCase_002() throws IOException {
        String expectedTitle = "Googleeeeeeeee REY";
        ExtentTest extentTest = extentReports.createTest("Verificar que el título sea: "+ expectedTitle)
                .assignAuthor("Jonathan Brull Schroeder")
                .assignCategory("Smoke Test")
                .assignDevice("IOS");

        String actualTitle = driver.getTitle();
        extentTest.info("Capture page title as: " + actualTitle);
        if (actualTitle.equals(expectedTitle)){
            extentTest.pass("Título de la página validado y verificado: "+actualTitle);
        } else {
            extentTest.fail("Título de la página falló: "+actualTitle);
            extentTest.info("Absoule path from capture" + captureScreenshot(driver));
            extentTest.addScreenCaptureFromPath(captureScreenshot(driver));
        }

        Assert.assertEquals(actualTitle, expectedTitle, "\n **************** \n Title not match \n ****************");
    }

    public static String captureScreenshot(WebDriver driver) throws IOException {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destinationFilePath = new File("src/images/screenshot"+System.currentTimeMillis()+".png");

        String absolutePathLocation = destinationFilePath.getAbsolutePath();

        FileUtils.copyFile(srcFile, destinationFilePath);

        return absolutePathLocation;

    }



}
