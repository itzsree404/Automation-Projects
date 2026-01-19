package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BaseClass;


public class HomePage extends BaseClass {
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(id =  "searchV2")
	private WebElement search;

	@FindBy(xpath = "//div[contains(@class,'search-results')]")
	private WebElement resultsSection;
	
	@FindBy(xpath = "//h1[@class='cat-title']")
	private WebElement searchResultText;
	
	public void searchStore(String text) {
		waitUntilElementIsClickable(search, 10);
		//clickOnElement(search);
		clearText(search);;
		sendText(search, text);
		sendText(search, Keys.ENTER);
		waitUntilElementIsVisible(searchResultText, 10);
	}

}
