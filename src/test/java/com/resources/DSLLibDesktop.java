package com.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.codebase.ui.AmazonTestClass_UI;
import com.codebase.ui.BestBuyTestClass_UI;
import com.codebase.ui.BingTestClass_UI;
import com.codebase.ui.CareerbuilderTestClass_UI;
import com.codebase.ui.CignaTestClass_UI;
import com.codebase.ui.CnnTestClass_UI;
import com.codebase.ui.DiceTestClass_UI;
import com.codebase.ui.FacebookTestClass_UI;
import com.codebase.ui.GlassdoorTestClass_UI;
import com.codebase.ui.LinkedinTestClass_UI;
import com.codebase.ui.TribunepublishingTestClass_UI;
import com.codebase.ui.TwitterTestClass_UI;
import com.codebase.ui.WebTestClass_UI;
import com.codebase.ui.YouTubeTestClass_UI;
import com.codebase.ui.ZiprecruiterTestClass_UI;
import com.util.YamlReader;

public class DSLLibDesktop {

	public static String URL1 = "";
	public WebDriver driver;
	public static String browser = null;
	public static String user = null;
	protected static String setting;
	protected static String tier;
	protected static String accessCodeSheet;
	protected static HashMap<String, String> server;
	protected static DesiredCapabilities capabilities;
	public boolean baseURL = true;
	
	static String XLData[][];
	public int XLRows;
	public int XLCols;
	public int count;
	String Read = "c:/abc/abc.xlxs";
	
	public WebTestClass_UI webtestclass;
	public BingTestClass_UI bingtestclass;
	public YouTubeTestClass_UI youtubetestclass;
	public BestBuyTestClass_UI bestbuytestclass;
	public AmazonTestClass_UI amazontestclass;	
	public CignaTestClass_UI cignatestclass;
	public LinkedinTestClass_UI linkedintestclass;
	public TwitterTestClass_UI twittertestclass;
	public FacebookTestClass_UI facebooktestclass;
	public CnnTestClass_UI cnntestclass;
	public GlassdoorTestClass_UI glassdoortestclass;
	public DiceTestClass_UI dicetestclass; 
    public CareerbuilderTestClass_UI careerbuildertestclass; 
    public ZiprecruiterTestClass_UI ziprecruitertestclass;
    public TribunepublishingTestClass_UI tribunepublishingtestclass;

	public DSLLibDesktop() {
		_initObjects();
		setting = System.getProperty("server");
		Reporter.log("setting value is" + setting);
		browser = YamlReader.getYamlValue("browser");
		Reporter.log("=================================================================");
		Reporter.log("=================================================================");
		Reporter.log("[INFO]: test browser is ".toUpperCase() + " "
				+ browser.toUpperCase());
		Reporter.log("=================================================================");
		Reporter.log("=================================================================");
		if (setting == null) {
			setting = YamlReader.getYamlValue("CurrentServer");
		}
		capabilities = new DesiredCapabilities();
		startBrowser();
	}

	/**
	 * function to start the browser
	 * 
	 * @throws MalformedURLException
	 */

