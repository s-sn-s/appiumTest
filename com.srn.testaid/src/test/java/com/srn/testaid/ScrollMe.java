package com.srn.testaid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.android.AndroidTouchAction;

public class ScrollMe {
	
	AppiumDriver a;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		//*******Deprecated
//		DesiredCapabilities caps = new DesiredCapabilities();
//		caps.setCapability("platformName", "Android");
//		caps.setCapability("appium:automationName", "UiAutomator2");
//		caps.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");
		//Deprecated*******
		UiAutomator2Options opts = new UiAutomator2Options();
		opts.setCapability("app", System.getProperty("user.dir")+"/apps/ApiDemos-debug.apk");
		a = new AndroidDriver(new URL("http://localhost:4723"),opts);
	}
	
	@Test
	public void letsScroll() throws InterruptedException {
		a.findElement(AppiumBy.accessibilityId("Views")).click();
		
		WebElement VSlist = a.findElement(AppiumBy.id("android:id/list"));
		
		double centerx = VSlist.getRect().x + (VSlist.getSize().width/2);
		
		double starty = VSlist.getRect().y + (VSlist.getSize().height*0.9);
		
		double endy = VSlist.getRect().y + (VSlist.getSize().height*0.1);
		
		//finger 
		PointerInput f = new PointerInput(Kind.TOUCH, "f");
		
		Sequence swipe = new Sequence(f, 1);
		
		swipe.addAction(f.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),(int)centerx,(int)starty));
		
		swipe.addAction(f.createPointerDown(0));
		
		swipe.addAction(f.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(),(int)centerx,(int)endy));
		
		swipe.addAction(f.createPointerUp(0));
		
		a.perform(Arrays.asList(swipe));
		Thread.sleep(2000);
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
		Thread.sleep(2000);
	}
	  
	
	@AfterTest
	public void tearDown() {
		a.quit();
	}
}