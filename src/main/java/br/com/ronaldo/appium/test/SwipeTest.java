package br.com.ronaldo.appium.test;

import static br.com.ronaldo.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.MenuPage;

public class SwipeTest extends BaseTest {

	private MenuPage menu = new MenuPage();

	@Test
	public void deveRealizarSwipe() {

		// acessar menu
		menu.acessarSwipe();

		// verificar texto a esquerda
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

		// swipe para diretia
		menu.swipeRight();

		// Verificar texto 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));

		menu.clicarPorTexto("›");
		// verificar texto 'Chegar até o fim!'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));

		// swipe esquerdo
		menu.swipeLeft();

		// clicar botão esquerda
		menu.clicarPorTexto("‹");

		// verificar texto a esquerda
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));

	}

}
