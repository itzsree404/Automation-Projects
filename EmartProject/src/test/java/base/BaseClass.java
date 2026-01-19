package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public void loadConfig() {
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties");
			
			prop.load(fis);
		
		} catch (IOException e) {
			e.printStackTrace();
			}
		}
		
		public void launchbrowser() {
		String browsername = prop.getProperty("browser");
	
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
		    driver = new EdgeDriver();
		} else {
			throw new RuntimeException();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		}
				
		public String getCurrentUrl() {
			return driver.getCurrentUrl();
		}
		
		public String getTitle() {
			return driver.getTitle();
		}
		
		public void sendText(WebElement element, String text) {
			element.sendKeys(text);
		}
		public void clickOnAElement(WebElement element) {
			element.click();
		}
		
		public void waitUntilElementIsVisible(WebElement element, int time) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
	
		public void closebrowser() {
	        driver.close();
	    }
		
		
}
