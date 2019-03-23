package com.codebase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseClass.BaseUi;
import com.resources.DSLLibDesktop;

public class FacebookTestClass {
	DSLLibDesktop dsl;
	  

	  @BeforeClass
	  public void beforeClass() throws Exception {
		  	dsl = new DSLLibDesktop();
			//dsl.launchBing();
		  	//dsl.launchTwitter();
		  	dsl.launchFacebook();
	  }
	  
	  @Test
	  public void Test01_Verify_Facebook_Title() {
		  //dsl.bestbuytestclass.CheckBestBuyTitle();
		  dsl.facebooktestclass.CheckFacebookTitle();
	  }
	  
	  @Test
	  public void Test01_Verfiy_Facebook_Logo() {
		  dsl.facebooktestclass.CheckFacebookLogo();
	  }
	  
	  @AfterClass
	  public void afterClass() throws Exception {
		  dsl.closeBrowser();  
	  }
}
