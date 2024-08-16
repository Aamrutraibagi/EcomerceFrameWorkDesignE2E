package amrutraibagi.CucumberStepDefinationClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import amrutraibagi.PageObjectclasses.CartPage;
import amrutraibagi.PageObjectclasses.CheckOutPage;
import amrutraibagi.PageObjectclasses.ConfirmationPage;
import amrutraibagi.PageObjectclasses.LandingPage;
import amrutraibagi.PageObjectclasses.ProductCatalog;
import amrutraibagi.TestComponents.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepDefination extends BaseTests{
		public LandingPage LP;
		public ProductCatalog PCL;
		public CartPage CP;
		public CheckOutPage COP;
		
		@Given("User landed to login page")
		public void landingPage() throws IOException {
			LP=launchApplication();
			
		}
		
		//(.+)-> Regular Expression we can pass value from feature file
		//{String} if we pass like this also, we can pass value from feature file
		@Given("^Login to application with username (.+) and pasword (.+)$")
		public void logintoApplication(String username, String password) throws IOException {
			PCL=LP.loginApplication(username, password);
			
		}
		
		@When("^User add following products to cart:$")
		public void addProductToCart(List<String> Productname) throws IOException, InterruptedException {
			PCL.getProductByName(Productname);
			
		}
		
		@And("^Checkout product (.+) and submit the order$")
		public void buyProductfromCart(String Productname) throws IOException {
			CP = PCL.gotoCartPage();
			COP = CP.BuyCartproduct(Productname);
			
		}
		
		@Then("User verifies the success message {string} is displayed")
		public void verifyConfirmationMsg(String ConfirmationMsg) throws IOException {
			COP.selectCountry("india");
			ConfirmationPage confirmatiopage = COP.placeOrder();
			confirmatiopage.verifyOrderConfirmation();
			Assert.assertEquals(driver.findElement(By.id("toast-container")).getText(), ConfirmationMsg);
			driver.close();
			
		}
		
		@Then("User verifies the Error message {string} is displayed")
		public void verifyLoginPageErrorMsg(String ConfirmationMsg) throws IOException {
			String ErrorMsg=LP.getErrorMsg();
			Assert.assertEquals(ErrorMsg, "Incorrect email or password.");
			driver.close();
			
		}

}
