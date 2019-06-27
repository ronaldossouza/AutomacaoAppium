package br.com.ronaldo.appium.test;

import org.junit.Assert;
import org.junit.Before;

import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.MenuPage;
import br.com.ronaldo.appium.page.seuBarriga.SBContasPage;
import br.com.ronaldo.appium.page.seuBarriga.SBHomePage;
import br.com.ronaldo.appium.page.seuBarriga.SBLoginPage;
import br.com.ronaldo.appium.page.seuBarriga.SBMenuPage;
import br.com.ronaldo.appium.page.seuBarriga.SBMovimentacaoPage;
import br.com.ronaldo.appium.page.seuBarriga.SBResumoPage;

import org.junit.Test;


public class SBTeste extends BaseTest {
	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void setup() {
		menu.acessarSBNativo();
		login.setEmail("a@a");
		login.setSenha("a");
		login.entrar();
	}
	
	@Test
	public void deveInserirContaComSucesso() {
		//entrar em contas 
		menuSB.acessarContas();
		
		//digitar nome conta 
		contas.setConta("Conta de Teste");
		
		//salva
		contas.salvar();		
		
		//verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
		
		
	}
	@Test
	public void deveExcluirConta() {
		//entrar em contas 
		menuSB.acessarContas();
		
		//clique longo na conta
		contas.selecionarContas("123");
		
		//excluir
		contas.excluir();
		
		//verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));

	}
	@Test
	public void deveValidarInclusaoMov() {
     menuSB.acessarMovimentacoes();	
     esperar(3000);
     //validar desc
     mov.salvar();
     Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));
     
     //validar inte
     mov.setDescricao("Desc");
   //  esperar(3000);
    // mov.salvar();
   //  Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
     
     //validar valor
     mov.setInteressado("Interess");
    // mov.salvar();
    // Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
     
     //validar conta
     mov.setValor("123");
     //mov.salvar();
    // Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));
     
     //inserir com sucesso
     mov.setConta("Conta para alterar");
     mov.salvar();
   //  Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
     
     
	}
	@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() {
		//verificar saldo "Conta para saldo" = 534.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		
		//ir para resumo
		menuSB.acessarResumo();
		
		//excluir movimentacao 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		
		//validar mensagem  "Movimentação removida com sucesso"
	     //Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));

		//voltar home
		menuSB.acessarHome();
		
		//atualizar saldo
		esperar(3000);
		home.scroll(0.1, 0.9);
		
		//verificar saldo = -1000.00
		//Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));

	
	}

}
