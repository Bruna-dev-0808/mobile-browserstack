# language: pt

@manual
Funcionalidade: Filtro
  Como cliente do aplicativo
  Quero filtrar produtos
  Para encontrar itens conforme minha necessidade

  Cenario: Filtrar produtos por categoria
    Dado que estou na lista de produtos
    Quando aplico um filtro de categoria
    Entao devo ver somente produtos da categoria selecionada
