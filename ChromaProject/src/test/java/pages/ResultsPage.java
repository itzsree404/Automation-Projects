package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import core.BaseClass;

public class ResultsPage extends BaseClass{
	WebDriverWait wait;
	
	public ResultsPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "(//*[text()='Brand'])[1]")
	private WebElement brandFilter;
	
	@FindBy (xpath= "//*[text()='LG']")
	private WebElement lgBox;
	
	@FindBy (xpath= "//*[text()='Samsung']")
	private WebElement samsungBox;
	
	@FindBy (xpath= "//*[text()='Whirlpool']")
	private WebElement whirlpoolBox;
	
	@FindBy (xpath= "//div[contains(@class,'product')]//h3")
	private List<WebElement> productTitles;
	
	@FindBy (xpath= "(//*[text()='Relevancy'])[1]")
	private WebElement sortBtn;
	
	@FindBy (xpath= "//*[text()='Discount (Descending)']")
	private WebElement discountFilter;
	
	@FindBy (xpath= "//*[contains(text(),'%')]")
	private List<WebElement> discountPercentage;
	
	@FindBy (xpath="//*[@data-testid='new-price']")
	private List<WebElement> productPrice;
	
	public void filterBrands() {
		wait.until(ExpectedConditions.elementToBeClickable(brandFilter)).click();
	
		lgBox.click();
		samsungBox.click();
		whirlpoolBox.click();
		brandFilter.click();
		
	}
	
	public void verifyProductsBelongToSelectedBrands(List<String> expectedBrands) {

	    for (WebElement title : productTitles) {
	        String productName = title.getText().toLowerCase();
	        boolean matches = false;

	        for (String brand : expectedBrands) {
	            if (productName.contains(brand.toLowerCase())) {
	                matches = true;
	                break;
	            }
	        }

	        Assert.assertTrue(
	            matches,
	            "❌ Product from unexpected brand found: " + productName
	        );
	    }
	}
	
	public void sortByDiscount() {
		wait.until(ExpectedConditions.elementToBeClickable(sortBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortBtn);

		wait.until(ExpectedConditions.elementToBeClickable(discountFilter));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", discountFilter);
	}
	
	public void verifySortedByDiscount() {
		
		 List<Integer> actual = new ArrayList<>();

		    for (WebElement d : discountPercentage) {
		        String text = d.getText().replaceAll("[^0-9]", "");
		        if (!text.isEmpty()) {
		            actual.add(Integer.parseInt(text));
		        }
		    }

		    List<Integer> sorted = new ArrayList<>(actual);
		    Collections.sort(sorted, Collections.reverseOrder());

		    Assert.assertEquals(actual, sorted);
	}

	
	public List<Integer> verifyPriceCalculation() {
		
		 List<Integer> prices = new ArrayList<>();

		    int limit = Math.min(10, productPrice.size());
		    for (int i = 0; i < limit; i++) {
		    	String priceText= productPrice.get(i).getText();
		    	String cleanedPrice = priceText.replaceAll("[^0-9]", "");
		    	
		    	prices.add(Integer.parseInt(cleanedPrice));
			}
			return prices;
		}
	
	public double calculateAveragePrice(List<Integer> prices) {

	    if (prices == null || prices.isEmpty()) {
	        throw new RuntimeException("Price list is empty. Cannot calculate average.");
	    }

	    int sum = 0;
	    for (int price : prices) {
	        sum += price;
	    }

	    return (double) sum / prices.size();
	}

}
