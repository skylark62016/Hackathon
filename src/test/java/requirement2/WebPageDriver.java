package requirement2;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.Utils;

public class WebPageDriver {

	/*global variables*/
	protected static WebDriver driver;
	protected static int rowno;

	
	
	@Test(priority=2)
	public static void  createWebDriver() {
		
		
		driver=Utils.driverSetUp();
	}
	
	@Test(priority=3)
	public static void navigateUrl(){
		 
		driver.get(Utils.readProperty("Website"));
	}
	
	@Test(priority=4)
	public static void navigateToHomeLoanPage() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"menu-item-dropdown-2696\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"menu-item-3294\"]/a")).click();
		driver.navigate().back();
		driver.navigate().forward();
	}
	@Test(priority=5)
	public static void readExcelSheet() {
		ReadExcel.readFromExcel();
	}
	
	@Test(priority=6)
	public static void insertValueToWebsite() {
		driver.navigate().back();
		driver.navigate().forward();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"homeprice\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"homeprice\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"homeprice\"]")).sendKeys(ReadExcel.data[0]);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"downpayment\"]")).clear();		
		driver.findElement(By.xpath("//*[@id=\"downpayment\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"downpayment\"]")).sendKeys(ReadExcel.data[1]);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"homeloaninsuranceamount\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"homeloaninsuranceamount\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"homeloaninsuranceamount\"]")).sendKeys(ReadExcel.data[2]);
		
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"homeloaninterest\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"homeloaninterest\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"homeloaninterest\"]")).sendKeys(Keys.BACK_SPACE+ReadExcel.data[3]);
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"homeloanterm\"]")).clear();
		for(int i=0;i<10;i++)
		driver.findElement(By.xpath("//*[@id=\"homeloanterm\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"homeloanterm\"]")).sendKeys(ReadExcel.data[4]);
		rowno=(int)Float.parseFloat(driver.findElement(By.xpath("//*[@id=\"homeloanterm\"]")).getAttribute("value"));
	
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"loanfees\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"loanfees\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"loanfees\"]")).sendKeys(ReadExcel.data[5]);
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"startmonthyear\"]")).click();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
		LocalDateTime now = LocalDateTime.now();
		driver.findElement(By.xpath("//*[contains(text(),"+dtf.format(now)+")]")).click();
		driver.findElement(By.xpath("//*[contains(text(),"+ReadExcel.data[6].split(" ")[0]+")]")).click();
		driver.findElement(By.xpath("//*[contains(text(),"+ReadExcel.data[6].split(" ")[1]+")]")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"onetimeexpenses\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"onetimeexpenses\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"onetimeexpenses\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"onetimeexpenses\"]")).sendKeys(ReadExcel.data[7]);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"propertytaxes\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"propertytaxes\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"propertytaxes\"]")).sendKeys(ReadExcel.data[8]);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"homeinsurance\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"homeinsurance\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"homeinsurance\"]")).sendKeys(ReadExcel.data[9]);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"maintenanceexpenses\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"maintenanceexpenses\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"maintenanceexpenses\"]")).sendKeys(ReadExcel.data[10]);
		
		
		
		
		
		js.executeScript("window.scrollBy(0,1000)"); //Scroll vertically down by 500 pixels	
		
	}
	
	@Test(priority=7)
	public static void writeExcel() {
		WriteExcel.writeIntoExcel(driver);
	}
	
	/*closing driver*/
	@Test(priority=8)
	public static void closeDriver() {
		driver.close();
	}
	
	
}
