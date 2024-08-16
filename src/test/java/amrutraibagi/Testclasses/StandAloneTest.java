package amrutraibagi.Testclasses;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		String[] itemsNeeded= {"ZARA COAT 3","IPHONE 13 PRO"};
		List<String> Pnames=Arrays.asList(itemsNeeded);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("amrutraibagi2018@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Pappa@143");
		driver.findElement(By.cssSelector("#login")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.col-lg-4")));
		List<WebElement> Products=driver.findElements(By.cssSelector("div.col-lg-4"));
		
//		WebElement Prod=Products.stream().filter(product->
//		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
//		
//		Prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
		for(WebElement product:Products) {
			String fetchedPname=product.findElement(By.cssSelector("b")).getText();
			if(Pnames.contains(fetchedPname)) {
				product.findElement(By.cssSelector(".w-10")).click();
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".toast-bottom-right")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class*=\"la-ball-scale-multiple\"]")));
			}
		}
		
		
		
		driver.findElement(By.cssSelector("button[routerlink*=\"cart\"]")).click();
		
		//Finding product in Cart page
		List<WebElement> CartProducts=driver.findElements(By.cssSelector("li.items"));
		
		WebElement cartProduct =CartProducts.stream().filter(Cproduct->
		Cproduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase("IPHONE 13 PRO")).findFirst().orElse(null);
		//Click on Buy Now
		cartProduct.findElement(By.cssSelector(".cartSection button:first-of-type")).click();
		
		//Checkout page
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder=\"Select Country\"]")),"india").build().perform();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("(//span[@class=\"ng-star-inserted\"])[2]")).click();
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		
		//Verify success message after Product submission
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		Assert.assertEquals(driver.findElement(By.id("toast-container")).getText(), "Order Placed Successfully");
		driver.close();
		
		
		
	}
	

}
