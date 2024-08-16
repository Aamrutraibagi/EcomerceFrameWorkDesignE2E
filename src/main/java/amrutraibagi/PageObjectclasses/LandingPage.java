package amrutraibagi.PageObjectclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amrutraibagi.AbstractComponentsclasses.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		//Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("#userEmail")).sendKeys("amrutraibagi2018@gmail.com");
	//driver.findElement(By.cssSelector("#userPassword")).sendKeys("Pappa@143");
	//driver.findElement(By.cssSelector("#login")).click();
	
	//for this driver passed and initialized in "PageFactory.initElements(driver, this);"
	@FindBy(css="#userEmail")
	WebElement userEmail;
	
	@FindBy(css="#userPassword")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement submit;
	
	//WebElement errorMessage=driver.findElement(By.xpath("//div[text()=\" Incorrect email or password. \"]"))
	@FindBy(xpath="//div[text()=\" Incorrect email or password. \"]")
	WebElement errorMessage;
	
	public ProductCatalog loginApplication(String Email, String Password) {
		userEmail.sendKeys(Email);
		password.sendKeys(Password);
		submit.click();
		ProductCatalog PCL=new ProductCatalog(driver);
		return PCL;
		
	}
	
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	public String getErrorMsg() {
		waitForWebElementToAppear(errorMessage);
		String ErrorMgs=errorMessage.getText();
		return ErrorMgs;
		 
	}
	
	
}
