package tests;

import java.util.List;

import org.testng.Reporter;
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

public class SortTest extends BaseClass{
	
	HomePage home;
	ResultsPage res;
	
	
	@BeforeMethod
	public void setUp() {
		loadConfig();
		launchBrowser();
		home = new HomePage(driver);
		
		
	}
	
	@Test(priority = 2, description = "Validating Sort Functionality", enabled = true, retryAnalyzer = RetryAnalyzer.class)
	public void verifySort() throws Exception {
		String searchtext = ExcelData.readData(3, 1);
		System.out.println(searchtext);
		home.searchStore(searchtext);
		
		res = new ResultsPage(driver);
		res.sortByDiscount();
		Thread.sleep(1500);
		
		res.verifySortedByDiscount();
		
		List<Integer> top10Price= res.verifyPriceCalculation();
		double averagePrice= res.calculateAveragePrice(top10Price);
		System.out.println("Average price of top 10 prodcuts: Rs." +String.format("%.2f", averagePrice));
		
		Reporter.log("Average price of top 10 prodcuts: Rs." +String.format("%.2f", averagePrice),true);
		
		ScreenshotData.captureScreenshot("Average_Price_Calculated");
	}
	
	@AfterMethod
	public void close() {
		closeBrowser();
	}
}
