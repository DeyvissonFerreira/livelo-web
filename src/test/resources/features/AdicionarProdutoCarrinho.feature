@AdicionarProdutoCarrinho
Feature: Adicionar Produto ao Carrinho

  Background: Usuario navegando atraves da home
    Given Desejo acessar a url "https://www.livelo.com.br/home"
    Then Devo ver a tela inicial do sistema
   
   Scenario: Adicionar Produto ao Carrinho
   When Preencho o campo de Busca com a opcao "Poltrona Nalin Milla Costurada Com Pe de Aluminio 259A - Prata/Cinza"
   And Clico no botao Pesquisa
   And Seleciono o Produto
   And Valido a quantidade de pontos necessarios e o nome do Produto "Poltrona Nalin Milla Costurada"
   And Clico no botao Adicionar ao Carrinho
   Then O Carrinho e atualizado com o produto adicionado e Valido as informacao do Produto
   
   Scenario: Adicionar Mais de um Produto ao Carrinho
   When Preencho o campo de Busca com a opcao "Cortina para Sala Vizapi Palm Springs Homes 140x240cm - 1 Peça"
   And Clico no botao Pesquisa
   And Seleciono o Produto
   And Valido a quantidade de pontos necessarios e o nome do Produto "Cortina para Sala Vizapi Palm Springs Homes 140x240cm"
   And Clico no botao Adicionar ao Carrinho
   Then O Carrinho e atualizado com o produto adicionado e Valido as informacao do Produto
