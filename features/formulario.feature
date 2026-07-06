# language: pt

Funcionalidade: Formulario
  Como usuario do aplicativo
  Quero preencher os componentes do formulario
  Para validar a interacao com campos e controles da tela

  Cenario: Preenchimento de formulario
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Forms
    E preencho o campo de texto com "Teste Appium"
    E aciono o switch
    Entao devo ver o texto digitado "Teste Appium"
    E devo ver o switch no estado ativo