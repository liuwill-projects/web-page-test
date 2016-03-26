package com.liuwill.testng.web.search;

import com.liuwill.test.web.GlobalConfig;
import com.liuwill.test.web.page.search.GoogleSearchPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/3/26 0026.
 */
public class WhenAUserSearchesOnGoogle {
    private GoogleSearchPage page;
    private String chromeDriverPath;

    public void initChrome(){
        chromeDriverPath = GlobalConfig.getSeleniumConfig("selenium.chromeDriverPath");
        System.setProperty("webdriver.chrome.driver", this.chromeDriverPath);
    }

    @BeforeClass(groups = {"google"})
    public void openTheBrowser() {
        initChrome();

        page = PageFactory.initElements(new ChromeDriver(), GoogleSearchPage.class);
        page.open(GlobalConfig.getWebUrl("google.search"));
    }

    @AfterClass(groups = {"google"})
    public void closeTheBrowser() {
        page.close();
    }

    @Test(groups = {"google"})
    public void whenTheUserSearchesForSeleniumTheResultPageTitleShouldContainCats() {
        page.searchFor("selenium");
        System.out.println(page.getTitle());
        Assert.assertTrue(page.getTitle().contains("selenium"));
    }
}
