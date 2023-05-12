package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class scrollTest {
	
	AppiumDriver a;
	
	@BeforeTest
	public void driveSetup() throws MalformedURLException {
		UiAutomator2Options ua = new UiAutomator2Options();
		ua.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");
		a = new AndroidDriver(new URL("http://localhost:4723"),ua);
	}
	
	@Test
	public void testScrollToTab() throws InterruptedException {
		a.findElement(AppiumBy.accessibilityId("Views")).click();
		
		WebElement VSlist = a.findElement(AppiumBy.id("android:id/list"));
		
		double centerx = VSlist.getRect().x + (VSlist.getSize().width/2);
		
		double starty = VSlist.getRect().y + (VSlist.getSize().height*0.9);
		
		double endy = VSlist.getRect().y + (VSlist.getSize().height*0.1);
		
		//finger 
		PointerInput f = new PointerInput(Kind.TOUCH, "f");
		
		Sequence swipe = new Sequence(f, 1);
		//swipe = new Seq
		
		swipe.addAction(f.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),(int)centerx,(int)starty));
		
		swipe.addAction(f.createPointerDown(0));
		
		swipe.addAction(f.createPointerMove(Duration.ofSeconds(1),PointerInput.Origin.viewport(),(int)centerx,(int)endy));
		
		swipe.addAction(f.createPointerUp(0));
		
		a.perform(Arrays.asList(swipe));
		a.perform(Arrays.asList(swipe));
		
		a.findElement(AppiumBy.accessibilityId("TextSwitcher")).click();
		a.findElement(AppiumBy.accessibilityId("Next")).click();
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void tearDown() {
		a.quit();
	}
	
	
}