package com.codebase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseClass.BaseUi;
import com.resources.DSLLibDesktop;

public class AmazonTestClass {
	DSLLibDesktop dsl;
	  
	  

	  @BeforeClass
	  public void beforeClass() throws Exception {
		  	dsl = new DSLLibDesktop();
		  	//dsl.launchBing();
		  	dsl.launchAmazon();
	  }
	  
	  @Test
	  public void Test01_Verify_Amazon_Title() {
		  dsl.amazontestclass.CheckAmazonTitle();
	  }
	  
	  @Test
	  public void Test01_Verify_Amazon_Logo() {
		  dsl.amazontestclass.CheckAmazonLogo();
	  }
	  
	  @AfterClass
	  public void afterClass() throws Exception {
		  dsl.closeBrowser();
		  
	  }
}
