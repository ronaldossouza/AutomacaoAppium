package br.com.ronaldo.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;


import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.MenuPage;
import br.com.ronaldo.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		
		//acessar o menu
		menu.acessarSBHibrido();
		esperar(5000);
		page.entrarContextoWeb();
		
		//preencher email
		page.setEmail("a@a");
		
		//page.entrarContextoWeb();
		
		//senha
		page.setSenha("a");
		
		esperar(3000);
		
		//entrar
		page.entrar();
		
		//verificar
		Assert.assertEquals("Bem vindo, Wagner!", page.getMensagem());
	
	}
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}

}
