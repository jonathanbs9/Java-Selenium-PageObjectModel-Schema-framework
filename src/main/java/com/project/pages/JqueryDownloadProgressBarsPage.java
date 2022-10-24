package com.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class JqueryDownloadProgressBarsPage extends BasePage {
    private By startDownloadButton = By.xpath("//button[@id='downloadButton']");
    private By progress = By.xpath("//div[@class='progress-label']"); ////div[@id='dialog']//div[@class='progress-label']

    public void clickStartDownloadButton(){
        click(startDownloadButton);
    }

    /** Waiting 30 secs for an element to be present on the stage,
     *  checking for it's presence every 100 millisecs.
     */
    public void performFluentWait(){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                    WebElement progressElement =  find(progress);
                    String progressBarText = progressElement.getText();
                    if (progressBarText.equals("Complete!")) {
                        System.out.println(" ============================== \n Progress bar is completed! =) \n ============================= ");
                        return progressElement;
                    }
                    else {
                        System.out.println(progressBarText);
                        return null;
                    }
            }
        });

    }
}
