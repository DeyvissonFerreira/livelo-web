package funcionalidades.addCarrinho.pgo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import setup.Capabilities;

public class PgoAdicionarCarrinho {
	
	public PgoAdicionarCarrinho() {
		PageFactory.initElements(Capabilities.getDriver(), this);
	}

	@FindBy(id = "livelo-spinner")
	public WebElement LOADER;

	@FindBy(id = "btn-authorizeCoookies")
	public WebElement COOKIES;
	
	/**
	 * Lista de Campos.
	 */

	@FindBy(css = "#search-container input")
	public WebElement CMP_BUSCA;
	
	@FindBy(css = ".cc-product-item.product-box")
	public WebElement CMP_ITEM_PRODUTO;

	@FindBy(css = "div.form.form--cupom label")
	public WebElement CMP_CUMPOM_DESCONTO;

	@FindBy(css = "#cc-cupom-field")
	public WebElement CMP_INFORMAR_CUMPOM_DESCONTO;

	/**
	 * Lista de Botões.
	 */

	@FindBy(css = "#span-searchIcon")
	public WebElement BTN_LUPA;

	@FindBy(css = "#CC-prodDetails-addToCart button")
	public WebElement BTN_ADICIONAR_AO_CARRINHO;

	@FindBy(css = "a[id^='remove']")
	public WebElement BTN_REMOVER;

	@FindBy(css = "span[id^='plus']")
	public WebElement BTN_AUMENTAR_QUANTIDADE;
	
	@FindBy(css = "span[id^='minus']")
	public WebElement BTN_DIMINUIR_QUANTIDADE;

	@FindBy(css = "#cc-cupom-field + a")
	public WebElement BTN_APLICAR;

	@FindBy(css = "#btClose")
	public WebElement BTN_FECHAR_MODAL;
	
	/**
	 * Lista de Labels.
	 */
	
	@FindBy(css = "#CC-cart-empty .container")
	public WebElement LABEL_EMPTY;

	@FindBy(css = "a[id^='name']")
	public WebElement LABEL_NOME_CART;
	
	@FindBy(css = "span[id^='qtd']")
	public WebElement LABEL_QUANTIDADE_CART;

	@FindBy(css = "span[id^='total']")
	public WebElement LABEL_VALOR_TOTAL_ITEM_CART;

	@FindBy(css = "p[id^='partner']")
	public WebElement LABEL_PARCEIRO_CART;

	@FindBy(css = "div #CC-cart-list div[data-bind^='element']")
	public List<WebElement> LISTA_ITEM_CART;

	@FindBy(css = ".partners-tab__content-price-real .container-price-points")
	public WebElement LABEL_PONTOS_PRODUTO;

	@FindBy(css = ".checkbox span")
	public WebElement LABEL_PONTOS_TOTAL_CARRINHO;

	@FindBy(css = "h2[data-bind='text: product().displayName()']")
	public WebElement LABEL_NOME_PRODUTO;

	@FindBy(css = ".product-details__product-header-info-catalog.header-info-catalog")
	public WebElement TELA_INFOS;

	@FindBy(css = "#CC-cart-list")
	public WebElement TELA_CARRINHO_ITEM;

	@FindBy(css = ".feedback__label")
	public WebElement MSG_ALERTA;

	/**
	 * Dados Produto
	 */
	
	@FindBy(css = "div .card-name div")
	public WebElement NOME_PRODUTO;
	
	@FindBy(css = "div .card-value")
	public WebElement PONTOS_PRODUTO;

	@FindBy(css = "img[class^='card-img']")
	public WebElement IMG_PRODUTO;

	@FindBy(css = "li[role='presentation'].active.partners-tab__nav-item")
	public WebElement PARCEIRO_PRODUTO;
	
	@FindBy(css = "#slct-entertainment option")
	public WebElement PERIODO;
	
	/**
	 * Display
	 */

	@FindBy(css = "p[class='lv-chatbox-menu-logo-open-parag-azul']")
	public WebElement NEED_HELP;
}
