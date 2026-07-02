# language: pt

Funcionalidade: Cadastro
  Como novo usuario do aplicativo
  Quero criar uma conta
  Para acessar as funcionalidades do app

  Cenario: Cadastro com sucesso
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Login
    E faco cadastro com usuario "bruna@example.com", senha "10203040" e confirmacao "10203040"
    Entao devo ver a mensagem "You successfully signed up!"
