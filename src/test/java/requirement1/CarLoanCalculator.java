package requirement1;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.Utils;

public class CarLoanCalculator {

		
	/*driver variable*/
	private static WebDriver driver;
	
	
	/*setting-up properties and opening browser*/
	@Test(priority=2)
	public static void  createWebDriver() {
		
		driver=Utils.driverSetUp();
	}
	
	
	/*navigating to URL*/
	@Test(priority=3)
	public static void navigateUrl(){
		 
		driver.get(Utils.readProperty("Website"));
	}
	
	@Test(priority=4)
	public static void enterData() {
		driver.navigate().back();
		driver.navigate().forward();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"car-loan\"]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"loanamount\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"loanamount\"]")).sendKeys(Utils.readProperty("Amount"));
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"loaninterest\"]")).clear();
		for(int i=0;i<5;i++)
		driver.findElement(By.xpath("//*[@id=\"loaninterest\"]")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.xpath("//*[@id=\"loaninterest\"]")).sendKeys(Utils.readProperty("Rate"));
		
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div/div/label[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"loanterm\"]")).sendKeys(Keys.BACK_SPACE);;
		driver.findElement(By.xpath("//*[@id=\"loanterm\"]")).sendKeys(Utils.readProperty("Tenure"));
		driver.findElement(By.xpath("//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div/div/label[2]")).click();
	}
	
	@Test(priority=5)
	private static void retriveOutput() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String emi=driver.findElement(By.xpath("//*[@id=\"emiamount\"]/p/span")).getText();
		String interest=driver.findElement(By.xpath("//*[@id=\"emitotalinterest\"]/p/span")).getText();
		
		System.out.println("------Requirement 1------");
		System.out.println("Interest amount is : "+interest);
		System.out.println("Monthly EMI amount : "+emi);
		System.out.println("\n\n\n");
	}
	
	
	/*closing driver*/
	@Test(priority=6)
	public static void closeDriver() {
		driver.close();
	}
	
	
	
}
