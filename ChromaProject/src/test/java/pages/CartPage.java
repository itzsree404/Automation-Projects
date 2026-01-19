package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import core.BaseClass;

public class CartPage extends BaseClass{
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "(//a[contains(normalize-space(),'Pixel')])[1]")
	private WebElement phoneCard;	
	
	@FindBy (xpath= "///button[contains(text(),'Add to Cart')]")
	private WebElement addToCart;
	
	@FindBy (xpath= "//*[@class='cart-s-icon']")
	private WebElement cartIcon;
	
	@FindBy (xpath= "//*[text()='Proceed to Cart']")
	private WebElement proceedToCart;
	
	@FindBy (xpath= "//a[contains(text(), 'Pixel')]")
	private WebElement cartProductName;	
	
	public void addProductAddedToCart() {
		
		wait.until(ExpectedConditions.elementToBeClickable(phoneCard)).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
		
		wait.until(ExpectedConditions.elementToBeClickable(proceedToCart)).click();
		
		
	}
	public void verifyProductAddedToCart() {
		
		wait.until(ExpectedConditions.visibilityOf(cartProductName));
		
		 String productName = cartProductName.getText();

		    Assert.assertTrue(productName.contains("Pixel"),
		            "Expected Pixel product not found in cart"); 
		
	}
}
