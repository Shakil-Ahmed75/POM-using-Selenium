package testCases;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class WebBase {

	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup()
	{

		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		//implicit wait of 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().timeouts().pageLoadTimeout()
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		//for logging
		logger = LogManager.getLogger("PomUsingSelenium");
		
		//open url
		driver.get(url);
		logger.info("url opened");

	}



	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

	
	
}
