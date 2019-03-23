package com.codebase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.baseClass.BaseUi;
import com.resources.DSLLibDesktop;

public class BingTestClass {
	DSLLibDesktop dsl;
	  //public String xPath = "D:/Excels/MyExcel.xls";
	  //public String xPath = "D:/Excels/MyFirstExcel.xlsx";
	  //public String xlPath_Res = "D:/Excels/userStatuses.xlsx";
	  //public static String XData[][];
	  //public String xlData[][];
	  

	  @BeforeClass
	  public void beforeClass() throws Exception {
		  	dsl = new DSLLibDesktop();
			//dsl.launchCubixCo();
		  	//dsl.launchGoogle();
		  	//dsl.xlRead(xPath);
		  	dsl.launchBing();
		  	
	  }
	  
	  @Test
	  public void Test01_Verify_Bing_Title() {
		  dsl.bingtestclass.CheckBingTitle();
	  }
	  
	  @Test
	  public void Test02_Verify_Bing_Log() {
		  dsl.bingtestclass.CheckLogo();
	  }
	  
	  @Test
	  public void Test03_Verify_Search_Text_Box() {
		  dsl.bingtestclass.CheckTextBox();
	  }
	  
	  @Test
	  public void Test04_Verify_Camericon() {
		  dsl.bingtestclass.CheckCameraIcon();
	  }
	  
	  @Test
	  public void Test05_Verify_MapsIcon() {
		  dsl.bingtestclass.CheckMapsIcon();
	  }
	  
	  @AfterClass
	  public void afterClass() throws Exception {
		  dsl.closeBrowser();
		  //xlwrite(xlPath_Res, XData);//Writes the results
		  //BaseUi.xlwrite(xlPath_Res, XData);
		  
	  }
}
