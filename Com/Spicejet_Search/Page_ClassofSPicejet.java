package Com.Spicejet_Search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Page_ClassofSPicejet extends Explicit_Base_Class{
	WebDriver driver;
	
	public static final By MULTICITY=By.xpath("//label[text()='Multicity']");
	public static final By AlERT_BTN=By.id("btnOk");
	public static final By DEPARTURECITY=By.xpath("//input[@value='Departure City']");
	public static final By ARRIVAL_CITY=By.xpath("//input[@value='Arrival City']");
	//input[@value='Arrival City']
	
	public Page_ClassofSPicejet(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void Multicity(WebDriver driver) {
		
		visibiltyofElement(driver, 60,MULTICITY);
		driver.findElement(MULTICITY).click();
	}
	public void alertBtn(WebDriver driver) {
		
		visibiltyofElement(driver, 60,AlERT_BTN);
		driver.findElement(AlERT_BTN).click();
	}
	public void departureCity(WebDriver driver,String str) {
		
		visibiltyofElement(driver, 60,DEPARTURECITY);
		driver.findElement(DEPARTURECITY).sendKeys(str);
		/*Select sele=new Select(driver.findElement(DEPARTURECITY));
		sele.deselectByVisibleText("Tirupati (TIR)");*/
	}
	public void arrivalCity(WebDriver driver,String hyd) {
		
		visibiltyofElement(driver, 60,ARRIVAL_CITY);
		driver.findElement(ARRIVAL_CITY).sendKeys(hyd);
		
	}
	
}






















