package com.liuwill.test.web.page.search;

import com.liuwill.test.web.GlobalConfig;
import com.liuwill.test.web.page.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 2016/3/26 0026.
 */
public class GoogleSearchPage extends BasePage{
    @FindBy(name="q")
    private WebElement searchField;

    @FindBy(name="btnK")
    private WebElement searchButton;

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
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

    @Override
    public void open() {
        webDriver.get(GlobalConfig.getWebUrl("google.search"));
    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);

        System.out.println(searchTerm);
        System.out.println(searchField.getAttribute("id"));
        pauseWait(1111);
        searchField.sendKeys(Keys.ENTER);
        //searchButton.click();
        pauseWait(1111);
    }

    private void pauseWait(int miliSecond){
        try {
            Thread.sleep(miliSecond);
        } catch (InterruptedException e) {}
    }

    public void typeSearchTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void clickOnSearch() {
        searchButton.click();
    }
}
