package amrutraibagi.Testclasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import amrutraibagi.PageObjectclasses.CartPage;
import amrutraibagi.PageObjectclasses.CheckOutPage;
import amrutraibagi.PageObjectclasses.ConfirmationPage;
import amrutraibagi.PageObjectclasses.ProductCatalog;
import amrutraibagi.TestComponents.BaseTests;


public class ErrorValidations extends BaseTests {
		@Test(groups= {"ErrorHandling"})
		public void loginErrorValidation() throws IOException, InterruptedException {
			LP.loginApplication("amrutraibagi2018@gmail.c", "Pappa@143");
			String ErrorMsg=LP.getErrorMsg();
			Assert.assertEquals(ErrorMsg, "Incorrect email or password.");
			
		}
		
		@Test(groups={"ErrorHandling"})
		public void SubmitZARAProduct() throws IOException, InterruptedException {
			String[] itemsNeeded = { "ZARA COAT 3", "IPHONE 13 PRO" };
			List<String> Pnames = Arrays.asList(itemsNeeded);
			
			ProductCatalog PCL = LP.loginApplication("amrutraibagi872@gmail.com", "Mummy@143");

			PCL.getProductsList();
			PCL.getProductByName(Pnames);
			CartPage CP = PCL.gotoCartPage();
			CheckOutPage COP = CP.BuyCartproduct("ZARA COAT 3");

			COP.selectCountry("india");
			ConfirmationPage confirmatiopage = COP.placeOrder();

			Thread.sleep(2000);
			// Verify success message after Product submission
			confirmatiopage.verifyOrderConfirmation();
			Assert.assertEquals(driver.findElement(By.id("toast-container")).getText(), "Order Placed Successfully");
			
		}

	

}
