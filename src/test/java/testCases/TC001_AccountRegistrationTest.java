package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegisterAccount;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test (groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***** Clicked on MyAccount link *****");
		
		hp.clickRegister();
		logger.info("***** Clicked on Register link *****");
		
		RegisterAccount ra= new RegisterAccount(driver);
		
		logger.info("***** Providing Customer Details *****");
		ra.setFirstname(randomString().toUpperCase());
		ra.setLastname(randomString().toUpperCase());    
		ra.setEmail(randomString()+"@gmail.com");     //randomly generated the email 
		ra.setTelephone(randomNumber());
		  
		String password=randomAlphaNumeric();
		
		ra.setPassword(password);
		ra.setConfrimPassword(password);
		ra.setPrivacyPolicy();
		ra.clickContinue();
		
		logger.info("***** Validatin Expected Message *****");
		String cnfmsg=ra.getConfirmationmsg();
		if(cnfmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			
			Assert.fail();
			
		}
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
	}
	
	

}
