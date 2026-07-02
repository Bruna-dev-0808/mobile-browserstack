package br.com.brunakferraz.base;

import io.appium.java_client.AppiumDriver;

public class BaseTest {
    protected static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void setDriver(AppiumDriver appiumDriver) {
        driver = appiumDriver;
    }
}
