package com.project.tests;

import com.project.pages.BootstrapProgressBarPage;
import com.project.pages.DynamicDataLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicWaitsTest extends BaseTest{
    @Test
    public void explicitWaitTest001(){


        DynamicDataLoadingPage dynamicDataLoadingPage = homePage.clickDynamicDataLoading();
        dynamicDataLoadingPage.clickGetNewUserButton();

        dynamicDataLoadingPage.performWaitForImage();
        System.out.println(dynamicDataLoadingPage.isImageDisplayed());


        Assert.assertTrue(dynamicDataLoadingPage.isImageDisplayed(), "Image not displayed");
    }
}
