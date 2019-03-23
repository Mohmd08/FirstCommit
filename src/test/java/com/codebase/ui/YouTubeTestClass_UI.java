package com.codebase.ui;

import junit.framework.Assert;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.baseClass.BaseUi;
import com.codebase.WebTestClass;

public class YouTubeTestClass_UI extends BaseUi {
	private static final String linkText = null;

	WebDriver driver;
	

	public YouTubeTestClass_UI(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"sbox\"]/div[1]")
	private WebElement BingLogo;
	
	
	
	public void CheckYouTubeTitle() {
		Assert.assertEquals("Bing", driver.getTitle()); 
		// OR
		// isElementDisplayed(googleTitle);
	}
	
	
		
}
	
	
