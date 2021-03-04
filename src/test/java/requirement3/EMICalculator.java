package requirement3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Utils;


public class EMICalculator {
	
	public static WebDriver  driver;
	public static String baseUrl;

	public static WebElement slider1;
	public static WebElement slider2;
	public static WebElement slider3;
	public static WebElement slider4;
	public static WebElement slider5;
	public static WebElement slider6;
	public static WebElement slider7;
	public static WebElement slider8;
	public static WebElement slider9;
	public static WebElement slider10;
	public static WebElement slider11;
	public static WebElement slider12;
	
		
	
	@Test(priority=1)
	public void createDriver() throws Exception  {
		driver=Utils.driverSetUp();
	}
	
	//URL
	@Test(priority=2)
	private void getURL() {
		driver.get(Utils.readProperty("Website"));
		System.out.println("-----Requirement 3-----");
	}
	
	@Test(priority=3)
	private void LoanCalculator() {
		driver.findElement(By.xpath("//*[@id='menu-item-2696']")).click();// click on "calculators"
		driver.findElement(By.xpath("//*[@id='menu-item-2423']")).click(); // click on "loan calculators"
		
		
		driver.navigate().back();
		driver.navigate().forward(); // navigating back to avoid the ad
		
		
		
		
		//EMI Calculator
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		// checking Sliders and text boxes
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		slider1=driver.findElement(By.xpath("//*[@id='loanamountslider']/span")); // checking loan slider
		Actions action= new Actions(driver);
		action.dragAndDropBy(slider1, 50, 0).build().perform();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		slider2=driver.findElement(By.xpath("//*[@id='loaninterestslider']/span")); // checking  interest slider
		Actions action1= new Actions(driver);
		action1.dragAndDropBy(slider2, 10, 0).build().perform();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,500)");
		slider3=driver.findElement(By.xpath("//*[@id='loantermslider']/span")); // checking  tenure slider
		Actions action2= new Actions(driver);
		action2.dragAndDropBy(slider3, 10, 0).build().perform();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		slider4=driver.findElement(By.xpath("//*[@id='loanfeesslider']/span")); // checking fees slider
		Actions action3= new Actions(driver);
		action3.dragAndDropBy(slider4, 20, 0).build().perform();
		
		
		// scrolling down the page to locate the calendar element
		
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='startmonthyear']")).click(); // inspecting calendar text box
		driver.findElement(By.cssSelector("span[class='month focused active']")).click();
		
		
	}


    // changing Tenure scale
	
	   @Test(priority=4)
    public void ChangeOfScale() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]")).click(); // changing from year to month
		
		
	}
	
	// taking screenshot of change in scale
	   
	   @Test(priority=5)
	public static void Screenshot1() throws IOException {
		
		Utils.takeScreenShot(driver);
	}
	
	
	// Loan Amount Calculator
	   
	   @Test(priority=6)
	public void LoanAmountCalculator() {
		
		  JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//*[@id=\"loan-amount-calc\"]/a[1]")).click(); // clicking on Loan amount cal
		 
		// checking text boxes and scales
		 
		 slider5 = driver.findElement(By.xpath("//*[@id=\"loanemislider\"]/span"));
		 Actions drag = new Actions(driver);
		 drag.dragAndDropBy(slider5, 50, 0).build().perform();
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 slider6 = driver.findElement(By.xpath("//*[@id=\"loaninterestslider\"]/span"));
		 Actions drag1 = new Actions(driver);
		 drag1.dragAndDropBy(slider6, 50, 0).build().perform();
		 
		 
		 js.executeScript("window.scrollBy(0,500)");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     slider7 = driver.findElement(By.xpath("//*[@id=\"loantermslider\"]/span"));
		 Actions drag2 = new Actions(driver);
		 drag2.dragAndDropBy(slider7, 50, 0).build().perform();
		
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 slider8 = driver.findElement(By.xpath("//*[@id=\"loanfeesslider\"]/span"));
		 Actions drag3 = new Actions(driver);
		 drag3.dragAndDropBy(slider8, 50, 0).build().perform();
		
		
}
	   
	    @Test(priority=7)
	    public void ChangeOfScale2() {
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]")).click();
			WebElement slider4 = driver.findElement(By.xpath("//*[@id=\"loantermslider\"]/span"));
			 Actions move4 = new Actions(driver);
			 move4.dragAndDropBy(slider4, 50, 0).build().perform();
			
		
		}
		
		// Taking screenshot of change in scale
		
	    @Test(priority=7)
	    
		public static  void Screenshot2() throws IOException {
	    	Utils.takeScreenShot(driver);
		}
			
	
	// Loan tenure Calculator
	
	    @Test(priority=8)
	    public void LoanTenureCalculator() {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
		
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"loan-tenure-calc\"]/a[1]")).click(); // click on loan tenure calculator
		
		
		// check text boxes and scales
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 slider9 = driver.findElement(By.xpath("//*[@id=\"loanamountslider\"]/span"));
		 Actions move = new Actions(driver);
		 move.dragAndDropBy(slider9, 50, 0).build().perform();
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 slider10 = driver.findElement(By.xpath("//*[@id=\"loanemislider\"]/span"));
		 Actions move1 = new Actions(driver);
		 move1.dragAndDropBy(slider10, 50, 0).build().perform();
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 js.executeScript("window.scrollBy(0,500)");
		 slider11 = driver.findElement(By.xpath("//*[@id=\"loaninterestslider\"]/span"));
		 Actions move2 = new Actions(driver);
		 move2.dragAndDropBy(slider11, 50, 0).build().perform();
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 slider12 = driver.findElement(By.xpath("//*[@id=\"loanfeesslider\"]/span"));
		 Actions move3 = new Actions(driver);
		 move3.dragAndDropBy(slider12, 50, 0).build().perform();
		 
		 
	
	}	
	
	// Taking screenshot of the Page
	
	    @Test(priority=9)
	public static void Screenshot3() throws IOException {
	    	Utils.takeScreenShot(driver);
	}
	
	  
	
	// CLOSE BROWSER
	    
	    @Test(priority=10)
	public void quitDriver() {
		driver.close();
		System.out.println("Execution completed\n\nCheck screenshots in folder to varify results\npath= "+Utils.readProperty("screenshots")+"\n\n");
		
	}
	
	
	



}
