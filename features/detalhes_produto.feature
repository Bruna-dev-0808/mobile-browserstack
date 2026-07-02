# language: pt

@manual
Funcionalidade: Detalhes do produto
  Como cliente do aplicativo
  Quero consultar detalhes de um produto
  Para validar preco, descricao e disponibilidade antes da compra

  Cenario: Visualizar detalhes do produto
    Dado que estou na lista de produtos
    Quando seleciono um produto
    Entao devo ver nome, preco e descricao do produto
