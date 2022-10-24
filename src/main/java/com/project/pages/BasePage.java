package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }

    protected WebElement find(By locator){
        System.out.println(locator);
        return driver.findElement(locator);
    }

    protected void click(By locator){
        WebElement element = find(locator);
        element.click();
    }

    protected String getText(By locator){
        String text = find(locator).getText();
        System.out.println("Text: "+text);
        return text;
    }
}
