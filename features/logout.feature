# language: pt

@manual
Funcionalidade: Logout
  Como usuario autenticado
  Quero sair da minha conta
  Para encerrar minha sessao com seguranca

  Cenario: Logout com sucesso
    Dado que estou autenticado no aplicativo
    Quando aciono a opcao de logout
    Entao devo retornar para a tela inicial sem usuario autenticado
