package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {

	WebDriver driver;

	public SearchPage(WebDriver driver)
	{
		this.driver =driver;
	}

	@FindBy (css ="#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input")
	WebElement searchBox;

	@FindBy( css = "#tsf > div:nth-child(2) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > div.VlcLAe > center > input.gNO89b")
	WebElement searchButton;

	public void search( String word) throws InterruptedException {
		searchBox.sendKeys(word);
		Thread.sleep(5000);
		searchButton.click();
	}

}
