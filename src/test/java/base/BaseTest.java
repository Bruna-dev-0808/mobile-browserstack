package br.com.brunakferraz.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected static AndroidDriver driver;

    private static final String BS_USERNAME = "brunaferraz_NTjMRS";
    private static final String BS_ACCESS_KEY = "GHqYDei7RqGNa95dxN2W";
    private static final String BS_APP_ID = "bs://9a0a786dad3b642c2a874ba1948ab8571860efd9";
    private static final String BS_URL = "https://" + BS_USERNAME + ":" + BS_ACCESS_KEY + "@hub.browserstack.com/wd/hub";

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println(">>> SETUP EXECUTOU <<<");

        UiAutomator2Options options = new UiAutomator2Options();

        options.setApp(BS_APP_ID);

        // Capabilities específicas do BrowserStack (dispositivo, OS, projeto, etc.)
        options.setCapability("bstack:options", new java.util.HashMap<String, Object>() {{
            put("deviceName", "Google Pixel 8");
            put("osVersion", "14.0");
            put("projectName", "Mobile BrowserStack");
            put("buildName", "Build 1.0");
            put("sessionName", "Primeiro teste");
        }});

        driver = new AndroidDriver(new URL(BS_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterEach
    public void tearDown (){

        if (driver != null) {
            driver.quit();
        }
    }
}