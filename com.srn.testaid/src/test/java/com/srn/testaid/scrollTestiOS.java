package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class scrollTestiOS {
	AppiumDriver ad;
	
	@BeforeTest
	public void setMeUp() throws MalformedURLException {
		XCUITestOptions op = new XCUITestOptions();
		op.setCapability("APP", System.getProperty("user.dir")+"/apps/FakeIOSApp.ipa");
		ad = new IOSDriver(new URL("http://localhost:4723"),op);
	}
	
	@Test
	public void letScrollIos() {
		System.out.println("iOS Launched");
	}
	
	@AfterTest
	public void tearDown(){
		ad.quit();
	}
}