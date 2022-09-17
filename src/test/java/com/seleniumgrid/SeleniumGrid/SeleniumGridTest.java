package com.seleniumgrid.SeleniumGrid;

import java.net.MalformedURLException;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGridTest  {
	
	WebDriver driver;

	@BeforeMethod

	public void startBrowse() {

		// Pass the desired capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("MicrosoftEdge");
		cap.setPlatform(Platform.WINDOWS);

		EdgeOptions options = new EdgeOptions();
		// Do testing headless Mode
		// options.setHeadless(false);
		options.merge(cap);

		String hubURL = "http://192.168.0.11:4444";
		try {
			driver = new RemoteWebDriver(new java.net.URL(hubURL), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("https://www.toolsqa.com/testng/implement-iretryanalyzer-to-retry-failed-test-in-testng-framework/");

	}
	@Test
	public void test() {
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(driver.getTitle());
	}
	@AfterMethod
	public void quit() {
		
		driver.quit();
	}

}
