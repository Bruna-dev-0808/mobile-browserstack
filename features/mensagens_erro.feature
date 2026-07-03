# language: pt

Funcionalidade: Mensagens de erro
  Como usuario do aplicativo
  Quero receber mensagens claras quando informo dados invalidos
  Para corrigir o preenchimento antes de continuar

  Cenario: Validar erro ao tentar login sem credenciais
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Login
    E tento fazer login sem informar email e senha
    Entao devo ver a mensagem de validacao "Please enter a valid email address"

  Cenario: Validar erro ao cadastrar com senhas diferentes
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Login
    E tento fazer cadastro com usuario "bruna@example.com", senha "10203040" e confirmacao "10203041"
    Entao devo ver a mensagem de validacao "Please enter the same password"

  Cenario: Validar seguranca ao tentar login com senha errada
    Dado que estou na Home do aplicativo
    Quando acesso a tela de Login
    E faco login com usuario "bob@example.com" e senha "senha_errada"
    Entao devo ver a mensagem "Provided credentials do not match any user in this service."
