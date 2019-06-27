package br.com.ronaldo.appium.test;

import java.awt.Menu;

import org.junit.Assert;
import org.junit.Test;

import br.com.ronaldo.appium.core.BaseTest;
import br.com.ronaldo.appium.page.DragDropPage;
import br.com.ronaldo.appium.page.MenuPage;

public class DrangNDropTeste extends BaseTest {

	private MenuPage menu = new MenuPage();

	private String[] estadoInicial = new String[] { "Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "qualquer local desejado." };
	private String[] estadoIntermediario = new String[] { "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"Esta", "e arraste para", "qualquer local desejado." };
	private String[] estadoFinal = new String[] { "é uma lista", "Drag em Drop!", "Faça um clique longo,",
			"e arraste para", "Esta", "qualquer local desejado." };

	private DragDropPage page = new DragDropPage();

	@Test
	public void deveEfetuarDragNdrop() {

		// acessar menu
		menu.clicarDragNDrop();

		// verificar estado inicial
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterlista());

		// arrastar "Faça um clque longo," para "é uma lista"
		page.arrastar("Esta", "é uma lista");

		esperar(1000);
		page.arrastar("Esta", "Drag em Drop!");

		esperar(1000);
		page.arrastar("Esta", "Faça um clique longo,");

		// verificar estado final
		Assert.assertArrayEquals(estadoIntermediario, page.obterlista());

		esperar(1000);
		// arrastar "Esta" para "e arraste para"
		page.arrastar("Esta", "e arraste para");

		// verificar estado final
		Assert.assertArrayEquals(estadoFinal, page.obterlista());

	}

}
