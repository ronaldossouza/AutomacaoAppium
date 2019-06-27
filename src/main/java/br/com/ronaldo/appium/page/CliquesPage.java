package br.com.ronaldo.appium.page;

import br.com.ronaldo.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import static br.com.ronaldo.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class CliquesPage extends BasePage{
	
		
	public void cliqueLongo() {
	cliqueLongo(By.xpath("//*[@text='Clique Longo']"));

	}
	
	public String obterTextoCampo() {
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}

}
