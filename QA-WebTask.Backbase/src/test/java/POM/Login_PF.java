package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login_PF {
	

	@FindBy(xpath = "/html/body/app-root/app-layout-header/nav/div/ul/li[2]/a")
	WebElement btn_Signin1;
	
	@FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input")
	WebElement txt_Email;
	
	@FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input")
	WebElement txt_Password;

	
	@FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/button")
	WebElement btn_Login;
	
	
	WebDriver driver;
	
	public Login_PF(WebDriver driver) {
		this.driver = driver;
		
		
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void clickOnSignup1() {
		btn_Signin1.click();
	}
	
	public void enterEmail(String email) {
		txt_Email.clear();
		txt_Email.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txt_Password.clear();
		txt_Password.sendKeys(password);
	}
	
	public void clickOnLogin() {
		btn_Login.click();
	}

}
