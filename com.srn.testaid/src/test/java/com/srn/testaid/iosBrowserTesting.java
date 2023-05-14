package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class iosBrowserTesting {
	private AppiumDriver ad;
		
	@BeforeTest
	public void iosSetup() throws MalformedURLException {
		XCUITestOptions xop = new XCUITestOptions();
		xop.setCapability("browserName", "safari");
		URL serverLink = new URL("http://localhost:4723");
		ad = new AndroidDriver(serverLink, xop);
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