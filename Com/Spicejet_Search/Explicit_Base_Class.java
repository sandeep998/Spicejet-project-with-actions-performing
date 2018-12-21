package Com.Spicejet_Search;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Base_Class {
	
	static WebDriver driver;
	
	public static WebElement visibiltyofElement(WebDriver driver,int time,By locat) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locat));
		
	}
	public static WebElement presenceOfElement(WebDriver driver,int time,By loc) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(loc));
		
	}
	public static WebElement elementToClick(WebDriver driver,int time,By loc) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		
		return wait.until(ExpectedConditions.elementToBeClickable(loc));
		
	}

	
	  public String captureScreenshot(WebDriver driver, String screenShotName) {
		  String path = "";
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
			Date dt = new Date();
			String html = "";
			try {
				System.out.println(dateFormat.format(dt));
				TakesScreenshot ts = (TakesScreenshot) driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
				// html = covertScreenshotToBase64(source , screenShotName);
				path = System.getProperty("user.dir") + File.separator + "screenshots";
				createDirectory(path);
				FileUtils.copyFile(source,
						new File(path + File.separator + dateFormat.format(dt) + "_" + screenShotName + ".png"));
				System.out.println("screenshot is taken");

			} catch (Exception e) {
				System.out.println("exception while taking screenshot" + e.getMessage());
			}

			return html;
		}
		public static boolean createDirectory(String directory) {
			File fileDirectory = new File(directory);
			if (!fileDirectory.exists()) {
				fileDirectory.mkdir();
				return true;
			}
			return false;

		}
}
