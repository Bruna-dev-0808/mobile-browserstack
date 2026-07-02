# language: pt

@manual
Funcionalidade: Produtos
  Como cliente do aplicativo
  Quero consultar a lista de produtos
  Para escolher itens para compra

  Cenario: Visualizar lista de produtos
    Dado que estou autenticado no aplicativo
    Quando acesso a tela de produtos
    Entao devo ver a lista de produtos disponiveis
