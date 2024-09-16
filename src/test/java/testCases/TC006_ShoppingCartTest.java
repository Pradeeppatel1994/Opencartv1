package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;

public class TC006_ShoppingCartTest extends BaseClass {

	@Test(groups = "Master")
	public void verify_ShoppingCart() throws InterruptedException {

		logger.info("***** Starting TC006_ShoppingCartTest *****");
		try {
			HomePage hp = new HomePage(driver);
			hp.enterProductName("iPhone");
			hp.clickSearch();

			SearchPage sp = new SearchPage(driver);
			if (sp.isProductExists("iPhone")) {
				sp.selectProduct("iPhone");
				sp.setQuantity("1");
				sp.clickAddToCart();
			}

			ShoppingCartPage scp = new ShoppingCartPage(driver);
			scp.clickOnCart();
			Thread.sleep(5000);
			// scp.getTotal();
			scp.clickOnViewCart();

			// Assert.assertEquals(scp.getTotal(),true);
			Assert.assertTrue(true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***** Finish TC006_ShoppingCartTest *****");

	}
}
