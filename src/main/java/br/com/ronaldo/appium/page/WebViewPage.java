package br.com.ronaldo.appium.page;
import static br.com.ronaldo.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import java.util.List;
import java.util.Set;

import br.com.ronaldo.appium.core.BasePage;

//import com.gargoylesoftware.htmlunit.javascript.host.Set;

import br.com.ronaldo.appium.core.DriverFactory;

public class WebViewPage extends BasePage{
	
	public void entrarContextoWeb() {
		Set<String> contextHanddles = getDriver().getContextHandles();
		//for(String valor: contextHanddles) {
			//System.out.println(valor);
		//}
		getDriver().context((String) contextHanddles.toArray()[0]);
			
	}
	
	public void setEmail(String valor) {
		getDriver().findElement(By.id("email")).sendKeys(valor);
	}
	public void setSenha(String senha) {
		getDriver().findElement(By.id("senha")).sendKeys(senha);
	}
	
	public void entrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String getMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void sairContextoWeb() {
		
		getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
			
	}
	

}
