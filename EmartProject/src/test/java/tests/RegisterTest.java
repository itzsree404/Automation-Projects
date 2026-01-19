package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import utilities.ExcelData;
import utilities.ListenerImplementation;
import utilities.RetryAnalyzerImplementation;

@Listeners(ListenerImplementation.class)
public class RegisterTest extends BaseClass{
	
	HomePage home;
	
	@BeforeClass
	public void setUp() {
		loadConfig();
		launchbrowser();
		home = new HomePage(driver);
	}
	
	@Test(priority = 0, description = "Validating registration", enabled =true, retryAnalyzer = RetryAnalyzerImplementation.class)
	public void verifyUserRegistration() {
		
		home.clickRegisterLink();
		
		Assert.assertTrue(getCurrentUrl().contains("register"), "Register page URL is incorrect");
		
		String firstName= ExcelData.readData(1, 0);
		String lastName= ExcelData.readData(1, 1);
		String email= ExcelData.readData(1, 2);
		String password= ExcelData.readData(1, 3);
		
		home.registerUser(firstName, lastName, email, password);
		
		Assert.assertTrue(getTitle().contains("Register"), "Register page title mismatch");

		
	}
	
	@AfterClass
	public void close() {
		closebrowser();
	}
}
