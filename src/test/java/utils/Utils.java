package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utils {

		static int n=1;
	
	
		public static WebDriver driverSetUp() {
			RemoteWebDriver driver = null;
			String browser=readProperty("Browser");
			DesiredCapabilities d;
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",readProperty("chromeDriverPath"));
				ChromeOptions opt = new ChromeOptions();
				d = DesiredCapabilities.chrome();
				d.setCapability(ChromeOptions.CAPABILITY, opt);
			} else if(browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",readProperty("firefoxDriverPath"));
				FirefoxProfile prof = new FirefoxProfile();
				FirefoxOptions opt = new FirefoxOptions();
				opt.setProfile(prof);
				d = DesiredCapabilities.firefox();
				d.setCapability(FirefoxOptions.FIREFOX_OPTIONS, opt);
			} else {
				throw new InvalidArgumentException("Browser not supported"+"\n check your input in the properties file");
			}

			try {
				
					driver = new RemoteWebDriver(new URL(readProperty("hostUrl")), d);
						
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

			return driver;
			
		}
		public static String readProperty(String key) {
			String out = null;
			Properties props = new Properties();
			InputStream readFile=null;
			File file=new File(".\\src/test/resources\\setup.properties");
			try{
				readFile= new FileInputStream(file);
				
				props.load(readFile);
				
				out= props.getProperty(key);
				 

				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			return out;
			
		}
		public static void takeScreenShot(WebDriver driver) {
			
			File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			String fileName="screen";
			
			try {
				FileUtils.copyFile(file, new File(readProperty("screenshots").trim()+"\\"+fileName+n+".png"));
				System.out.println("Screenshot "+n+" is captured and stored");
				n++;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
}
