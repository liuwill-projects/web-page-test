package com.liuwill.test.web.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2016/3/26 0026.
 */
public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void open(String url) {
        webDriver.get(url);
    }

    public void close() {
        webDriver.quit();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public abstract void open();
}
