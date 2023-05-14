package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class IOSexecuteScript {
	
	AppiumDriver ad;
	
	@BeforeTest
	public void iosSetup() throws MalformedURLException {
		XCUITestOptions xop = new XCUITestOptions();
		xop.setCapability("app", System.getProperty("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
		URL appLink = new URL("http://localhost:4723");
		ad = new IOSDriver(appLink,xop);
	}
	
	@Test
	public void executeIOSscript() {
		ad.executeScript(("mobile:scroll"), ImmutableMap.of("direction","down"));
		ad.executeScript(("mobile:scroll"), ImmutableMap.of("direction","up"));
	}
	
	@AfterTest
	public void tearDown() {
		ad.quit();
	}

}