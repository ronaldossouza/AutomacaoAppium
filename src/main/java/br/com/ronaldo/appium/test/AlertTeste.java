package br.com.ronaldo.appium.test;

import org.junit.Test;

import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.AlertaPage;
import br.com.ronaldo.appium.page.MenuPage;
import junit.framework.Assert;

public class AlertTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@org.junit.Before
	
	public void setup() {
		menu.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlerta() {
	
		
		//clicar em alerta e confirm
		page.clicarAlertaConfirm();
		
		//verificar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		
		//confirmar alerta
		page.confirmar();
		
		//verificar nova mensagem 
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		
		//sair
		page.sair();
		
		
		
	}
	@Test
	public void deveClicarForaAlerta() {
		
		
		//clicar alerta simples
		page.clicarAlertaSimples();
		
		//clicar fora da caixa
		page.clicarForaCaixa();
		
		//verificar que a mensagem não está presente
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}

}
