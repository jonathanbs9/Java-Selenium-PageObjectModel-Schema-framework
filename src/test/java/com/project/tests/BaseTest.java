package com.project.tests;

import com.project.pages.BasePage;
import com.project.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;


public class BaseTest {
    private  WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;

    private final String AUT_URL = "https://www.lambdatest.com/selenium-playground/";


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void loadApp(){
        driver.get(AUT_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        homePage = new HomePage();
    }

    @AfterMethod
    public void takeScreenshotForFailure(ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;

            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(new File(System.getProperty("user.dir")) + "/resources/screenshots" + testResult.getName() + ".png");

            try {
                FileHandler.copy(source, destination);

            } catch (IOException ioException){
                ioException.printStackTrace();
            }
        }
    }


}
