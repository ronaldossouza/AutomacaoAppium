package br.com.ronaldo.appium.page.seuBarriga;

import org.openqa.selenium.By;
import static br.com.ronaldo.appium.core.DriverFactory.getDriver;


import br.com.ronaldo.appium.core.BasePage;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {
	
	public void excluirMovimentacao(String desc) {
		MobileElement el = getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}

}
