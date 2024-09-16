package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@id='content']//div//img")
	List<WebElement> searchproducts;
	
	@FindBy(xpath="//input[@id='input-quantity']")
	WebElement txt_qunatity;
	
	@FindBy(xpath="//button[@id='button-cart']")
	WebElement btn_addtocart;
	
	@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
	WebElement cnfMsg;
	
	
	

	public boolean isProductExists(String productName) {

		boolean flag = false;

		for (WebElement product : searchproducts) {
			if (product.getAttribute("title").equals(productName)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void selectProduct(String productName) {
		for (WebElement product : searchproducts) {
			if (product.getAttribute("title").equals(productName)) {
				product.click();
			}
		}
	}
	
	
	public void setQuantity(String qty) {
		txt_qunatity.sendKeys(qty);
	}
	
	
	public void clickAddToCart() {
		btn_addtocart.click();
	}
	
	
	public boolean checkcngMsg() {
		try {
		return cnfMsg.isDisplayed();
		}catch(Exception e) {
			return false;
		}
		
	}
	
	
	

}
