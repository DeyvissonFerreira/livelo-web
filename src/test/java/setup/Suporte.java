package setup;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import funcionalidades.addCarrinho.pgo.PgoAdicionarCarrinho;

public class Suporte {

	/**
	 * Aguardo o Elemento ser carregado conforme uma expectativa. Tempo definido por
	 * padrao
	 * 
	 * @param expect - ExpectedCondition<'WebElement'>
	 */
	protected WebElement aguardaElemento(ExpectedCondition<WebElement> expect) {
		return Capabilities.getWait().until(ExpectedConditions.refreshed(expect));
	}
	
	public void aguardaLoader() {
		aguardaElemento(ExpectedConditions.attributeContains(new PgoAdicionarCarrinho().LOADER, "style", "display: none;"));
	}
	
	
	/**
	 * Aguardo o Elemento HTML ser carregado na tela podendo ser como entrada um
	 * ExpectedCondition<'Boolean'>. Tempo definido por padrao no CrossBrowser.
	 * 
	 * @param expect - tem que ser diferente de ExpectedCondition<'WebElement'>
	 */
	protected void aguardaElemento(Function<WebDriver, ?> expect) {
		Capabilities.getWait().until(ExpectedConditions.refreshed((ExpectedCondition<?>) expect));
	}
	
	
	/**
	 * Click no elemento
	 * 
	 * @param elemento
	 */
	protected void click(WebElement elemento) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(elemento)).click();
	}
	
	/**
	 * Click no elemento
	 * 
	 * @param elemento
	 */
	protected void limparCampo(WebElement elemento) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(elemento)).clear();
	}

	/**
	 * Preenche campo
	 * 
	 * @param elemento
	 * @param valor
	 */
	protected void preencheCampo(WebElement elemento, Object valor) {
		aguardaElemento(ExpectedConditions.elementToBeClickable(elemento)).sendKeys((String) valor);
	}
	
	
	/**
	 * Verificacao geral
	 * 
	 */
	protected void verificacao(WebElement elemento, String check) {
		aguardaElemento(ExpectedConditions.visibilityOf(elemento));
		System.out.println("\nVALIDACAO -> ".concat(elemento.getText()).concat(" Igual a ").concat(check));
		assertTrue(elemento.getText().equalsIgnoreCase(check));
	}
	
	protected void verificacao(WebElement elemento, String atributo, String check) {
		aguardaElemento(ExpectedConditions.visibilityOf(elemento));
		System.out.println("\nVALIDACAO -> ".concat(elemento.getAttribute(atributo)).concat(" Igual a ").concat(check));
		assertEquals(elemento.getAttribute(atributo), check);
	}
	
	/**
	 * Retirar do locator caracters indesejados para apresentacao
	 * 
	 * @param elemento - locator
	 */
	protected String obterSeletor(WebElement elemento) {
		String el = elemento.toString().replaceAll("\\S+: \\S+ on \\S+ (\\S+) -> \\S+ \\S+ ", "");
		return el.substring(0, el.length() - 1);
	}
}