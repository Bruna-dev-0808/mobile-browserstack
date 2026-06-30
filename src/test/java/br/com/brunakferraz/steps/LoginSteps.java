package br.com.brunakferraz.steps;

import br.com.brunakferraz.base.BaseTest;
import br.com.brunakferraz.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Dado("que estou na tela de login")
    public void queEstouNaTelaDeLogin() {
        loginPage = new LoginPage(driver);
        loginPage.acessarTelaLogin();
    }

    @Quando("informo o usuário {string} e senha {string}")
    public void informoUsuarioESenha(String usuario, String senha) {
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarLogin();
    }
}