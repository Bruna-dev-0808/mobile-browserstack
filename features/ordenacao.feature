# language: pt

@manual
Funcionalidade: Ordenacao
  Como cliente do aplicativo
  Quero ordenar os produtos
  Para comparar itens por preco ou nome

  Cenario: Ordenar produtos por preco
    Dado que estou na lista de produtos
    Quando ordeno os produtos por menor preco
    Entao devo ver os produtos ordenados corretamente
