package amrutraibagi.PageObjectclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amrutraibagi.AbstractComponentsclasses.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> CartProducts=driver.findElements(By.cssSelector("li.items"));
	
	@FindBy(css="li.items")
	List<WebElement> CartProducts;
	
	By ListOfCartProducts=By.cssSelector("li.items");
	

	//Finding List of products in Cart page
	public List<WebElement> getListofCartProducts() {
		waitForLocatorElementToAppear(ListOfCartProducts);
		return CartProducts;
		
	}
	
	//Finding product in Cart page
	public WebElement verifyCartProductByName(String CartProducName) {
		WebElement cartProduct =getListofCartProducts().stream().filter(Cproduct->
		Cproduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(CartProducName)).findFirst().orElse(null);
		return cartProduct;
	}
	
	//Click on Buy Now
	public CheckOutPage BuyCartproduct(String CartProducName) {
		WebElement cartProduct=verifyCartProductByName(CartProducName);
		cartProduct.findElement(By.cssSelector(".cartSection button:first-of-type")).click();
		CheckOutPage COP=new CheckOutPage(driver);
		return COP;
	}
	
	
}
