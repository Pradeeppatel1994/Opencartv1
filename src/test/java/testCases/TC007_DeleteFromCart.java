package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;

public class TC007_DeleteFromCart extends BaseClass {

	@Test(groups = { "Master", "Sanity" })
	public void Verify_DeleteFromCart() {
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

			hp.clickShoppingCart();
			ShoppingCartPage scp = new ShoppingCartPage(driver);
			scp.clickonDelete();
			Assert.assertEquals(scp.checkCartMsg(), true);

		} catch (Exception e) {
			Assert.fail();
		}

	}

}
