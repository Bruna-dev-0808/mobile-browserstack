package br.com.brunakferraz.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private AndroidDriver driver;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private By menu = AppiumBy.accessibilityId("open menu");
    private By loginMenu = AppiumBy.accessibilityId("menu item log in");
    private By usuario = AppiumBy.accessibilityId("Username input field");
    private By senha = AppiumBy.accessibilityId("Password input field");
    private By botaoLogin = AppiumBy.accessibilityId("Login button");

    public void acessarTelaLogin() {
        driver.findElement(menu).click();
        driver.findElement(loginMenu).click();
    }

    public void preencherUsuario(String user) {
        driver.findElement(usuario).sendKeys(user);
    }

    public void preencherSenha(String pass) {
        driver.findElement(senha).sendKeys(pass);
    }

    public void clicarLogin() {
        driver.findElement(botaoLogin).click();
    }
}