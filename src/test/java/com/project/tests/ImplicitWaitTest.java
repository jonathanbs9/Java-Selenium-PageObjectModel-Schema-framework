package com.project.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitTest{
    @Test
    public void implicitWaitTest001(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver2.get("http://the-internet.herokuapp.com/dynamic_loading");

        driver2.findElement(By.linkText("Example 2: Element rendered after the fact")).click();
        driver2.findElement(By.xpath("//button[contains(text(),'Start')]")).click();

        By helloWorld = By.xpath("//div[@id='finish']//h4");
        WebElement helloWorldText = driver2.findElement(helloWorld);
        String actualText = helloWorldText.getText();

        Assert.assertEquals(actualText, "Hello World!", "Message is not 'Hello World!' ");

    }
}
