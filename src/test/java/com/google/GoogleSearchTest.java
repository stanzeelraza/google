
/*
 * This is to test the google search using simple automation code
 */
package com.google;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class GoogleSearchTest {
  WebDriver driver;
  SearchPage searchPage;
  
  @BeforeTest
  public void beforeTest() throws IOException {
	  
	  Properties browserConfigProps = new Properties();
  	FileInputStream fis = new FileInputStream("BrowserConfig.Txt");
  	
  	browserConfigProps.load(fis);
  
  	String browserType = browserConfigProps.getProperty("BROWSER");
  	
  	if (browserType.equalsIgnoreCase("CHROME")) {
  		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raza_\\Downloads\\Jar files\\chromedriver.exe ");
  		driver = new ChromeDriver();
  	}else if(browserType.equalsIgnoreCase("FIREFOX")) {
  		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raza_\\Downloads\\Jar files\\geckodriver.exe ");
  		driver = new FirefoxDriver();
  	}else if(browserType.equalsIgnoreCase("IE")) {
  		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raza_\\Downloads\\Jar files\\IEDriverServer.exe ");
  		driver = new InternetExplorerDriver();
  	}
	  
	  
	  
	  
	  
	  
	  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\raza_\\Downloads\\Jar files\\chromedriver.exe");
	  
	  //ChromeOptions options = new ChromeOptions();
	  //options.addArguments("start-maximized");
	  
	  //driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		searchPage = PageFactory.initElements(driver, SearchPage.class);
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  
  @Test
  public void searchFunction() throws InterruptedException {
	  searchPage.search("Pakistan");
	  
  }

}
