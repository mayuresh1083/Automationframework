package mayureshAcademy.texts;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mayureshAcademy.PageObject.CartPage;
import mayureshAcademy.PageObject.CheckoutPage;
import mayureshAcademy.PageObject.ConfirmationPage;
import mayureshAcademy.PageObject.LandingPage;
import mayureshAcademy.PageObject.ProductCatalogue;
import mayureshAcademy.TestComponents.BaseTest;

public class StandAloneTest2 extends BaseTest {

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap <String,String> input) throws IOException, InterruptedException
	{
//		String productName = "ADIDAS ORIGINAL";
		ProductCatalogue productCatalogue = landingPage.loginAppliction(input.get("email"), input.get("password"));
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCardPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationMessage = checkoutPage.submitOrder();
		String confirmMessage = confirmationMessage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	

	}
	
	@DataProvider
	public Object[][] getData() {
		HashMap <String,String> map = new HashMap <String,String>();
		map.put("email", "mayuresh@gmail.com");
		map.put("password", "Monster@12");
		map.put("product", "ADIDAS ORIGINAL");
		HashMap <String,String> map1 = new HashMap <String,String>();
		map1.put("email", "mayubabu@gmail.com");
		map1.put("password", "Mahesh@12");
		map1.put("product", "IPHONE 13 PRO");
		return new Object[][] {{map},{map1}};
	}
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"mayuresh@gmail.com","Monster@12","ADIDAS ORIGINAL"},{"mayubabu@gmail.com","Mahesh@12","IPHONE 13 PRO"}};
//	}

}
