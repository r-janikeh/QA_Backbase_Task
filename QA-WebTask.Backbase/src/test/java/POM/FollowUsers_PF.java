package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class FollowUsers_PF {
	

	@FindBy(xpath = "/html/body/app-root/app-home-page/div/div/div/div[2]/div/div[1]/a[1]")
	WebElement btn_Tag;
	
	@FindBy(xpath = "/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[2]/a")
	WebElement btn_UserNameArticle;
	
	@FindBy(xpath = "/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/app-article-preview[1]/div/app-article-meta/div/a/img")
	WebElement btn_FllowUser;

	
	@FindBy(xpath = "/html/body/app-root/app-profile-page/div/div[2]/div/div/app-profile-articles/app-article-list/app-article-preview/div/app-article-meta/div/app-favorite-button/button")
	WebElement btn_UnfollowUser;
	
	
	WebDriver driver;
	
	public FollowUsers_PF(WebDriver driver) {
		this.driver = driver;
		
		
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void clickOnTag() {
		btn_Tag.click();
	}
	
	public void clickOnUserNameArticle() {
		btn_UserNameArticle.click();
	}
	
	public void clickOnFllowUser() {
		btn_FllowUser.click();
	}
	
	public void clickOnUnfollowUser() {
		btn_UnfollowUser.click();
	}

}

