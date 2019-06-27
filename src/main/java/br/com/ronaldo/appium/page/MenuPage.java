package br.com.ronaldo.appium.page;

import static br.com.ronaldo.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.ronaldo.appium.core.BasePage;

public class MenuPage extends BasePage{
	
	
	
	public void acessarFormularo() { 
		clicarPorTexto("Formulário");
		
	}
 
	public void acessarSplash() {
		clicarPorTexto("Splash");

		
	}
	
	public void acessarAlertas() {
		clicarPorTexto("Alertas");
	}
	
	public void acessarAbas() {
		clicarPorTexto("Abas"); 	
	}
	
	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}
	
	public void acessarCliques() {
		clicarPorTexto("Cliques");
	} 
	
	public void acessarSwipe() {
		//scroll(0.9,0.2);
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formulário']")));
		scroll(0.4, 0.2);
		clicarPorTexto("Swipe");
	}
	public void clicarSwipeList() {
		//scroll down
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formulário']")));		
		scrollDown();
		
		//clicar menu
		clicarPorTexto("Swipe List");
	}
	
	public void clicarDragNDrop() {
		//scroll down
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formulário']")));		
		scrollDown();
		
		//clicar menu
		clicarPorTexto("Drag and drop");
	}
	
	public void acessarSBHibrido() {
		clicarPorTexto("SeuBarriga Híbrido");
	}

	public void acessarSBNativo() {
		clicarPorTexto("SeuBarriga Nativo");
	}

}
