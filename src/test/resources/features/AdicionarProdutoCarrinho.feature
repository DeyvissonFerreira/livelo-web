@AdicionarProdutoCarrinho
Feature: Adicionar Produto ao Carrinho

  Background: Usuario navegando atraves da home
    Given Desejo acessar a url "https://www.livelo.com.br/home"
    Then Devo ver a tela inicial do sistema
   
   Scenario Outline: Adicionar Produto ao Carrinho
   When Preencho o campo de Busca com a opcao "<produtoPesquisa>"
   And Clico no botao Pesquisa
   And Seleciono o Produto
   And Valido a quantidade de pontos necessarios e o nome do Produto "<produtoValidacao>"
   And Clico no botao Adicionar ao Carrinho
   Then O Carrinho e atualizado com o produto adicionado e Valido as informacao do Produto
   
   Examples:
   | produtoPesquisa                                                      | produtoValidacao |
   | Poltrona Nalin Milla Costurada Com Pe de Aluminio 259A - Prata/Cinza | Poltrona Nalin Milla Costurada |
   | Cortina para Sala Vizapi Palm Springs Homes 140x240cm - 1 Peça       | Cortina para Sala Vizapi Palm Springs Homes 140x240cm |
