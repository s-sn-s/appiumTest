package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidBrowser {
	private AppiumDriver ad;
		
	@BeforeTest
	public void iosSetup() throws MalformedURLException {
		UiAutomator2Options uop = new UiAutomator2Options();
		uop.setCapability("browserName", "chrome");
		URL serverLink = new URL("http://localhost:4723");
		ad = new AndroidDriver(serverLink, uop);
	}
	
	@Test
	public void iosSwitchApp() throws InterruptedException {
		System.out.println("Browser Launched");
	}
	
	@AfterTest
	public void tearDown() {
		ad.quit();
	}
}
