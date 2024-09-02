package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BasePage{

	public RegisterAccount(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtPasswordConfirm;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirm;
	
	
	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}

	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	
	public void setConfrimPassword(String cnfpwd) {
		txtPasswordConfirm.sendKeys(cnfpwd);
	}
	
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	
	public void clickContinue() {
		//sol1
		btnContinue.click();
		
		//sol 2
		//btnContinue.submit();
		
		//sol3
		//Actions action =new Actions(driver);
		//action.moveToElement(btnContinue).click().perform();
		
		
		//sol4
		//JavascriptExecutor js= (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click()", btnContinue);
		
		//sol5
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue));	
	}
	
	public String getConfirmationmsg() {
			try {return (msgConfirm.getText());
			} catch(Exception e) {
				return(e.getMessage());
			}
			
			}
		
	}


		
	

