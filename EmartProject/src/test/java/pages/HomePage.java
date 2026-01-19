package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement regLink;
	
	@FindBy(xpath = "//a[text()='Log in']")
    private WebElement loginLink;
	
	@FindBy(xpath = "//*[@id='gender-male']")
	private WebElement genderBtn;
	
	@FindBy(xpath = "//*[@id='FirstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//*[@id='LastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//*[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath = "//*[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id='ConfirmPassword']")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id='register-button']")
	private WebElement regBtn;
	
	@FindBy(xpath = "//*[@value='Log in']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//*[@value='Search store']")
	private WebElement search;
	
	@FindBy(xpath = "(//*[@value='Search'])[1]")
	private WebElement searchBtn;
	
	@FindBy(xpath = "(//*[@value='Search'])[2]")
	private WebElement AdvSearchBtn;
	
	@FindBy(xpath = "//*[@id='As']")
	private WebElement advanceSearch;
	
	@FindBy(xpath = "//*[@id='Pf']")
	private WebElement priceFrom;
	
	@FindBy(xpath = "//*[@id='Pt']")
	private WebElement priceTo;
	
    public void clickRegisterLink() {
        regLink.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }
    
    public void loginUser(String mail, String pwd) {
    	email.sendKeys(mail);
    	password.sendKeys(pwd);
    	loginBtn.click();
    }
    
    public void searchStore(String product) {
    	search.sendKeys(product);
    	searchBtn.click();	
    }
    
    public void filter(String from, String to) {
    	advanceSearch.click();
    	priceFrom.sendKeys(from);
    	priceTo.sendKeys(to);
    	AdvSearchBtn.click();
    }
    
    
    public void registerUser(String fname, String lname, String mail, String pwd) {

	genderBtn.click();
	firstName.sendKeys(fname);
	lastName.sendKeys(lname);
	email.sendKeys(mail);
	password.sendKeys(pwd);
	confirmPassword.sendKeys(pwd);
	regBtn.click();
	
	}
    
   

}
