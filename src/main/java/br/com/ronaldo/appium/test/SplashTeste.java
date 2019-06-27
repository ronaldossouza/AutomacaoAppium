package br.com.ronaldo.appium.test;

import org.junit.Test;

import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.MenuPage;
import br.com.ronaldo.appium.page.SplashPage;
import junit.framework.Assert;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void deveAguardarSplashSumir() {
		
		//acessar menu splash
		menu.acessarSplash();
		
		//verificar que o splash esta sendo exibido 
		page.isTelaSplashVisivel();
		
		//aguardar saida do splash
		page.aguardarSplashSumir();
		
		//verificar que o formulario esta aparecendo 
		Assert.assertTrue(page.existeElementoPorTexto("Formulário")); 
		
		
	}

}
