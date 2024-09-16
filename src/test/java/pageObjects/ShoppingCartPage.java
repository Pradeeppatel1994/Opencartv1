package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}

	//@FindBy(xpath = "//div[@id='cart']")
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement btncart;

	@FindBy(xpath = "//strong[normalize-space()='View Cart']")
	WebElement lnkviewcart;

	@FindBy(xpath = "//strong[normalize-space()='Checkout']")
	WebElement lnkCheckOut;

	@FindBy(xpath = "//table[@class='table table-bordered']//tr[4]//td[1]")
	WebElement lblTotalPrice;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement btndelete;
	
	@FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
	WebElement shoppingcartmsg;
	
	
	
	

	public void clickOnCart() {
		btncart.click();
	}

	public void clickOnViewCart() {
		lnkviewcart.click();
	}

	public void clickOnCheckout() {
		lnkCheckOut.click();
	}

	public String getTotal() {
		return lblTotalPrice.getText();
	}
	
	public void clickonDelete() {
		btndelete.click();
	}


	public boolean checkCartMsg() {
		try {
		 return shoppingcartmsg .isDisplayed();
		}
		catch(Exception e){
			return false;
		}
	}
	
	
	
	
	
	
	
}
