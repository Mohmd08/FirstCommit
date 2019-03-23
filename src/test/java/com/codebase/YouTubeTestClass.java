package com.codebase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseClass.BaseUi;
import com.resources.DSLLibDesktop;

public class YouTubeTestClass {
	DSLLibDesktop dsl;
	  
	  

	  @BeforeClass
	  public void beforeClass() throws Exception {
		  	dsl = new DSLLibDesktop();
		  	//dsl.launchBing();
		  	dsl.launchYouTube();
	  }
	  
	  @Test
	  public void Test01_Verify_YouTube_Title() {
		  //dsl.bingtestclass.CheckBingTitle();
	  }
	  
	  
	  @AfterClass
	  public void afterClass() throws Exception {
		  dsl.closeBrowser();
		  
	  }
}
