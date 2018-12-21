

package com_Actions;

import java.io.File;
import java.io.FileInputStream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.Color;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Actions_performing implements Interface1 {
	

	static WebDriver driver;

	ExtentReports report;
	ExtentTest logger;

	@BeforeClass
	public void befp() throws Exception {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sandeep.mandhala\\Downloads\\All Jar files selenium\\chromedriver.exe");

		report = new ExtentReports(
				"C:\\Users\\sandeep.mandhala\\eclipse-workspace\\SPICEJET\\src\\Com\\Utilities\\Actions_ExtentReport.html");
		logger = report.startTest("befp");
		driver = new ChromeDriver();

		logger.log(LogStatus.INFO, "open browser");
	//driver.get("https://jqueryui.com/droppable/");
		
		//screenshot(driver);
		

	 driver.get("http://ec2-54-177-6-43.us-west-1.compute.amazonaws.com/");
	 logger.log(LogStatus.INFO, "Entered url");
	 
	 //set size
	/*Dimension dim=new Dimension(20, 30);
	 driver.manage().window().setSize(dim);*/
	 
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test
	public void handleWebtable() throws Exception {
		
		
		driver.findElement(By.id("Email")).sendKeys("admin@suiteamerica.com");

		driver.findElement(By.id("password")).sendKeys("Dev@2017");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.findElement(By.xpath("//*[@id='wrapper']/div[3]/div/div[1]/div/div/div/div/ul/li[11]/a/div")).click();
		
		WebElement table=driver.findElement(By.tagName("table"));

		Thread.sleep(3000);
		
		WebElement row =table.findElement(By.xpath("//*[@id='addResultsGrid']/div[2]/div[1]/table/tbody/tr[2]"));
		
		String str=row.getText();
		System.out.println("all row details"+str);
		
	}

	@Test(enabled = false)
	public void suiteFrame() throws Exception {

		driver.findElement(By.id("Email")).sendKeys("admin@suiteamerica.com");

		driver.findElement(By.id("password")).sendKeys("Dev@2017");

		// taking all locators and use one with using tagname
		List<WebElement> liv = driver.findElements(By.tagName("button"));

		liv.get(0).click();

		List<WebElement> frame = driver.findElements(By.tagName("iframe"));	

		int com = frame.size();
		
	
		

		System.out.println("all frames in suite:::" + com);
		// driver.switchTo().frame(0);

		driver.findElement(By.xpath("//*[@id='wrapper']/div[3]/div/div[1]/div/div/div/div/ul/li[2]/a/div")).click();

		apply();

		/*
		 * // Get The All DropDown values Code WebElement
		 * web=driver.findElement(By.xpath(""));
		 * 
		 * Select sel=new Select(web);
		 * 
		 * 
		 * List<WebElement> strin=sel.getOptions();
		 * 
		 * System.out.println(strin);
		 * 
		 * for (int i = 0; i < strin.size(); i++) {
		 * System.out.println(strin.get(i).getText());
		 * 
		 * if (strin.get(i).getText().equals("something")) {
		 * driver.findElement(By.id("")).sendKeys(strin.get(i).getText()); } } //From
		 * Here
		 */

		// navigate to other screen and multiple windows
		/*
		 * driver.navigate().back(); String str=driver.getWindowHandle();
		 * driver.switchTo().window("User Login - Suite America");
		 */

		// ac.keyDown(Keys)
		// User Login - Suite America
		// System.out.println("list of buttons::::::" +com);

		driver.findElement(By.tagName(""));

		// clicking the element with using javascript excutor
		try {
			WebElement web1 = driver.findElement(By.xpath("//button[text()='Submit']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].click()", web1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("Error due to:" + e.getLocalizedMessage());
		}

		Thread.sleep(2000);
		// driver.findElement(By.xpath("//button[text()='Submit']")).click();

		// driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/nav/ul[3]/li[5]/a/div/span")).click();
		WebElement log = driver.findElement(By.xpath("//span[text()='Logout']"));
	

		if (log.isDisplayed()) {
			log.click();

		} else {
			System.out.println("logout button is not found");
		}
		/*
		 * //clicking the element with using javascript excutor WebElement
		 * web=driver.findElement(By.id(""));
		 * 
		 * ((JavascriptExecutor)driver).executeScript("arguments[0].click()", web);
		 */

		/*
		 * int frame=driver.findElements(By.tagName("iframe")).size();
		 * System.out.println("all frames"+frame);
		 */
	}

	@Test(enabled = false)
	public void tes() throws Exception {
		driver.findElement(By.xpath("//a[text()='Droppable']")).click();

		Actions act = new Actions(driver);
		driver.switchTo().frame(0);
		Thread.sleep(2000);

		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		act.dragAndDrop(drag, drop).perform();

		Thread.sleep(2000);
		
		// act.doubleClick(drop);
		// act.contextClick(drop).perform();
		// Thread.sleep(2000);
		// WebElement mov=driver.findElement(By.xpath("//a[text()='Themes']"));
		// act.moveToElement(mov).build().perform();
		// Thread.sleep(2000);
		driver.switchTo().defaultContent();

		act.sendKeys(Keys.PAGE_DOWN).build().perform();	
		act.sendKeys(Keys.PAGE_UP).build().perform();
		// act.doubleClick(mov);
		driver.switchTo().frame(1);

		driver.findElement(By.xpath("//a[text()='Dialog']")).click();
		driver.switchTo().frame(0);

		WebElement get = driver.findElement(By.xpath("//*[@id='dialog']/p"));

		String str = get.getText();
		// System.out.println(str);
		String[] slipt = str.split(" ");
		for (int i = 0; i < slipt.length; i++) {
			System.out.println(slipt[i]);

			if (slipt[i].equalsIgnoreCase("closed")) {
				System.out.println("the value ::::" + slipt[i]);
				String sm = slipt[i];

				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div/div[1]/button/span[1]")).click();
				driver.switchTo().defaultContent();

				driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();

				int all_frame_size = driver.findElements(By.tagName("iframe")).size();
				System.out.println("all frames count" + all_frame_size);

				driver.switchTo().frame(0);
				driver.findElement(By.id("tags")).sendKeys(sm);
				// driver.switchTo().frame("//iframe[@class='demo-frame']");

				// System.out.println("sorry :::" + sm);
			}

		}

		Alert alert = driver.switchTo().alert();
		String al = alert.getText();
		alert.accept();
System.out.println(al);
		Thread.sleep(2000);
		driver.close();
		/*
		 * alert.dismiss(); System.out.println(al);
		 * 
		 * Thread.sleep(2000); driver.close(); //*[@id="dialog"]/p } 
		 */
	}

	public boolean apply() {

		WebElement col = driver
				.findElement(By.xpath("//*[@id='wrapper']/div[3]/div/div[2]/div/div[1]/div/div/div[1]/a"));

		String testcolor = col.getCssValue("color");
		String actual_results = Color.fromString(testcolor).asHex();
		System.out.println("The color is:::" + actual_results);

		if (actual_results.equals("#ffffff")) {

		System.out.println("if color::" + actual_results);
			return true;
		}
		return false;
		
	
	}

	@Test(enabled=false)
	public void buttonTesting() throws Exception {

		// getLocation
		/*
		 * WebElement web= driver.findElement(By.xpath("//a[text()='Download']")); Point
		 * poiun=web.getLocation(); int xcord=poiun.getX(); int ycor=poiun.getY();
		 * 
		 * Actions act=new Actions(driver);
		 * 
		 * act.moveToElement(web,xcord,ycor).click().build().perform();
		 * 
		 * 
		 */
		eat();
		travel();

		List<WebElement> but = driver.findElements(By.tagName("a"));
		logger.log(LogStatus.INFO, "get the all a links");
	
		for (int i = 0; i < but.size(); i++) {

			// System.out.println("All buttons in jquery::"+but.get(i).getText());

			try {
				if (but.get(i).getText().equals("Demos")) {
					// but.get(i).click();
    System.out.println(but.get(i).getText());

	but.get(i).click();	
					break;

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.log(LogStatus.FAIL, "showing error somewhare");
				logger.log(LogStatus.ERROR, "error came" + e.getLocalizedMessage());

			}
   
		}
		try {
			driver.findElement(By.linkText("Draggable9")).click();

		} catch (Exception e) {
			// TODO Auto-generated catch block 
			logger.log(LogStatus.FAIL, "extent report" + e.getLocalizedMessage());
			logger.log(LogStatus.ERROR,"Screenshot : " +screenshot(driver));
		}
		screenshot(driver);
	}
	

	// but.get(28).click();
	@AfterTest
	public void tearDown() {
		report.flush();
		report.endTest(logger);
		driver.quit();
	}

	String path = "";
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	Date dt = new Date();
	String html = "";

	public String screenshot(WebDriver driver) throws Exception {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		html = covertScreenshotToBase64(source, "screenshot.png");
		path = System.getProperty("user.dir") + File.separator + "screenshots";
		FileUtils.copyFile(source,
				new File(path + File.separator + dateFormat.format(dt) + "_Screenshot.png"));
		return html;
	}

	public static String doImageClickAnimation(String img, String screenName) {

		String image = "<img src=\"data:image/png;base64, " + img + "\" alt=\"" + screenName
				+ "\" width=\"500\" height=\"250\"/>";
			
		return image;
	
		

	}

	@SuppressWarnings("resource")
	public static String covertScreenshotToBase64(File file, String name) {
		try {
			FileInputStream fis = new FileInputStream(file);
			byte byteArray[] = new byte[(int) file.length()];
			fis.read(byteArray);
			String imageString = Base64.encodeBase64String(byteArray);
			return doImageClickAnimation(imageString, name);
		} catch (Exception e) {
			e.printStackTrace();
			e.getLocalizedMessage();
		}
		return null;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("interface1");
		
	}

	@Override 
	public void travel() {
		// TODO Auto-generated method stub
		System.out.println("interface2");
		
	}

	@Test(enabled=false)
 public void againTestcase() throws Exception {
	 
driver.findElement(By.linkText("Checkboxradio")).click();

List<WebElement> frame=driver.findElements(By.tagName("iframe"));

int abc=frame.size();
System.out.println("all"   + abc);
driver.switchTo().frame(0);

WebElement checkbox=driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[1]"));

if (!checkbox.isSelected()) {	
	
	checkbox.click();

	System.out.println("checkbox clicked");                                                                                                    
	Thread.sleep(3000);
	
} 

else {
	
	System.out.println("checkbox is not selected");
}
driver.switchTo().defaultContent();
driver.findElement(By.xpath("//img[@title='Support the JS Foundation']")).click();

WebElement twitter=driver.findElement(By.xpath("//i[@class='fa fa-twitter']"));
WebElement Linkidin=driver.findElement(By.xpath("//i[@class='fa fa-linkedin']"));
WebElement rss=driver.findElement(By.xpath("//i[@class='fa fa-rss']"));
WebElement git=driver.findElement(By.xpath("//i[@class='fa fa-github-alt']"));
Actions act=new Actions(driver);

act.moveToElement(twitter).perform();
Thread.sleep(2000);

act.moveToElement(Linkidin).build().perform();
Thread.sleep(2000);

act.moveToElement(rss).build().perform();
Thread.sleep(2000);


act.moveToElement(git).build().perform();
Thread.sleep(2000);

driver.navigate().back();
Thread.sleep(2000);

driver.findElement(By.xpath("//a[text()='Slider']")).click();

driver.switchTo().frame(0);
WebElement slider=driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
act.clickAndHold(slider);

act.moveByOffset(300, 0).build().perform();

//act.dragAndDropBy(slider, 0, 100).build().perform();

Thread.sleep(2000);
driver.switchTo().defaultContent();


driver.findElement(By.linkText("Tooltip")).click();
driver.switchTo().frame(0);
WebElement age1=driver.findElement(By.xpath("//input[@title='We ask for your age only for statistical purposes.']"));
act.clickAndHold(age1);


String st=age1.getAttribute("title");
System.out.println("tooltip:::"+st);
Thread.sleep(5000);
/*WebElement Element = driver.findElement(By.linkText("Linux"));

//This will scroll the page till the element is found		
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", Element);*/
		
/*		driver.findElement(By.id("Email")).sendKeys("admin@suiteamerica.com");	

		driver.findElement(By.id("password")).sendKeys("Dev@2017");

		// taking all locators and use one with using tagname
		List<WebElement> liv = driver.findElements(By.tagName("button"));

		liv.get(0).click();
		
		driver.findElement(By.xpath("//*[@id='wrapper']/div[2]/nav/ul[3]/li[5]/a/div/span")).click();
	 WebElement logout=driver.findElement(By.xpath("//span[text()='Logout']"));
	 
	 if (logout.isDisplayed()) {
		logout.click();
		System.out.println("clicked logout");
	}
	 
	 else {
		 System.out.println("logout not displayed");
 }}*/
}
}

