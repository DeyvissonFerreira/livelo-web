package funcionalidades.addCarrinho.help;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import funcionalidades.addCarrinho.model.Produto;
import funcionalidades.addCarrinho.pgo.PgoAdicionarCarrinho;
import setup.Suporte;

public class HelpAdicionarCarrinho extends Suporte{
	
	PgoAdicionarCarrinho pg;
	public static List<Produto> produto = new ArrayList<>();;
	
	public HelpAdicionarCarrinho() {
		pg = new PgoAdicionarCarrinho();
	}

	public void aguardarChatSumir() {
		aguardaElemento(ExpectedConditions.attributeContains(pg.NEED_HELP, "style", "display: none;"));
	}
	
	public void aguardaTelaInicial() {
		aguardaElemento(ExpectedConditions.visibilityOf(pg.CMP_BUSCA));
		aguardarChatSumir();
		
		try {
			pg.COOKIES.click();
		} catch (NoSuchElementException e) {
			System.out.println("\n Cookies Aceitos!");
		}
	}
	
	public void preencherBusca(String valor) {
		preencheCampo(pg.CMP_BUSCA, valor);
	}
	
	public void acionarLupa() {
		click(pg.BTN_LUPA);
	}
	
	public void selecionarProduto() {
		aguardaLoader();
		aguardarChatSumir();
		aguardaElemento(ExpectedConditions.visibilityOf(pg.IMG_PRODUTO));
		produto.add(new Produto(pg.NOME_PRODUTO.getText(), pg.PONTOS_PRODUTO.getText()));
		click(pg.CMP_ITEM_PRODUTO);
	}
	
	public void validarDadosProdutoConfirmacao(String nome) {
		Produto produto = HelpAdicionarCarrinho.produto.stream().filter(p -> p.nomeProduto.contains(nome)).findFirst().get();
		Produto.setMaxPoint(Integer.parseInt(produto.pontosProduto.replaceAll("[^\\d]", "")));
		aguardaElemento(ExpectedConditions.visibilityOf(pg.TELA_INFOS));
		verificacao(pg.LABEL_NOME_PRODUTO, produto.nomeProduto);
		verificacao(pg.LABEL_PONTOS_PRODUTO, produto.pontosProduto);
		obtemDadosAdicionaisProduto(produto);
	}
	
	public void acionarAdicionarCarrinho() {
		aguardaLoader();
		click(pg.BTN_ADICIONAR_AO_CARRINHO);
	}
	
	public void validarDadosProdutoCarrinho() {
		aguardaLoader();
		aguardaElemento(ExpectedConditions.visibilityOfAllElements(pg.LISTA_ITEM_CART));
		
		pg.LISTA_ITEM_CART.stream().forEach(i -> {
			Produto produto = retornaProduto(i.findElement(By.cssSelector(obterSeletor(pg.LABEL_NOME_CART))).getText());
			verificacao(i.findElement(By.cssSelector(obterSeletor(pg.LABEL_NOME_CART))), produto.nomeProduto);
			verificacao(i.findElement(By.cssSelector(obterSeletor(pg.LABEL_PARCEIRO_CART))), "Parceiro: ".concat(produto.parceiroProduto));
			verificacao(i.findElement(By.cssSelector(obterSeletor(pg.LABEL_QUANTIDADE_CART))), String.valueOf(produto.quantidade));
			verificacao(i.findElement(By.cssSelector(obterSeletor(pg.LABEL_VALOR_TOTAL_ITEM_CART))), produto.pontosProduto);
		});
	
		verificacao(pg.LABEL_PONTOS_TOTAL_CARRINHO, Produto.getMaxPoint());
	}
	
	private void obtemDadosAdicionaisProduto(Produto produto) {
		produto.parceiroProduto = pg.PARCEIRO_PRODUTO.getAttribute("data-gtm-event-label");
	}
	
	private Produto retornaProduto(String nome) {
		return HelpAdicionarCarrinho.produto.stream().filter(p -> p.nomeProduto.equalsIgnoreCase(nome)).findFirst().get();
	}
}