package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void scrollToAddToCartBtn() {
        WebElement addToCartBtn = driver.findElement(
            By.xpath("(//input[@value='Add to cart'])[1]")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
    }

    private By productNames = By.xpath("//h2[@class='product-title']/a");
    private By productPrices = By.xpath("//span[@class='price actual-price']");

    public List<WebElement> getAllProductNames() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getAllProductPrices() {
        return driver.findElements(productPrices);
    }
}
