package br.com.brunakferraz.utils;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void setDriver(AndroidDriver androidDriver) {
        driver = androidDriver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}