package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class iosAppSwitch {
	
	private AppiumDriver ad;
	private String buildID = "com.apple.mobileslideshow";
	
	@BeforeTest
	public void iosSetup() throws MalformedURLException {
		XCUITestOptions xop = new XCUITestOptions();
		xop.setCapability("app", System.getProperty("user.dir") + "/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
		URL serverLink = new URL("http://localhost:4723");
		ad = new IOSDriver(serverLink, xop);
	}
	
	@Test
	public void iosSwitchApp() throws InterruptedException {
		Map<String, String> apps = new HashMap<String, String>();
		apps.put("bundleId", buildID);
		Thread.sleep(5000);
		ad.executeScript("mobile:launchApp", apps);
	}
	
	@AfterTest
	public void tearDown() {
		ad.quit();
	}
}