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

public class OrdersPage extends AbstractComponents{
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//WebElement ListOrderpageProducts=driver.findElement(By.cssSelector("tr td:nth-child(3)"))
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ListOrderpageProducts;
	
	
	
	
	public Boolean VerifyOrderDisplayed(String productName) {
		Boolean match=ListOrderpageProducts.stream().anyMatch(product->
		product.getText().equalsIgnoreCase(productName));
		return match;
		
		
	}
	
	
	
}
