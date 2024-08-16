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

public class ConfirmationPage extends AbstractComponents{
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	By OrderConfirmationMsgBy=By.id("toast-container");
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	
	public void verifyOrderConfirmation() {
		waitForLocatorElementToAppear(OrderConfirmationMsgBy);
		
		
	}
	
	
	
	
}
