package br.com.ronaldo.appium.core;

import static br.com.ronaldo.appium.core.DriverFactory.getDriver;
import java.awt.Dimension;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;


public class BasePage {
	
	protected WebDriver driver = DriverFactory.getDriver();
	
	
public void escrever(By by, String texto) {
		
		// Escrever nome.
				getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();

	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
		
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
		
	}
	 
	public void selecionarCombo(By by, String valor) {		
		       // clicar no combo
				getDriver().findElement(by).click();
				// Selecionar a opção desejada
				clicarPorTexto(valor);
				//getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+valor+"']")).click();
		
	}
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size() >0;
	}
	
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
		
	}
	
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(x, y).perform();
		
//		TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
//		touchAction.tap(new PointOption().withCoordinates(x, y)).perform();
	}
	
	public void scrollDown() {
		scroll(0.9, 0.1);
	}
	
	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	public void swipeRight() {
		swipe(0.9, 0.1);
	}
	public void scroll(double inicio, double fim) {
	org.openqa.selenium.Dimension size = getDriver().manage().window().getSize();
	//Dimension size = getDriver().manage().window().getSize();

	

		int x = size.width / 2;
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		 new TouchAction(getDriver()) 
		.press(x, start_y)
		.waitAction()
		.moveTo(end_y, x)
		.release()
		.perform();

	}
	
	public void swipe(double inicio, double fim) {
		org.openqa.selenium.Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height / 2;

		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		
		new TouchAction(getDriver())
		.press(start_x, y)
		.waitAction()
		.moveTo(end_x, y)
		.release()
		.perform();
	}
	
	public void swipeElement(MobileElement element, double inicio, double fim) {
		
		int y = element.getLocation().y + (element.getSize().height / 2);
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		
		
		new TouchAction(getDriver())
		.press(start_x, y)
		.waitAction()
		.moveTo(end_x, y)
		.release()
		.perform();
	}
	
public void cliqueLongo(By by) {
	  new TouchAction(getDriver())
		 .longPress(getDriver().findElement(by))
				 .perform();
}

}
