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

public class BingTestClass_UI extends BaseUi {
	private static final String linkText = null;

	WebDriver driver;
	

	public BingTestClass_UI(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id=\"sbox\"]/div[1]")
	private WebElement BingLogo;
	
	@FindBy(css = "[id = 'sb_form_q']")
	private WebElement txtSearchBox;
	
	@FindBy(css = "[id = 'sbi_b']")
    private WebElement Cameraicon; 
	
	@FindBy(css = "[id = 'scpl2']")
	private WebElement MapsIcon;
	//----------------------------------
	
	public void CheckBingTitle() {
		Assert.assertEquals("Bing", driver.getTitle()); 
		// OR
		// isElementDisplayed(googleTitle);
	}
	
	public void CheckLogo() {
		isElementDisplayed(BingLogo);
	}
	
	public void CheckTextBox() {
		isElementDisplayed(txtSearchBox);
	}

	public void CheckCameraIcon() {
		isElementDisplayed(Cameraicon);		
		
	}

	public void CheckMapsIcon() {
		isElementDisplayed(MapsIcon);
	}

		
}
	
	
