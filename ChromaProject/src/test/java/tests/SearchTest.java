package tests;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.BaseClass;
import core.ExcelData;
import core.RetryAnalyzer;
import core.ScreenshotData;
import core.TestListener;
import pages.HomePage;
import pages.ResultsPage;

@Listeners(TestListener.class)
public class SearchTest extends BaseClass {
	
	HomePage home;
	ResultsPage res;
	
	@BeforeMethod
	public void setUp() {
		loadConfig();
		launchBrowser();
		home = new HomePage(driver);
	}
	
	@Test(priority = 0, description = "Validating Search Functionality", enabled = true, retryAnalyzer = RetryAnalyzer.class)
	public void verifySearch() throws Exception {		
		String searchtext = ExcelData.readData(1, 1);
		System.out.println(searchtext);
		home.searchStore(searchtext);
		
		res = new ResultsPage(driver);
		res.filterBrands();
		
		
		List<String> selectedBrands = Arrays.asList("LG", "Samsung", "Whirlpool");

	    res.verifyProductsBelongToSelectedBrands(selectedBrands);
	    
	    ScreenshotData.captureScreenshot("Filter_by_Brands");
	}
	
	

	@AfterMethod
	public void close() {
		closeBrowser();
	}
}