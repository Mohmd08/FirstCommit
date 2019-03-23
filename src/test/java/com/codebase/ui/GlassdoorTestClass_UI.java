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

public class GlassdoorTestClass_UI extends BaseUi {
	private static final String linkText = null;

	WebDriver driver;
	

	public GlassdoorTestClass_UI(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css = "[class = 'container-logo']")
	private WebElement LogoGlassdoor;
	
	@FindBy(xpath = "//*[@id=\"TopNav\"]/nav/div[1]/a/svg")
	private WebElement LogoGlassdoor1;
	
	
	//----------------------------------
	
	public void CheckGlassdoorTitle() {
		//Assert.assertEquals("Bing", driver.getTitle()); 
		// OR
		// isElementDisplayed(googleTitle);
		Assert.assertEquals("Glassdoor Job Search | Find the job that fits your life", driver.getTitle());
	}
	
	public void CheckGlassdoorLogo() {
		hardwait(5);
		isElementDisplayed(LogoGlassdoor1);
	}

}
	
	
