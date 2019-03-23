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

public class FacebookTestClass_UI extends BaseUi {
	private static final String linkText = null;

	WebDriver driver;
	

	public FacebookTestClass_UI(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"sbox\"]/div[1]")
	private WebElement BingLogo;
	
	@FindBy(xpath = "//*[@id=\"blueBarDOMInspector\"]/div/div/div/div[1]/h1/a/i")
	private WebElement Nallibiryani;
	
	//----------------------------------
	
	public void CheckFacebookTitle() {
		Assert.assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
	}

	public void CheckFacebookLogo() {
		isElementDisplayed(Nallibiryani);	
	}


}
	
