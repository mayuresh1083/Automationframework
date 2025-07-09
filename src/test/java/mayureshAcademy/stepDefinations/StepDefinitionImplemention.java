package mayureshAcademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mayureshAcademy.PageObject.CartPage;
import mayureshAcademy.PageObject.CheckoutPage;
import mayureshAcademy.PageObject.ConfirmationPage;
import mayureshAcademy.PageObject.LandingPage;
import mayureshAcademy.PageObject.ProductCatalogue;
import mayureshAcademy.TestComponents.BaseTest;

public class StepDefinitionImplemention extends BaseTest{
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationMessage;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
		
	}
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String username,String password) {
		 productCatalogue = landingPage.loginAppliction(username,password);
	}
	@When("^I add product (.+) to Cart$")
	public void I_add_product_to_Cart(String productName) throws InterruptedException {
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	@When("^Checkout (.+) add submit the order$")
	public void Checkout_add_submit_the_order(String productName) {
		CartPage cartPage = productCatalogue.goToCardPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationMessage = checkoutPage.submitOrder();
	}
	@Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String string) {
		String confirmMessage = confirmationMessage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
}
