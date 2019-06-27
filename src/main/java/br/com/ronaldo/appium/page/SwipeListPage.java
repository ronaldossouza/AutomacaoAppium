package br.com.ronaldo.appium.page;

import org.openqa.selenium.By;
import static br.com.ronaldo.appium.core.DriverFactory.getDriver;


import br.com.ronaldo.appium.core.BasePage;
import br.com.ronaldo.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class SwipeListPage extends BasePage {
	
	public void swipeElementLeft(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.1, 0.9);
		
	}
	public void swipeElementRight(String opcao) {
		swipeElement(DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+opcao+"']/..")), 0.9, 0.);
		
	}
	public void clicarBotaoMais() {
		MobileElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		new TouchAction(getDriver())
		.tap(botao,-50, 0  )
		.perform();
	}

}
