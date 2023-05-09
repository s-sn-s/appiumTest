package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.AndroidTouchAction;

public class ScrollMe {
	
	AppiumDriver a;
	//public AndroidTouchAction acts;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");
		a = new AndroidDriver(new URL("http://localhost:4723"),caps);
	}
	
	@Test
	public void letsScroll() {
		a.findElement(AppiumBy.accessibilityId("Views")).click();
		//acts = new AndroidTouchAction(a);
		//W3cActions
		a.findElement(AppiumBy.accessibilityId("Tabs")).click();
		a.findElement(AppiumBy.accessibilityId("1. Content By Id")).click();
		a.findElement(AppiumBy.xpath("//*[text()='TAB1']")).click();
		String t1 = a.findElement(AppiumBy.accessibilityId("tab1")).getText();
		System.out.println("I clicked "+ t1);
		a.findElement(AppiumBy.xpath("//*[@index='0']")).click();
		String t2 = a.findElement(AppiumBy.accessibilityId("tab2")).getText();
		System.out.println("I clicked "+ t2);
		a.findElement(AppiumBy.xpath("text()='TAB3'")).click();
		String t3 = a.findElement(AppiumBy.accessibilityId("tab3")).getText();
		System.out.println("I clicked "+ t3);
	}
	
	@AfterTest
	public void tearDown() {
		a.quit();
	}
}