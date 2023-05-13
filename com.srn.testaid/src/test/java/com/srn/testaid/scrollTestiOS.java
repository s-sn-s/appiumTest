package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class scrollTestiOS {
	AppiumDriver ad;
	
	@BeforeTest
	public void setMeUp() throws MalformedURLException {
		XCUITestOptions op = new XCUITestOptions();
		op.setCapability("app", System.getProperty
		("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
		ad = new IOSDriver(new URL("http://localhost:4723"),op);
	}
	
	@Test
	public void letScrollIos() {
		
		WebElement wes = ad.findElement(AppiumBy.xpath(
				"//XCUIElementTypeOther[contains(@name,'Products')]"));
		
		double centerX = wes.getRect().x + (wes.getSize().width/2);
		
		double startY = wes.getRect().y + (wes.getSize().height*0.1);
		
		double endY = wes.getRect().y + (wes.getSize().height*0.9);
		
		PointerInput scrollFinger = new PointerInput(Kind.TOUCH,"scrollFinger");
		
		Sequence scrol = new Sequence(scrollFinger,1);
		
		scrol.addAction(scrollFinger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),(int)centerX,(int)startY));
		
		scrol.addAction(scrollFinger.createPointerDown(0));
		
		scrol.addAction(scrollFinger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), (int)centerX, (int)endY));
		
		scrol.addAction(scrollFinger.createPointerUp(0));
		
		ad.perform(Arrays.asList(scrol));
		
		ad.findElement(AppiumBy.accessibilityId("Sauce Labs Onesie")).click();
		
		String price =  ad.findElement(AppiumBy.accessibilityId("product price")).getText();
		//ad.findElement(AppiumBy.androidUIAutomator(new ));
		
		System.out.println("iOS Launched & scolled. Price of product is " + price);
		
		Assert.assertEquals("$7.99", price);
	}
	
	@AfterTest
	public void tearDown(){
		ad.quit();
	}
}