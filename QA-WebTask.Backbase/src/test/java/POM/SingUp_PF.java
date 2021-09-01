package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class SingUp_PF {
	
	
	@FindBy(xpath = "/html/body/app-root/app-layout-header/nav/div/ul/li[3]/a")
	WebElement btn_Signup1;
	
	@FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[1]/input")
	WebElement txt_UserName;
	
	@FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input")
	WebElement txt_Email;
	
	@FindBy(xpath = "/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[3]/input")
	WebElement txt_Password;

	
	@FindBy(xpath = "//a[contains(text(),'Sign up')]")
	WebElement btn_Signup2;
	
	
	
	WebDriver driver;
	
	public SingUp_PF(WebDriver driver) {
		this.driver = driver;
		
		
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void clickOnSignup1() {
		btn_Signup1.click();
	}
	
	public void enterUsername(String username) {
		txt_UserName.clear();
		txt_UserName.sendKeys(username);
	}
	
	public void enterEmail(String email) {
		txt_Email.clear();
		txt_Email.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txt_Password.clear();
		txt_Password.sendKeys(password);
	}
	
	public void clickOnSignup2() {
		btn_Signup2.click();
	}
}


