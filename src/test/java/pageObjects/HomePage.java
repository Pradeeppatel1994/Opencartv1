package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myaccount;
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement register;
	
	@FindBy(linkText="Login")  // add login link at step 5
	WebElement linklogin;
	
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txt_search;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btn_search;
	
	@FindBy(xpath="//span[normalize-space()='Shopping Cart']")
	WebElement shoppingcart;
	
	
	
	
	public void clickMyAccount() {
		myaccount.click();
	}
	
	public void clickRegister() {
		register.click();
	}
	
	
	public void clickLogin() {
		linklogin.click();
	}
	
	public void enterProductName(String search_text) {
		txt_search.sendKeys(search_text);
	}
	
	public void clickSearch() {
		btn_search.click();
	}

	public void clickShoppingCart() {
		shoppingcart.click();
	}
	
	
	
	
}
