package br.com.brunakferraz.steps;

import br.com.brunakferraz.base.BaseTest;
import br.com.brunakferraz.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp() throws Exception {
        BaseTest.setDriver(DriverManager.createDriver());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (BaseTest.getDriver() != null) {
            byte[] screenshot = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverManager.quitDriver();
    }
}
