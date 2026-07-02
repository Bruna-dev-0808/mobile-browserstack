# language: pt

@manual
Funcionalidade: Carrinho
  Como cliente do aplicativo
  Quero adicionar produtos ao carrinho
  Para preparar minha compra

  Cenario: Adicionar produto ao carrinho
    Dado que estou nos detalhes de um produto
    Quando adiciono o produto ao carrinho
    Entao devo ver o produto listado no carrinho
