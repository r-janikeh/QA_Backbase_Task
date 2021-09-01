package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.FollowUsers_PF;
import POM.Login_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FollowUsers {
	
	String BaseURL = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com/";
	WebDriver driver = null;
	Login_PF Login;
	FollowUsers_PF FollowUsers;


	@Given("user is already logged in in the Page")
	public void Login()
	{

		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is : "+projectPath);

		//setProperty for Windows chrome
		System.setProperty("chromedriver_win", projectPath+"/Drivers/chromedriver/chromedriver_win.exe");

		//setProperty for Windows Firefox
		//System.setProperty("geckodriver-win64", projectPath+"/Drivers/geckodriver/geckodriver-win64.exe");

		//setProperty for MAC
		//System.setProperty("chromedriver_mac64", projectPath+"/src/test/resources/Drivers/chromedriver_mac64");

		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Login.clickOnSignup1();		
		Login.enterEmail("r.janikeh1@mailinator.com");	
		Login.enterPassword("123456");
		Login.clickOnLogin();
	}

	
	@When("Click on tags from right side in the home page")
	public void click_on_tag() {
		FollowUsers.clickOnTag();
		
	}

	
		@And("Click on name of the users from the article")
		public void click_on_name_of_the_users_from_the_article() {
			FollowUsers.clickOnUserNameArticle();
		}
		
		@And("Click on Fllow User button in user s detail page")
		public void click_on_fllow_user_button_in_users_detail_page() {
			FollowUsers.clickOnFllowUser();
		}
		
		 @Then("The text of button should chnage to unfollow user")
		 public void The_text_of_button_should_chnage_to_unfollow_user() {
			 FollowUsers.clickOnUnfollowUser();
			 
		String actualTitle = driver.findElement(By.xpath("/html/body/app-root/app-profile-page/div/div[1]/div/div/div/app-follow-button/button")).getText();
        System.out.println("Follow status is"+actualTitle); 
}
	
	
	@And("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();

	}
}
