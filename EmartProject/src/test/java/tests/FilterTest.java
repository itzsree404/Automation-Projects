package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.SearchPage;
import utilities.ExcelData;
import utilities.ListenerImplementation;
import utilities.RetryAnalyzerImplementation;

@Listeners(ListenerImplementation.class)
public class FilterTest extends BaseClass {
	
	HomePage home;
	
	
	@BeforeClass
	public void setUp() {
		loadConfig();
		launchbrowser();
		home = new HomePage(driver);
	}
	
	@Test(priority = 1, description = "Validating filter search", enabled = true, retryAnalyzer = RetryAnalyzerImplementation.class)
	public void verifyFilterSearch() throws Exception {
		
		SearchPage searchPage  = new SearchPage(driver);
		home.clickLoginLink();
		
		String email= ExcelData.readData(2, 2);
		String password= ExcelData.readData(2, 3);
		
		home.loginUser(email, password);
		
		home.searchStore("computer");
		home.filter("1000", "2000");
		
		searchPage.scrollToAddToCartBtn();
		
		List<WebElement> productNames = searchPage.getAllProductNames();
		List<WebElement> productPrices = searchPage.getAllProductPrices();	
		
		for (int i = 0; i < productNames.size(); i++) {
		    assert productNames.get(i).getText().toLowerCase().contains("computer");
		    
		double price = Double.parseDouble(productPrices.get(i).getText().replace(".00", ""));
		    Assert.assertTrue(price >= 1000 && price <= 2000, "Price out of range");
		}

		Thread.sleep(2000);
			
		}
	
	@AfterClass
	public void close() {
		closebrowser();
	}
}
