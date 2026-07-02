# language: pt

Funcionalidade: Login
  Como usuario do aplicativo
  Quero acessar minha conta
  Para usar as funcionalidades autenticadas

  Cenario: Login com sucesso
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Login
    E faco login com usuario "bob@example.com" e senha "10203040"
    Entao devo ver a mensagem "You are logged in!"
