package com.project.tests;


import com.project.pages.BootstrapProgressBarPage;
import com.project.pages.HomePage;
import com.project.pages.JqueryDownloadProgressBarsPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FluentWaitTest extends  BaseTest{

    @Test
    public void TestFluentWait001(){

        JqueryDownloadProgressBarsPage jqueryDownloadProgressBarsPage = homePage.clickJqueryDownloadProgressBars();
        jqueryDownloadProgressBarsPage.clickStartDownloadButton();
        jqueryDownloadProgressBarsPage.performFluentWait();

    }
}
