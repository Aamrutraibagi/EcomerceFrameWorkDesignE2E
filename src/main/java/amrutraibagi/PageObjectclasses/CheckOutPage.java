package amrutraibagi.PageObjectclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import amrutraibagi.AbstractComponentsclasses.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//WebElement countryfield=driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]"))
	@FindBy(xpath="//input[@placeholder=\"Select Country\"]")
	WebElement countryfield;
	
	//WebElement selectCountry=driver.findElement(By.xpath("(//span[@class=\"ng-star-inserted\"])[2]")).click();
	@FindBy(xpath="(//span[@class=\"ng-star-inserted\"])[2]")
	WebElement selectCountry;
	
	//WebElement placeOrder=driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeOrder;
	
//	Actions a=new Actions(driver);
//	a.sendKeys(driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")),"india").build().perform();
//	JavascriptExecutor js=(JavascriptExecutor) driver;
//	js.executeScript("window.scrollBy(0,500)");
//	driver.findElement(By.xpath("(//span[@class=\"ng-star-inserted\"])[2]")).click();
//	driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
	
	public void selectCountry(String countryName) {
		Actions a=new Actions(driver);
		a.sendKeys(countryfield,countryName).build().perform();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//	    js.executeScript("window.scrollBy(0,500)");
		scrollDownPage(500);
		selectCountry.click();
		
	}
	
	public ConfirmationPage placeOrder() {
		placeOrder.click();
		ConfirmationPage confirmatiopage=new ConfirmationPage(driver);
		return confirmatiopage;
	}
	
	
	
	
}
