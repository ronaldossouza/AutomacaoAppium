package br.com.ronaldo.appium.test;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;




public class CalculadoraAsusTeste {



    @Test	
    public void deveSomarDoisValores() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator1");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");



        AndroidDriver <MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        MobileElement el6 = driver.findElementById("com.android.calculator2:id/digit_2");
        el6.click();
        MobileElement el7 = driver.findElementByAccessibilityId("plus");
        el7.click();
        MobileElement el8 = driver.findElementById("com.android.calculator2:id/digit_2");
        el8.click();
        MobileElement el9 = driver.findElementById("com.android.calculator2:id/result");
        System.out.println(el9.getText());
       Assert.assertEquals("4", el9.getText());
       driver.quit();
       
       

    }
}