# language: pt

Funcionalidade: Fluxos principais do WDIO Demo App
  Como avaliadora do desafio de automacao mobile
  Quero validar os principais componentes do aplicativo
  Para confirmar que a automacao cobre o app mostrado no enunciado

  Cenario: Login com sucesso
    Dado que o aplicativo WDIO Demo esta aberto
    Quando acesso a tela de login
    E informo o usuario "bob@example.com" e senha "10203040"
    Entao devo ver a mensagem de login realizado com sucesso

  Cenario: Cadastro com sucesso
    Dado que o aplicativo WDIO Demo esta aberto
    Quando acesso a tela de login
    E realizo cadastro com usuario "bruna@example.com", senha "10203040" e confirmacao "10203040"
    Entao devo ver a mensagem de cadastro realizado com sucesso

  Cenario: Preenchimento de formulario
    Dado que o aplicativo WDIO Demo esta aberto
    Quando acesso a tela de formulario
    E preencho o campo de texto com "Teste Appium"
    E aciono o switch do formulario
    Entao o texto digitado deve ser exibido no resultado
    E o switch deve mudar para o estado ativo
