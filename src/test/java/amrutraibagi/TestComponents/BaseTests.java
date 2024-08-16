package amrutraibagi.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import amrutraibagi.PageObjectclasses.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTests {
	public WebDriver driver;
	public LandingPage LP;
	public WebDriver initializeDriver() throws IOException {
		//Properties class
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//amrutraibagi//Resounces//GlobalData.properties");
		prop.load(fis);
		
		//If I want to share the value from mvn cmd 
		//System.getProperty("browser") it take value from command if it is null it will execute "prop.getProperty("Browser")" by taking value from GlobalData Properties file
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("Browser");
		//String browserName=prop.getProperty("Browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options=new ChromeOptions();
			//When we run in headless mode so chrome browser will not open 
			//options.addArguments("headless");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(options);
		}else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
		
		driver=initializeDriver();
		LP = new LandingPage(driver);
		LP.Goto();
		return LP;
	}
	
	@AfterMethod(alwaysRun=true)
	public void teardown() {
		driver.close();
	}
	
	public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
		TakesScreenshot TS=(TakesScreenshot)driver;
		File src=TS.getScreenshotAs(OutputType.FILE);
		File File=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(src, File);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
		
	}

}
