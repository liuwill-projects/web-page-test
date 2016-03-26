package com.liuwill.testng.web;

import com.liuwill.test.web.GlobalConfig;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2016/3/26 0026.
 */
public class GlobalConfigTest {

    @Test(groups = {"config"})
    public void testSeleniumConfig(){
        System.out.println(GlobalConfig.getSeleniumConfig("selenium.chromeDriverPath"));
        Assert.assertTrue(GlobalConfig.getSeleniumConfig("selenium.chromeDriverPath").contains("chrome"));

        System.out.println("Selenium Config Success");
    }

    @Test(groups = {"config"})
    public void testEnvConfig(){
        System.out.println(GlobalConfig.getEnvConfig("env"));
        Assert.assertTrue(GlobalConfig.getEnvConfig("env").contains("test"));

        System.out.println("Env Config Success");
    }

    @Test(groups = {"config"})
    public void testUserConfig(){
        System.out.println(GlobalConfig.getUserConfig("liuwill.password"));
        Assert.assertEquals(GlobalConfig.getUserConfig("liuwill.username"), "liuwill");

        System.out.println("User Config Success");
    }
}
