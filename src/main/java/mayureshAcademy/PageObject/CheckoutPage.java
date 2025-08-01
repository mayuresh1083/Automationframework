package mayureshAcademy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mayureshAcademy.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementApper(By.cssSelector(".ta-results"));
		selectCountry.click();
		
	}
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}
	

}
