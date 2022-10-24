package com.project.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    private By bootstrapProgressBar = By.linkText("Bootstrap Progress bar");
    private By dynamicDataLoading = By.linkText("Dynamic Data Loading");
    private By jqueryDownloadProgressBars = By.linkText("JQuery Download Progress bars");

    public BootstrapProgressBarPage clickBootstrapProgressBar(){
        click(bootstrapProgressBar);
        return new BootstrapProgressBarPage();
    }

    public DynamicDataLoadingPage clickDynamicDataLoading(){
        click(dynamicDataLoading);
        return new DynamicDataLoadingPage();
    }

    public JqueryDownloadProgressBarsPage clickJqueryDownloadProgressBars(){
        click(jqueryDownloadProgressBars);
        return new JqueryDownloadProgressBarsPage();
    }
}
