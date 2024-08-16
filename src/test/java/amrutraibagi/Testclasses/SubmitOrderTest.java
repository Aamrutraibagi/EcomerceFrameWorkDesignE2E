package amrutraibagi.Testclasses;

import java.io.IOException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amrutraibagi.Data.DataReader;
import amrutraibagi.PageObjectclasses.CartPage;
import amrutraibagi.PageObjectclasses.CheckOutPage;
import amrutraibagi.PageObjectclasses.ConfirmationPage;
import amrutraibagi.PageObjectclasses.OrdersPage;
import amrutraibagi.PageObjectclasses.ProductCatalog;
import amrutraibagi.TestComponents.BaseTests;
import amrutraibagi.TestComponents.Retry;


public class SubmitOrderTest extends BaseTests {
	
		String ProductName="IPHONE 13 PRO";
		@Test(dataProvider= "getData",groups= {"purchase"})
		public void SubmitIphoneProduct(HashMap<String,String> input) throws IOException, InterruptedException {
			String[] itemsNeeded = { "ZARA COAT 3", "IPHONE 13 PRO" };
			List<String> Pnames = Arrays.asList(itemsNeeded);
			ProductCatalog PCL = LP.loginApplication(input.get("email"), input.get("Password"));

			PCL.getProductsList();
			PCL.getProductByName(Pnames);
			CartPage CP = PCL.gotoCartPage();
			CheckOutPage COP = CP.BuyCartproduct(input.get("productname"));

			COP.selectCountry("india");
			ConfirmationPage confirmatiopage = COP.placeOrder();

			Thread.sleep(2000);
			// Verify success message after Product submission
			confirmatiopage.verifyOrderConfirmation();
			Assert.assertEquals(driver.findElement(By.id("toast-container")).getText(), "Order Placed Successfully");
			
		}
		
		//To Verify IPhone is displaying in Orders page
		@Test(dependsOnMethods="SubmitIphoneProduct",groups= {"purchase"},retryAnalyzer=Retry.class)
		public void verifyOrdersPage() {
			ProductCatalog PCL = LP.loginApplication("amrutraibagi2018@gmail.com", "Pappa@143");
			OrdersPage OP=PCL.gotoOrdersPage();
			Boolean match=OP.VerifyOrderDisplayed("");
			Assert.assertTrue(match);
		}
		
		@DataProvider
		public Object[][] getData() throws IOException {
			//return new Object[][] {{"amrutraibagi2018@gmail.com", "Pappa@143","IPHONE 13 PRO"},{"amrutraibagi872@gmail.com", "Mummy@143","ZARA COAT 3"}};
			//for above type we pass like this in method(String Email,String Password, String productname)
			
			
			/*
			 * Map<Object,Object> map1=new HashMap<Object,Object>(); map1.put("email",
			 * "amrutraibagi2018@gmail.com"); map1.put("Password", "Pappa@143");
			 * map1.put("productname", "IPHONE 13 PRO");
			 * 
			 * Map<Object,Object> map2=new HashMap<Object,Object>(); map2.put("email",
			 * "amrutraibagi872@gmail.com"); map2.put("Password", "Mummy@143");
			 * map2.put("productname", "ZARA COAT 3");
			 */
			
			DataReader DP=new DataReader();
			List<HashMap<String,String>> data=DP.getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//amrutraibagi//Data//PurchaseOrder.json");
			
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
		}

	

}
