package br.com.brunakferraz.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public final class DriverManager {

    private static AppiumDriver driver;

    private DriverManager() {
    }

    public static AppiumDriver createDriver() throws MalformedURLException {
        String execution = property("execution", "local").toLowerCase();
        String platform = property("platform", "android").toLowerCase();

        if ("browserstack".equals(execution)) {
            driver = createBrowserStackDriver(platform);
        } else {
            driver = createLocalDriver(platform);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static AppiumDriver createLocalDriver(String platform) throws MalformedURLException {
        URL serverUrl = new URL(property("appium.server.url", "http://127.0.0.1:4723"));

        if ("ios".equals(platform)) {
            XCUITestOptions options = new XCUITestOptions()
                    .setPlatformName("iOS")
                    .setAutomationName("XCUITest")
                    .setDeviceName(property("device.name", "iPhone 15"))
                    .setPlatformVersion(property("platform.version", "17.0"))
                    .setApp(resolveAppPath("ios"));
            return new IOSDriver(serverUrl, options);
        }

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName(property("device.name", "Android Emulator"))
                .setApp(resolveAppPath("android"))
                .autoGrantPermissions();

        String udid = property("udid", "");
        if (!udid.isBlank()) {
            options.setUdid(udid);
        }

        return new AndroidDriver(serverUrl, options);
    }

    private static AppiumDriver createBrowserStackDriver(String platform) throws MalformedURLException {
        String username = requiredProperty("bs.username");
        String accessKey = requiredProperty("bs.accessKey");
        String app = requiredProperty("bs.app");
        URL serverUrl = new URL("https://" + username + ":" + accessKey + "@hub.browserstack.com/wd/hub");

        Map<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("projectName", property("bs.projectName", "Desafio Automacao Mobile"));
        bstackOptions.put("buildName", property("bs.buildName", "wdio-demo-app"));
        bstackOptions.put("sessionName", property("bs.sessionName", "Fluxos principais"));

        if ("ios".equals(platform)) {
            XCUITestOptions options = new XCUITestOptions();
            options.setApp(app);
            options.setCapability("bstack:options", bstackOptions);
            return new IOSDriver(serverUrl, options);
        }

        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp(app);
        options.setCapability("bstack:options", bstackOptions);
        return new AndroidDriver(serverUrl, options);
    }

    private static String resolveAppPath(String platform) {
        String explicitPath = property("app", "");
        if (!explicitPath.isBlank()) {
            return explicitPath;
        }

        String defaultPath = "ios".equals(platform)
                ? "native-demo-app/ios/build/Build/Products/Debug-iphonesimulator/wdiodemoapp.app"
                : "native-demo-app/android/app/build/outputs/apk/debug/app-debug.apk";

        return Path.of(defaultPath).toAbsolutePath().normalize().toString();
    }

    private static String requiredProperty(String key) {
        String value = property(key, "");
        if (value.isBlank()) {
            throw new IllegalArgumentException("Informe a propriedade obrigatoria: " + key);
        }
        return value;
    }

    private static String property(String key, String defaultValue) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }

        String envKey = key.toUpperCase().replace('.', '_');
        String envValue = System.getenv(envKey);
        return envValue == null || envValue.isBlank() ? defaultValue : envValue;
    }
}
