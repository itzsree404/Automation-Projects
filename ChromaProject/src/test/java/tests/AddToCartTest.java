package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.BaseClass;
import core.ExcelData;
import core.RetryAnalyzer;
import core.TestListener;
import pages.CartPage;
import pages.HomePage;

@Listeners(TestListener.class)

public class AddToCartTest extends BaseClass {
	HomePage home;
	CartPage cart;
	
	@BeforeMethod
	public void setUp() {
		loadConfig();
		launchBrowser();
		home = new HomePage(driver);
		cart = new CartPage(driver);
		
	}
	
	@Test(priority = 3, description = "Validating Add to Cart Functionality", enabled = true, retryAnalyzer = RetryAnalyzer.class)
	public void verifyAddToCart() throws Exception {
		
		String searchtext = ExcelData.readData(5, 1);
		home.searchStore(searchtext);
		
		
		cart.addProductAddedToCart();
		
		cart.verifyProductAddedToCart();
		
	}
	

	@AfterMethod
	public void close() {
		closeBrowser();
	}
}
