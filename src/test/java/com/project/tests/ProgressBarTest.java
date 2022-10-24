package com.project.tests;

import com.project.pages.BootstrapProgressBarPage;

import com.project.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProgressBarTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();
    BootstrapProgressBarPage progressBarPage = new BootstrapProgressBarPage();


    @Test
    public void testProgressBarPercentage(){

        progressBarPage = homePage.clickBootstrapProgressBar();
        progressBarPage.clickStartDownloadButton();
        String actualMessage = progressBarPage.getCompletedMessage();
        String actualPercentage = progressBarPage.getProgressBarPercentage();
        String expectedMessage = "Dowload completed!";
        String expectedPercentage = "100%";

        softAssert.assertEquals(actualMessage, expectedMessage, "\n The Message is not complete! \n");
        softAssert.assertEquals(actualPercentage, expectedPercentage, "\n The percentage is not %100 \n" );

        //Assert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }
}
