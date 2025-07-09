package mayureshAcademy.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mayureshAcademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	driver.findElement(By.id("userEmail")).sendKeys("mayuresh@gmail.com");
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	// driver.findElement(By.id("userPassword")).sendKeys("Monster@12");
	@FindBy(id="userPassword")
	WebElement passwordEle;
	//driver.findElement(By.id("login")).click();
	@FindBy(id="login")
	WebElement sumbit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginAppliction(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		sumbit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return  productCatalogue;
	}
	public String getErrorMessage() {
		waitForWebElementApper(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
