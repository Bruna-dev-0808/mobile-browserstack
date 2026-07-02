package br.com.brunakferraz.steps;

import br.com.brunakferraz.base.BaseTest;
import br.com.brunakferraz.pages.FormsPage;
import br.com.brunakferraz.pages.HomePage;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormsSteps {

    private FormsPage formsPage;

    @Quando("acesso a tela de formulario")
    public void acessoATelaDeFormulario() {
        HomePage homePage = new HomePage(BaseTest.getDriver());
        homePage.abrirForms();
        formsPage = new FormsPage(BaseTest.getDriver());
        formsPage.validarTelaFormsAberta();
    }

    @Quando("preencho o campo de texto com {string}")
    public void preenchoOCampoDeTextoCom(String texto) {
        formsPage.digitarTexto(texto);
    }

    @Quando("aciono o switch do formulario")
    public void acionoOSwitchDoFormulario() {
        formsPage.acionarSwitch();
    }

    @Entao("o texto digitado deve ser exibido no resultado")
    public void oTextoDigitadoDeveSerExibidoNoResultado() {
        assertEquals("Teste Appium", formsPage.obterTextoDigitado());
    }

    @Entao("o switch deve mudar para o estado ativo")
    public void oSwitchDeveMudarParaOEstadoAtivo() {
        assertEquals("Click to turn the switch OFF", formsPage.obterTextoDoSwitch());
    }
}
