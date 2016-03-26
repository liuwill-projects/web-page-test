package com.liuwill.test.web;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Administrator on 2016/3/26 0026.
 */
public class GlobalConfig {
    private static Map<String,Properties> propsMap = new HashMap<>();

    private GlobalConfig(){}

    private static Properties loadProperties(String propsName){
        if(!propsMap.containsKey(propsName)){
            Properties theProps = new Properties();
            try {
                //InputStream in = new BufferedInputStream(new FileInputStream("/config/url.properties"));
                InputStream in = ClassLoader.getSystemResourceAsStream("config/"+propsName+".properties");
                theProps.load(in);
                propsMap.put(propsName,theProps);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return propsMap.get(propsName);
    }

    public static String getWebUrl(String urlName){
        Properties urlProps = loadProperties("url");
        if(urlProps == null){
            return "";
        }
        return urlProps.getProperty(urlName);
    }

    public static String getSeleniumConfig(String configName){
        Properties seleniumProps = loadProperties("selenium");
        if(seleniumProps == null){
            return "";
        }
        return seleniumProps.getProperty(configName);
    }

    public static String getEnvConfig(String configName){
        Properties userProps = loadProperties("env");
        if(userProps == null){
            return "";
        }
        return userProps.getProperty(configName);
    }

    public static String getUserConfig(String configName){
        Properties userProps = loadProperties("user");
        if(userProps == null){
            return "";
        }
        return userProps.getProperty(configName);
    }
}
