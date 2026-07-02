package br.com.brunakferraz.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriverWait wait;

    private final By home = AppiumBy.accessibilityId("Home-screen");
    private final By menu = AppiumBy.accessibilityId("Menu");
    private final By itemLogin = AppiumBy.accessibilityId("side-menu-item-login");
    private final By itemForms = AppiumBy.accessibilityId("side-menu-item-forms");

    public HomePage(AppiumDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void validarHomeAberta() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(home));
    }

    public void abrirLogin() {
        abrirMenu();
        wait.until(ExpectedConditions.elementToBeClickable(itemLogin)).click();
    }

    public void abrirForms() {
        abrirMenu();
        wait.until(ExpectedConditions.elementToBeClickable(itemForms)).click();
    }

    private void abrirMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(menu)).click();
    }
}
