package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import funcionalidades.addCarrinho.help.HelpAdicionarCarrinho;
import setup.Capabilities;

public class StepDefinitions {

	HelpAdicionarCarrinho hp;
	
	public StepDefinitions() {
		hp = new HelpAdicionarCarrinho();
	}
	
    @Given("^Desejo acessar a url \"([^\"]*)\"$")
    public void acessarPagina(String url) throws Throwable {
    	Capabilities.acessaAplicacao(url);
    }
    
    @Then("^Devo ver a tela inicial do sistema$")
    public void aguardarTelaInicial() throws Throwable {
    	hp.aguardaTelaInicial();
    }
    
    @When("^Preencho o campo de Busca com a opcao \"([^\"]*)\"$")
    public void preencherCampoBuscar(String opcao) throws Throwable {
    	hp.preencherBusca(opcao);
    }
    
    @And("^Informo um Cupom Invalido \"([^\"]*)\"$")
    public void preencherCumpo(String valor) throws Throwable {
    	hp.preencherCupomDesconto(valor);
    }
    
    @And("^Clico na operacao \"([^\"]*)\"$")
    public void acionarOperacao(String operacao) throws Throwable {
    	if (operacao.equalsIgnoreCase("aumentar"))
    		hp.acionarAumentarQuantidade();
    	else
    		hp.acionarDiminuirQuantidade();
    }
    
    @And("^Clico no botao Pesquisa$")
    public void acionarPesquisar() throws Throwable {
    	hp.acionarLupa();
    }
    
    @And("^Clico no campo Cumpom de desconto$")
    public void acionarCupomDesconto() throws Throwable {
    	hp.acionarCupomDesconto();
    }
    
    @And("^Seleciono o Produto$")
    public void selecionarProduto() throws Throwable {
    	hp.selecionarProduto();
    }
    
    @And("^Clico no botao Remover$")
    public void acionarRemover() throws Throwable {
    	hp.acionarRemover();
    }
    
    @And("^Clico no botao Adicionar ao Carrinho$")
    public void acionarAdicionarCarrinho() throws Throwable {
    	hp.acionarAdicionarCarrinho();
    }
    
    @And("^Clico no botao Aplicar$")
    public void acionarAplicar() throws Throwable {
    	hp.acionarAplicar();
    }
    
    @Then("^Valido a quantidade de pontos necessarios e o nome do Produto \"([^\"]*)\"$")
    public void validarNomePontosProdutoConfirmacao(String nome) throws Throwable {
    	hp.validarDadosProdutoConfirmacao(nome);
    }
    
    @Then("^O Carrinho e atualizado com o produto adicionado e Valido as informacao do Produto$")
    public void validarNomePontosProdutoCarrinho() throws Throwable {
    	hp.validarDadosProdutoCarrinho();
    }
    
    @Then("^Valido as alteracoes do produto$")
    public void validarAlteracaoQuantidadeCarrinho() throws Throwable {
    	hp.validarDadosProdutoCarrinho();
    }
    
    @Then("^Valido a mensagem de excecao apresentada \"([^\"]*)\"$")
    public void validarMensagem(String mensagem) throws Throwable {
    	hp.validarMensagem(mensagem);
    }
    
    @Then("^o Carrinho e esvaziado e valido a label apresentada \"([^\"]*)\"$")
    public void validarEmptyState(String mensagem) throws Throwable {
    	hp.validarEmptyState(mensagem);
    }
}