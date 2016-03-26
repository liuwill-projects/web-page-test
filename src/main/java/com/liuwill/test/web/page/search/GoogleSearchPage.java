package com.liuwill.test.web.page.search;

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

    }

    public void searchFor(String searchTerm) {
        searchField.sendKeys(searchTerm);

        System.out.println(searchTerm);
        System.out.println(searchField.getAttribute("id"));
        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        searchField.sendKeys(Keys.ENTER);
        //searchButton.click();
        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void typeSearchTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void clickOnSearch() {
        searchButton.click();
    }
}
