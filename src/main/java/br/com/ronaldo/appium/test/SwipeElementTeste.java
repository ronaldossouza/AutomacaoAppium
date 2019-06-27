package br.com.ronaldo.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.MenuPage;
import br.com.ronaldo.appium.page.SwipeListPage;

public class SwipeElementTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();
	
	@Test
	public void deveResolverDesafio() {
		
		// Clicar no swipe list
		menu.clicarSwipeList();
		
		// op1 para a esquerda
		page.swipeElementRight("Opção 1");
		
		
		// op1 +
		page.clicarBotaoMais();
		
		// Verificar op1+
		Assert.assertTrue(page.existeElementoPorTexto("Opção 1 (+)"));
		
		// op4 para esquerda
		page.swipeElementRight("Opção 4");

		
		// op4 -
		page.clicarPorTexto("(-)");

		
		// verificar op4 -
		Assert.assertTrue(page.existeElementoPorTexto("Opção 4 (-)"));

		
		// op5 para esquerda
		page.swipeElementLeft("Opção 5 (-)");

		
		// verificar op5
		Assert.assertTrue(page.existeElementoPorTexto("Opção 5"));

	}

}
