package mayureshAcademy.texts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import mayureshAcademy.PageObject.ProductCatalogue;
import mayureshAcademy.TestComponents.BaseTest;
import mayureshAcademy.TestComponents.Retry;



public class ErrorValidation extends BaseTest{

	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidation () throws IOException, InterruptedException
	{
		ProductCatalogue productCatalogue = landingPage.loginAppliction("mayures@gmail.com", "Monster@12");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	@Test
	public void productErrorValidation () throws IOException, InterruptedException
	{
		ProductCatalogue productCatalogue = landingPage.loginAppliction("mayures@gmail.com", "Monster@12");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}
	
}
