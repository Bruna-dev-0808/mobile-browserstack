# language: pt

Funcionalidade: Fluxos principais do WDIO Demo App
  Como avaliadora do desafio de automacao mobile
  Quero validar funcionalidades principais do app
  Para confirmar a cobertura solicitada no teste

  Cenario: Login com sucesso
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Login
    E faco login com usuario "bob@example.com" e senha "10203040"
    Entao devo ver a mensagem "You are logged in!"

  Cenario: Cadastro com sucesso
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Login
    E faco cadastro com usuario "bruna@example.com", senha "10203040" e confirmacao "10203040"
    Entao devo ver a mensagem "You successfully signed up!"

  Cenario: Preenchimento de formulario
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Forms
    E preencho o campo de texto com "Teste Appium"
    E aciono o switch
    Entao devo ver o texto digitado "Teste Appium"
    E devo ver o switch no estado ativo
