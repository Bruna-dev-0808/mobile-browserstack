# language: pt

@manual
Funcionalidade: Checkout
  Como cliente do aplicativo
  Quero finalizar uma compra
  Para concluir meu pedido

  Cenario: Finalizar compra com sucesso
    Dado que tenho produtos no carrinho
    Quando informo os dados de entrega e pagamento
    Entao devo ver a confirmacao do pedido
