package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage{

	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement txtmyaccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")  //added at step 6
	WebElement linklogout;
	
	
	public boolean isMyAccountExists() {
		
		try {
			return (txtmyaccount.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
		
		
	}
	
	
	public void clickLogout() {       //added at step 6
		linklogout.click();
	}
	
	
	

}
