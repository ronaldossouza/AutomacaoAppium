package br.com.ronaldo.appium.test;

import org.junit.Test;

import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.AccordionPage;
import br.com.ronaldo.appium.page.MenuPage;
import junit.framework.Assert;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		//acessar menu
		menu.acessarAccordion();
		
		//clicar ap 1
		page.selecionarOp1();
		
		esperar(3000);
		//verificar texto ap 1
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
	}

}
