package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login() {
		
		logger.info("**********Starting TC_002_LoginTest *********");
		try {
		
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp = new LoginPage(driver);
		lp.setEamil(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		
		//MyAccount
		MyAccount macc= new MyAccount(driver);
		boolean target=macc.isMyAccountExists();
		Assert.assertEquals(target, true,"Login failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**********Finish TC_002_LoginTest *********");

	}
	
	

}
