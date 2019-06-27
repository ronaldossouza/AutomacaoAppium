package br.com.ronaldo.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.com.ronaldo.appium.core.BasePage;

public class SBHomePage extends BasePage {
	
public String obterSaldoConta(String conta) {
	return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
}

}
