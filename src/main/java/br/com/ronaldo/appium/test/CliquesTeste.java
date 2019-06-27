package br.com.ronaldo.appium.test;

import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.CliquesPage;
import br.com.ronaldo.appium.page.MenuPage;
import io.appium.java_client.TouchAction;

import static br.com.ronaldo.appium.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;


public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	
	@Before
	public void setup() {
		//acessar menu
	 menu.acessarCliques();
	}
	

	

	
	@Test
	public void deveRealizarCliqueLongo() {
		
		
		//clique longo
		page.cliqueLongo();
		
		//verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
	
		
		//Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
		
//		WebElement e = driver.findElement(By.xpath("//*[@text='Clique Longo']"));
//				TouchAction action = new TouchAction(driver);
//				action
//				  .press(e)
//				  .waitAction(Duration.ofMillis(50))
//				  .release()
//				  .press(e)
//				  .waitAction(Duration.ofMillis(50))
//				  .release()
//				  .perform();


	} 

}
