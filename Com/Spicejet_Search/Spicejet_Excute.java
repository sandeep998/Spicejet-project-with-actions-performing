package Com.Spicejet_Search;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Com.Utilities.Config_Class;



public class Spicejet_Excute extends Explicit_Base_Class {

	Page_ClassofSPicejet page=new Page_ClassofSPicejet(driver);
	public ExtentReports report;
	public ExtentTest test;
	
	
	private Config_Class config;
	
  @BeforeClass
  public void before() throws Exception {
	
	  report = new ExtentReports("C:\\Users\\sandeep.mandhala\\eclipse-workspace\\SPICEJET\\results_spicejet.html", true);
	 test=report.startTest("verify test");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sandeep.mandhala\\Downloads\\All Jar files selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		//driver.get("https://book.spicejet.com/");
		config=new Config_Class();
	
		//config.getProperty("Spicejet_Excute.properties");
	config.loard();
		driver.get(config.getProperty("URL"));

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		test.log(LogStatus.INFO, "browser is running");
	 
  }
  @Test
  public void testing() throws Exception {
	  
	try {
		page.Multicity(driver);
		test.log(LogStatus.INFO, "Entered Multicity");
		Thread.sleep(2000);
		/*Alert aler=driver.switchTo().alert();
		aler.accept();*/
		page.alertBtn(driver);
		Thread.sleep(2000);
		test.log(LogStatus.INFO, "Clicked Alert Button");
		
		page.departureCity(driver, config.getProperty("departure"));
		
		test.log(LogStatus.INFO, "Enter departurecity from thirupathi");
		
		page.arrivalCity(driver, config.getProperty("arrival"));
		test.log(LogStatus.INFO, "Enter arrival to hyderbad");
		
		 Actions builder = new Actions(driver);
		
		
		WebElement move=driver.findElement(By.id(""));
		
		builder.moveToElement(move).build().perform();
		
		
	} catch (Exception e) {
		test.log(LogStatus.ERROR, "Element not found");
		test.log(LogStatus.FAIL, "failed test case");
		captureScreenshot(driver, "Error");
		
	}
	 
  }


  @AfterTest
   public void close() {
	  report.flush();
	 report.endTest(test);
	  driver.quit();
	


  }
 /* public static void config() throws Exception {
   
		 File	src = new File("C:\\Users\\sandeep.mandhala\\eclipse-workspace\\SPICEJET\\src\\Com\\Utilities\\Config_file");
		  FileInputStream fis = new FileInputStream(src);
		  Properties	prop = new Properties();
		  prop.load(fis);

}*/
}







