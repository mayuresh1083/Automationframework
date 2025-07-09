package mayureshAcademy.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mayureshAcademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products =  driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	
    By productBy = By.cssSelector(".mb-3");
   // driver.findElement(By.cssSelector(".ng-animating"))
    
    
    
//	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
   By addToCart = By.cssSelector(".card-body button:last-of-type");
   By toastMessage = By.cssSelector("#toast-container");
   
   
	public List<WebElement> getProductList()
	{
		waitForElementApper(productBy);
		return products;
	}
	
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		return prod;

	}
	public void addProductToCart(String productName) throws InterruptedException
	{
	   WebElement prod = getProductByName(productName);
	  
	   prod.findElement(addToCart).click();
	   waitForElementApper(toastMessage);
	   waitForElementToDisapper(spinner);
	}
}
