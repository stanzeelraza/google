package com.google;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class GoogleSearchTest {
  WebDriver driver;
  SearchPage searchPage;
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\raza_\\Downloads\\Jar files\\chromedriver.exe");
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("start-maximized");
	  
	  driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
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
