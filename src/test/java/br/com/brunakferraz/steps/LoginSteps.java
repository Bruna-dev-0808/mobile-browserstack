package br.com.brunakferraz.steps;

import br.com.brunakferraz.base.BaseTest;
import br.com.brunakferraz.pages.HomePage;
import br.com.brunakferraz.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;

    @Dado("que o aplicativo WDIO Demo esta aberto")
    public void queOAplicativoWdioDemoEstaAberto() {
        homePage = new HomePage(BaseTest.getDriver());
        homePage.validarHomeAberta();
    }

    @Quando("acesso a tela de login")
    public void acessoATelaDeLogin() {
        homePage.abrirLogin();
        loginPage = new LoginPage(BaseTest.getDriver());
        loginPage.validarTelaLoginAberta();
    }

    @Quando("informo o usuario {string} e senha {string}")
    public void informoUsuarioESenha(String usuario, String senha) {
        loginPage.selecionarLogin();
        loginPage.preencherLogin(usuario, senha);
        loginPage.enviarLogin();
    }

    @Quando("realizo cadastro com usuario {string}, senha {string} e confirmacao {string}")
    public void realizoCadastro(String usuario, String senha, String confirmacao) {
        loginPage.selecionarCadastro();
        loginPage.preencherCadastro(usuario, senha, confirmacao);
        loginPage.enviarCadastro();
    }

    @Entao("devo ver a mensagem de login realizado com sucesso")
    public void devoVerMensagemDeLoginRealizadoComSucesso() {
        assertEquals("You are logged in!", loginPage.obterMensagemDeSucesso());
        loginPage.fecharAlerta();
    }

    @Entao("devo ver a mensagem de cadastro realizado com sucesso")
    public void devoVerMensagemDeCadastroRealizadoComSucesso() {
        assertTrue(loginPage.obterMensagemDeSucesso().contains("successfully signed up"));
        loginPage.fecharAlerta();
    }
}
