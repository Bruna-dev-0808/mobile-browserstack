package br.com.brunakferraz.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriverWait wait;

    private final By telaLogin = AppiumBy.accessibilityId("Login-screen");
    private final By abaLogin = AppiumBy.accessibilityId("button-login-container");
    private final By abaCadastro = AppiumBy.accessibilityId("button-sign-up-container");
    private final By email = AppiumBy.accessibilityId("input-email");
    private final By senha = AppiumBy.accessibilityId("input-password");
    private final By confirmarSenha = AppiumBy.accessibilityId("input-repeat-password");
    private final By botaoLogin = AppiumBy.accessibilityId("button-LOGIN");
    private final By botaoCadastrar = AppiumBy.accessibilityId("button-SIGN UP");
    private final By alertaSucesso = AppiumBy.id("android:id/message");
    private final By botaoOkAlerta = AppiumBy.id("android:id/button1");

    public LoginPage(AppiumDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void validarTelaLoginAberta() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(telaLogin));
    }

    public void selecionarLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(abaLogin)).click();
    }

    public void selecionarCadastro() {
        wait.until(ExpectedConditions.elementToBeClickable(abaCadastro)).click();
    }

    public void preencherLogin(String usuario, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(usuario);
        wait.until(ExpectedConditions.visibilityOfElementLocated(senha)).sendKeys(password);
    }

    public void enviarLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoLogin)).click();
    }

    public void preencherCadastro(String usuario, String password, String confirmacao) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(email)).sendKeys(usuario);
        wait.until(ExpectedConditions.visibilityOfElementLocated(senha)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmarSenha)).sendKeys(confirmacao);
    }

    public void enviarCadastro() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoCadastrar)).click();
    }

    public String obterMensagemDeSucesso() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(alertaSucesso)).getText();
    }

    public void fecharAlerta() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoOkAlerta)).click();
    }
}
