package br.com.ronaldo.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;

	public static AndroidDriver<MobileElement> getDriver() {
		
		if(driver == null) {
			//createDriver();
			createTestObjectDriver();
		}
		return driver;
		
	}

	private static void createDriver(){
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator1");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"/home/usertqi/Documentos/CursoAppium/src/main/resources/CTAppium-1-1.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	private static void createTestObjectDriver(){
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("testobject_api_key", "9624B9B5071B4BF3803E0EE8876F6599");
		desiredCapabilities.setCapability("appiumVersion", "1.13.0");

		//desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator1");
		//desiredCapabilities.setCapability(MobileCapabilityType.APP,
			//	"/home/usertqi/Documentos/CursoAppium/src/main/resources/CTAppium-1-1.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("https://us1.appium.testobject.com/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
			
		}
	}
	
}
