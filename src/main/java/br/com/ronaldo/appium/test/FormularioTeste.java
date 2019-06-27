package br.com.ronaldo.appium.test;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;
import org.junit.Before;
import org.junit.Test;
import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.FormularioPage;
import br.com.ronaldo.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import junit.framework.Assert;

public class FormularioTeste extends BaseTest{

	
	//private DSL dsl = new DSL(); 
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();
	

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormularo();
	}



	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

		// Escrever nome.
		page.escreverNome("Ronaldo");
	

		// Checar nome escrito
		assertEquals("Ronaldo", page.obterNome());

	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		// clicar no combo
		page.selecionarCombo("Nintendo Switch");

		// verificar a opção desejada
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());

	}

	// Verifica se o status esta ativo ou não
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		// Verificar o status dos elementos
		
		Assert.assertFalse(page.isCheckMarcado());// verifica se o checkbox está marcado
		Assert.assertTrue(page.isSwitchMarcado());// verifica se o switch está selecionado

		// Clicar nos elementos
		page.clicarCheck();
		page.clicarSwitch();
		
	


		// verificar estados alterados
		Assert.assertTrue(page.isCheckMarcado());// verifica se o checkbox está marcado
		Assert.assertFalse(page.isSwitchMarcado());// verifica se o switch está selecionado
		
	}

	@Test
	public void deveRealizarCadastro() throws MalformedURLException {

		// Preencher campo
		page.escreverNome("Ronaldo");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");// Selecionar a opção desejada
		
																											

		// Salvar
	    page.salvar();

		// Verificações
		Assert.assertEquals("Nome: Ronaldo", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));

	}
	
//	@Test
//	public void deveRealizarCadastroDemorado() throws MalformedURLException {
//
//		page.escreverNome("Ronaldo");
//	
//
//		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		page.salvarDemorado();
//		esperar(3000);
//	
//
//	    WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Ronaldo']")));
//		
//		Assert.assertEquals("Nome: Ronaldo", page.obterNomeCadastrado());
//
//	}
	
	
	
	

	
	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}
	
	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekbar() {
		//clicar no seekbar
		page.clicarSeekBar(0.05);
	
		//salvar
		page.salvar();
		
		//obter o valor
		
		
		
	}
	

}
