package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class FirstAndroidTest {
	
	AppiumDriver a;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities dcaps = new DesiredCapabilities();
		dcaps.setCapability("platformName","Android");
		dcaps.setCapability("appium:automationName", "UiAutomator2");
		dcaps.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");
		a = new AndroidDriver(new URL("http://localhost:4723") ,dcaps);
	}
	
	@Test
	public void click_app_button() {
		a.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
		a.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Buttons\"]")).click();
		a.findElement(By.id("io.appium.android.apis:id/button_toggle")).click();
		String btnTxt = 
				a.findElement(By.xpath("//android.widget.ToggleButton[@content-desc=\"Toggle\"]")).getText();
		System.out.println(btnTxt);
		
	}
	
	@AfterTest
	public void tearDown() {
		a.quit();
	}
	
}
