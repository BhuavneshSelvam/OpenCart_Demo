package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegisterationTest extends BaseClass {
	
	@Test
	public void verify_account_registration()
	{
		
		logger.info("******** Starting TC001_AccountRegistrationTest *******");
		
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		
		logger.info("***Clicked on MyAccount Link***");
		
		
		hp.clickRegister();
		
		logger.info("***Clicked on Register Link***");
		
		
		logger.info("***Providing Customer Details***");
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		//Need to generate random datas and not a hardcoded one.....
		
		regPage.setFirstName(randomString());
		regPage.setLastName(randomString());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelephone(randomNumber());
		
		String password = randomAlphanumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		
		//validation part
		
		logger.info("*** Validating Expected Message ***");
		
		String confmsg = regPage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		} catch (Exception e)
		{
			logger.error("Test Failed....");
			Assert.fail();
		}
		
		logger.info("***Finished Test ***");
	}

}
