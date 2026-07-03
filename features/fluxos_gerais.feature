# language: pt

Funcionalidade: Fluxos gerais do aplicativo
  Como avaliadora do desafio mobile
  Quero validar formulario, favoritos e navegacao
  Para cobrir os fluxos principais exibidos nos prints

  Cenario: Preencher formulario completo com botao Active
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Forms
    E preencho o campo de texto com "Teste Appium"
    E aciono o switch
    E seleciono no dropdown a opcao "webdriver.io is awesome"
    E clico no botao "Active"
    Entao devo ver o texto digitado "Teste Appium"
    E devo ver o switch no estado ativo
    E devo ver a opcao "webdriver.io is awesome" selecionada no dropdown

  Cenario: Preencher formulario completo com botao Inactive
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Forms
    E preencho o campo de texto com "Teste Appium"
    E aciono o switch
    E seleciono no dropdown a opcao "webdriver.io is awesome"
    E clico no botao "Inactive"
    Entao devo ver o texto digitado "Teste Appium"
    E devo ver o switch no estado ativo
    E devo ver a opcao "webdriver.io is awesome" selecionada no dropdown

  Cenario: Favoritar e desfavoritar funcionalidades do menu
    Dado que estou na Home do aplicativo
    Quando favorito a funcionalidade "Webview"
    E favorito a funcionalidade "Login"
    E favorito a funcionalidade "Forms"
    E favorito a funcionalidade "Swipe"
    E favorito a funcionalidade "Drag"
    E favorito a funcionalidade "Permissions"
    E favorito a funcionalidade "Data"
    E desfavorito a funcionalidade "Webview"
    E desfavorito a funcionalidade "Login"
    E desfavorito a funcionalidade "Forms"
    E desfavorito a funcionalidade "Swipe"
    E desfavorito a funcionalidade "Drag"
    E desfavorito a funcionalidade "Permissions"
    E desfavorito a funcionalidade "Data"
    Entao devo visualizar a funcionalidade "Home"

  Cenario: Abrir funcionalidade Home
    Dado que estou na Home do aplicativo
    Quando abro a funcionalidade "Home"
    Entao devo visualizar a funcionalidade "Home"

  Cenario: Abrir funcionalidade Webview
    Dado que estou na Home do aplicativo
    Quando abro a funcionalidade "Webview"
    Entao devo visualizar a funcionalidade "Webview"

  Cenario: Abrir funcionalidade Login
    Dado que estou na Home do aplicativo
    Quando abro a funcionalidade "Login"
    Entao devo visualizar a funcionalidade "Login"

  Cenario: Abrir funcionalidade Forms
    Dado que estou na Home do aplicativo
    Quando abro a funcionalidade "Forms"
    Entao devo visualizar a funcionalidade "Forms"

  Cenario: Abrir funcionalidade Swipe
    Dado que estou na Home do aplicativo
    Quando abro a funcionalidade "Swipe"
    Entao devo visualizar a funcionalidade "Swipe"

  Cenario: Abrir funcionalidade Drag
    Dado que estou na Home do aplicativo
    Quando abro a funcionalidade "Drag"
    Entao devo visualizar a funcionalidade "Drag"

  Cenario: Abrir funcionalidade Permissions
    Dado que estou na Home do aplicativo
    Quando abro a funcionalidade "Permissions"
    Entao devo visualizar a funcionalidade "Permissions"

  Cenario: Abrir funcionalidade Data
    Dado que estou na Home do aplicativo
    Quando abro a funcionalidade "Data"
    Entao devo visualizar a funcionalidade "Data"
