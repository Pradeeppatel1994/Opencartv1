package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups= {"DataDriven"}) // dataProviderClass=DataProviders.class-->
																				// getting data provider from diffefrent
																				// class and pakage.
	public void loginData(String email, String pwd, String exp) throws InterruptedException {
		
		logger.info("**********Starting TC_002_LoginTest *********");
		
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		// Login
		LoginPage lp = new LoginPage(driver);
		lp.setEamil(email);
		lp.setPassword(pwd);
		lp.clickLogin();

		// MyAccount
		MyAccount macc = new MyAccount(driver);
		boolean target = macc.isMyAccountExists();

		/*
		 * Data -Valid --Login success --> test pass --> ,logout\ Login fail--. test
		 * failed
		 * 
		 * 
		 * Data -Invalid --Login success --> test failed--logout Login fail--. test
		 * passed
		 */
		if (exp.equalsIgnoreCase("Valid")) {
			if (target == true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("Invalid")) {
			if (target == true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("**********Finish TC_002_LoginTest *********");
	}
	
		
}
