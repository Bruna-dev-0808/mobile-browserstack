package br.com.brunakferraz.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormsPage {

    private final WebDriverWait wait;

    private final By telaForms = AppiumBy.accessibilityId("Forms-screen");
    private final By campoTexto = AppiumBy.accessibilityId("text-input");
    private final By resultadoTexto = AppiumBy.accessibilityId("input-text-result");
    private final By switchCampo = AppiumBy.accessibilityId("switch");
    private final By textoSwitch = AppiumBy.accessibilityId("switch-text");

    public FormsPage(AppiumDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void validarTelaFormsAberta() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(telaForms));
    }

    public void digitarTexto(String texto) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoTexto)).sendKeys(texto);
    }

    public String obterTextoDigitado() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultadoTexto)).getText();
    }

    public void acionarSwitch() {
        wait.until(ExpectedConditions.elementToBeClickable(switchCampo)).click();
    }

    public String obterTextoDoSwitch() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textoSwitch)).getText();
    }
}
