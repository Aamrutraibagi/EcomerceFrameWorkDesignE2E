package amrutraibagi.AbstractComponentsclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import amrutraibagi.PageObjectclasses.CartPage;
import amrutraibagi.PageObjectclasses.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Switching to the window
	//Waiting methods
	//Switching to Frames
	//Alert Handling
	//Scrolling Action
	
	//WebEllement cartBtn=driver.findElement(By.cssSelector("button[routerlink*=\"cart\"]")).click();
	@FindBy(css="button[routerlink*=\"cart\"]")
	WebElement cartBtn;
	
	//WebEllement cartBtn=driver.findElement(By.cssSelector("button[routerlink*=\"myorders\"]")).click();
		@FindBy(css="button[routerlink*=\"myorders\"]")
		WebElement myorders;
	
	public void waitForLocatorElementToAppear(By findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	
	public void waitForWebElementToDisAppear(WebElement webElement) throws InterruptedException {
		Thread.sleep(2000);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOf(webElement));
		
	}
	
	public void waitForWebElementToAppear(WebElement webElement) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		
	}
	
	public CartPage gotoCartPage() {
		cartBtn.click();
		CartPage CP=new CartPage(driver);
		return CP;
	}
	
	public OrdersPage gotoOrdersPage() {
		myorders.click();
		OrdersPage OP=new OrdersPage(driver);
		return OP;
	}
	
	public void scrollDownPage(int y) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0, arguments[0]);", y);
	}
	
	public void scrollUpPage(int y) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(\\+y+\\,0)");
	}
	
	
	

}
