package amrutraibagi.PageObjectclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import amrutraibagi.AbstractComponentsclasses.AbstractComponents;

public class ProductCatalog extends AbstractComponents{
	WebDriver driver;
	public ProductCatalog(WebDriver driver) {
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> Products=driver.findElements(By.cssSelector("div.col-lg-4"));
	
	//for this driver passed and initialized in "PageFactory.initElements(driver, this);"
	@FindBy(css="div.col-lg-4")
	List<WebElement> Products;
	
	//WebElement Spinner=driver.findElement(By.cssSelector("div[class*=\"la-ball-scale-multiple\"]"))
	@FindBy(css="div[class*=\"la-ball-scale-multiple\"]")
	WebElement Spinner;
	
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-lg-4")));
	By productsBy=By.cssSelector("div.col-lg-4");
	
	By AddedCartmsgBy=By.cssSelector(".toast-bottom-right");
	
	By AddToCartBy=By.cssSelector(".w-10");
	
	//List<WebElement> Products=driver.findElements(By.cssSelector("div.col-lg-4"));
	public List<WebElement> getProductsList() {
		waitForLocatorElementToAppear(productsBy);
		return Products;
	}
	
	public void getProductByName(List<String> Pnames) throws InterruptedException {
		
		for(WebElement product:Products) {
			String fetchedPname=product.findElement(By.cssSelector("b")).getText();
			if(Pnames.contains(fetchedPname)) {
				product.findElement(AddToCartBy).click();
				
				//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".toast-bottom-right")));
				waitForLocatorElementToAppear(AddedCartmsgBy);
				
				//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("div[class*=\"la-ball-scale-multiple\"]"))));
				waitForWebElementToDisAppear(Spinner);
			}
		}
		
	}
	
	
	
	
}
