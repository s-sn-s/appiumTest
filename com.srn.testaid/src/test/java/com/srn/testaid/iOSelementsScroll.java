package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class iOSelementsScroll {
	
	AppiumDriver ad;
	
	@BeforeTest
	public void iOSsetup() throws MalformedURLException {
		XCUITestOptions op = new XCUITestOptions();
		op.setCapability("app", System.getProperty("user.DIR") +"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
		URL appLink = new URL("http://localhost:4723");
		ad = new IOSDriver(appLink, op);
	}
	
	@Test
	public void iOSscoll() {
		WebElement we = ad.findElement(AppiumBy.xpath("//*[@type='XCUIElementTypeScrollView']"));
		
		double centerY = we.getRect().y + we.getSize().height/2;
		
		double leftX =  we.getRect().x + we.getSize().width*0.1;
		
		double rightX =  we.getRect().x + we.getSize().width*0.9;
		
		PointerInput finger1 = new PointerInput(Kind.TOUCH, "finger1");
		
		Sequence swipe = new Sequence(finger1, 1);
		
		swipe.addAction(finger1.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),(int)leftX,(int)centerY));
		
		swipe.addAction(finger1.createPointerDown(0));
		
		swipe.addAction(finger1.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),(int)rightX,(int)centerY));
		
		swipe.addAction(finger1.createPointerUp(0));
		
		ad.perform(Arrays.asList(swipe));
		
		ad.findElement(AppiumBy.accessibilityId(null)).click();
		
		String wv = ad.findElement(AppiumBy.accessibilityId(null)).getText();
		
		System.out.println(wv);
		
	}
	
	@AfterTest
	public void iOSteardown() {
		ad.quit();
	}

}
