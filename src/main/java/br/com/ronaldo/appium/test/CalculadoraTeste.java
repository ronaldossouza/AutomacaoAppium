package br.com.ronaldo.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;




public class CalculadoraTeste {



    @Test	
    public void deveSomarDoisValores() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator1");
        desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");



        AndroidDriver <MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        MobileElement el1 = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_02");
        el1.click();
        MobileElement el2 = driver.findElementByAccessibilityId("Mais");
        el2.click();
        MobileElement el3 = driver.findElementById("com.sec.android.app.popupcalculator:id/bt_02");
        el3.click();
        MobileElement el4 = driver.findElementByAccessibilityId("Igual");
        el4.click();
        MobileElement el5 = driver.findElementByAccessibilityId("Campo de entrada da Calculadora");
        el5.click();
        
       Assert.assertEquals("4", el5.getText());
       driver.quit();
       
       

    }
}