package br.com.ronaldo.appium.page;

import org.openqa.selenium.By;

import br.com.ronaldo.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import static br.com.ronaldo.appium.core.DriverFactory.getDriver;

public class FormularioPage extends BasePage {

	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);

	}

	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);

	}

	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView[@text='Nintendo Switch']"));

	}

	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));

	}

	public void clicarSwitch() {
		// Clicar nos elementos
		clicar(MobileBy.AccessibilityId("switch"));

		// Verificar o status dos elementos
	}

	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));// verifica se o checkbox está marcado
	}

	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));// verifica se o switch está selecionado

	}

	public void clicarSeekBar(double posicao) {
		int delta = 55;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);

		// int x = (int) (seek.getLocation().x + (seek.getSize().width * posicao));
		int xinicial = seek.getLocation().x + delta;
		int x = (int) (xinicial + ((seek.getSize().width - 2 * delta) * posicao));
		System.out.println(x);

		tap(x, y);
	}

	public void salvar() {
		clicarPorTexto("SALVAR");
	}

	public void salvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}

	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));

	}

	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));

	}

	public String obterCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));

	}

	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));

	}

}
