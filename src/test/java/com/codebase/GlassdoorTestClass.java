package com.codebase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseClass.BaseUi;
import com.resources.DSLLibDesktop;

public class GlassdoorTestClass {
	DSLLibDesktop dsl;
	  

	  @BeforeClass
	  public void beforeClass() throws Exception {
		  	dsl = new DSLLibDesktop();
			//dsl.launchBing();
		  	//dsl.launchTwitter();
		  	//dsl.launchFacebook();
		  	dsl.launchGlassdoor();
	  }
	  
	  @Test
	  public void Test01_Verify_Glassdoor_Title() {
		  //dsl.bestbuytestclass.CheckBestBuyTitle();
		  dsl.glassdoortestclass.CheckGlassdoorTitle();
	  }
	  
	  @Test
	  public void Test02_Verify_If_Glassdoor_Logo_appeared_or_not() {
		  dsl.glassdoortestclass.CheckGlassdoorLogo();
	  }
	  
	  @AfterClass
	  public void afterClass() throws Exception {
		  dsl.closeBrowser();  
	  }
}
