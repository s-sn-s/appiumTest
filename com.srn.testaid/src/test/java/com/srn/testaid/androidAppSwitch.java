package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class androidAppSwitch {
	
	AppiumDriver ad;
	
	@BeforeTest
	public void iOSsetup() throws MalformedURLException {
		UiAutomator2Options op = new UiAutomator2Options();
		op.setCapability("app", System.getProperty("user.dir") +"/apps/Android-MyDemoAppRN.1.3.0.build-244.apk");
		URL appLink = new URL("http://localhost:4723");
		ad = new AndroidDriver(appLink, op);
		//sa = new SoftAssert();
	}
	
	@Test
	public void appSwitch() {
		ad.executeScript("mobile:startActivity", ImmutableMap.of("intent","com.android.settings/.Settings"));
		ad.executeScript("mobile:startActivity", ImmutableMap.of("intent","com.saucelabs.mydemoapp.rn"));
	}
	
	@AfterTest
	public void tearDown() {
		ad.quit();
	}
}