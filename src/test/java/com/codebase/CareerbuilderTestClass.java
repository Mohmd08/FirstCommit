package com.codebase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseClass.BaseUi;
import com.resources.DSLLibDesktop;

public class CareerbuilderTestClass {
	DSLLibDesktop dsl;
	  

	  @BeforeClass
	  public void beforeClass() throws Exception {
		  	dsl = new DSLLibDesktop();
			//dsl.launchBing();
		  	//dsl.launchTwitter();
		  	//dsl.launchFacebook();
		  	dsl.launchCareerbuilder();
	  }
	  
	  @Test
	  public void Test01_Verify_BestBuy_Title() {
		  dsl.bestbuytestclass.CheckBestBuyTitle();
	  }
	  
	  @AfterClass
	  public void afterClass() throws Exception {
		  dsl.closeBrowser();  
	  }
}
