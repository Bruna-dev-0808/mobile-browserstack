# language: pt

@manual
Funcionalidade: Remover produto do carrinho
  Como cliente do aplicativo
  Quero remover produtos do carrinho
  Para manter somente os itens que desejo comprar

  Cenario: Remover produto do carrinho
    Dado que tenho um produto no carrinho
    Quando removo o produto do carrinho
    Entao o carrinho deve ficar vazio
