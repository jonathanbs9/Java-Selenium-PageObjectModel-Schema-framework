package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicDataLoadingPage extends BasePage {
    private By getNewUserButton = By.xpath("//button[@id='save']");
    private By user = By.id("loading");
    private By image = By.xpath("//div[@id='loading']//img");

    public void clickGetNewUserButton(){
        click(getNewUserButton);
    }

    public boolean isImageDisplayed(){
        return find(image).isDisplayed();
    }

    public void performWaitForImage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(image));
    }
}
