package mayureshAcademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mayureshAcademy.PageObject.CartPage;

public class AbstractComponents {
	
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cardHeader;

	public void waitForElementApper(By FindBy) {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));  // Implecet Wait 
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	public void waitForWebElementApper(WebElement FindBy) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));  // Implecet Wait 
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
	
	public CartPage goToCardPage() {
	  cardHeader.click();	
	  CartPage cartPage = new CartPage(driver);
	  return cartPage;
	}
	
	
	public void waitForElementToDisapper(WebElement ele) throws InterruptedException {
		Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