	@SuppressWarnings("static-access")
	public void startBrowser() {
		if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"ChromeDriverServer/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("firefox")
				|| browser.equalsIgnoreCase("ff")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("host is="
					+ YamlReader.getYamlValue("seleniumserverhost"));

			if (YamlReader.getYamlValue("seleniumserver").contains("local")) {
				System.setProperty("webdriver.chrome.driver",
						"ChromeDriverServer/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
				options.addArguments("test-type");
				options.addArguments("start-maximized");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
			}
			if (YamlReader.getYamlValue("seleniumserver").contains("remote")) {
				System.out.println("value is="
						+ YamlReader.getYamlValue("seleniumserverhost"));
				try {
					driver = new RemoteWebDriver(new URL(
							YamlReader.getYamlValue("seleniumserverhost")),
							capabilities.chrome());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
		}
		driver.manage()
				.timeouts()
				.implicitlyWait(
						Integer.parseInt(YamlReader.getData("timeOut")),
						TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		_initObjects();
	}

	@SuppressWarnings("unused")
	private WebDriver setRemoteDriver(Map<String, String> selConfig) {
		DesiredCapabilities cap = null;
		browser = "chrome";
		if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("Safari")) {
			cap = DesiredCapabilities.safari();
		} else if ((browser.equalsIgnoreCase("ie"))
				|| (browser.equalsIgnoreCase("internetexplorer"))
				|| (browser.equalsIgnoreCase("internet explorer"))) {
			cap = DesiredCapabilities.internetExplorer();
		}
		String seleniuhubaddress = "http://10.161.129.122:4444/wd/hub";
		URL selserverhost = null;
		try {
			selserverhost = new URL(seleniuhubaddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		return new RemoteWebDriver(selserverhost, cap);
	}
	
	/**
	 * base url launchers
	 */
	public void launchCubixCo() {
		driver.get(YamlReader.getData("cubixUrl"));
	}
	
	public void launchGoogle() {
		driver.get(YamlReader.getData("googleUrl"));
	}
	
	public void launchBOLNews() {
		driver.get(YamlReader.getData("BOLNewsUrl"));
	}
	
	public void launchBOLNetwork() {
		driver.get(YamlReader.getData("BOLNetworkUrl"));
	}
	
	public void launchBolwala() {
		driver.get(YamlReader.getData("BolwalaUrl"));
	}
	
	public void launchBolwalaMerchant() {
		driver.get(YamlReader.getData("BolwalaMerchantUrl"));
	}
	
	public void launchArpatech() {
		driver.get(YamlReader.getData("ArpatechUrl"));
	}
	
	public void launchBravo() {
		driver.get(YamlReader.getData("BravoUrl"));
	}
	
	public void launchBing() {
		driver.get(YamlReader.getData("BingUrl"));
	}
	
	public void launchYouTube() {
		driver.get(YamlReader.getData("YouTubeUrl"));	
	}
	
	public void launchBestBuy() {
		driver.get(YamlReader.getData("BestBuyUrl"));
	
	
	}
	
	public void launchAmazon() {
		driver.get(YamlReader.getData("AmazonUrl"));
	}
	
	public void launchCigna() {
		driver.get(YamlReader.getData("CignaUrl"));
	}
	
	public void launchLinkedin() {
		driver.get(YamlReader.getData("LinkedinUrl"));
	}
	
	public void launchTwitter() {
		driver.get(YamlReader.getData("TwitterUrl"));
	}
	
	public void launchFacebook() {
		driver.get(YamlReader.getData("FacebookUrl"));
	}
	
	public void launchCnn() {
		driver.get(YamlReader.getData("CnnUrl"));
	}
	
	public void launchGlassdoor() {
		driver.get(YamlReader.getData("GlassdoorUrl"));
	}
		
	public void launchDice() {
		driver.get(YamlReader.getData("DiceUrl"));
	}
	
	public void launchCareerbuilder() { 
		driver.get(YamlReader.getData("CareerbuilderUrl"));
	}
	
	public void launchZiprecruiter() {
		driver.get(YamlReader.getData("ZiprecruiterUrl"));
	}
	
	public void launchTribunepublishing() {
		driver.get(YamlReader.getData("TribunepublishingUrl"));
	}
	/**
	 * function to initialize object
	 */
	private void _initObjects() {
		
		webtestclass = new WebTestClass_UI(driver);
		bingtestclass = new BingTestClass_UI(driver);
		youtubetestclass = new YouTubeTestClass_UI(driver);	
		bestbuytestclass = new BestBuyTestClass_UI(driver);
		amazontestclass = new AmazonTestClass_UI(driver);
		cignatestclass = new CignaTestClass_UI(driver);
		linkedintestclass = new LinkedinTestClass_UI(driver);
		twittertestclass = new TwitterTestClass_UI(driver);
		facebooktestclass = new FacebookTestClass_UI(driver);
		cnntestclass = new CnnTestClass_UI(driver);
		glassdoortestclass = new GlassdoorTestClass_UI(driver);
		dicetestclass = new DiceTestClass_UI(driver);
		careerbuildertestclass = new CareerbuilderTestClass_UI(driver);
		ziprecruitertestclass = new ZiprecruiterTestClass_UI(driver);
		tribunepublishingtestclass = new TribunepublishingTestClass_UI(driver);
	}

	/**
	 * function to close the browser
	 */
	public void closeBrowser() {
		try {
			//driver.quit();
			driver.close();
		} catch (Exception e) {
		}
	}

	/**
	 * function to close the browser
	 */
	public void closeBrowserAgain() {
		driver.close();
	}

	public void launchSpecficUrl(String url) {
		driver.get(url);
	}
	
		
	
	public String Get_TimeStamp() {
		Timestamp currentTimestamp1 = new Timestamp(Calendar.getInstance().getTime().getTime());
		DateFormat df1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");
		String T1 = df1.format(currentTimestamp1);
		return T1;
	}
	
	public String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2016/11/16
		return dateFormat.format(date);

	}
	
	public String getDateTime() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String Mydate = dateFormat.format(date);
		return Mydate;
		
	}

	

}
