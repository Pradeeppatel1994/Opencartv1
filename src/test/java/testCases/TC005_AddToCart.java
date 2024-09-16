package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class TC005_AddToCart extends BaseClass {

	@Test(groups = { "Master", "Sanity" })
	public void verify_AddToCart() {

		logger.info("***** Starting TC005_AddToCartTest *****");

		try {
			HomePage hp = new HomePage(driver);
			hp.enterProductName("iPhone");
			hp.clickSearch();

			SearchPage sp = new SearchPage(driver);

			if (sp.isProductExists("iPhone")) {

				sp.selectProduct("iPhone");
				Thread.sleep(3000);
				sp.setQuantity("3");
				sp.clickAddToCart();
			}
			Assert.assertEquals(sp.checkcngMsg(), true);
		}

		catch (Exception e) {
			Assert.fail();
		}

		logger.info("***** Finish TC005_AddToCartTest *****");

	}

}
