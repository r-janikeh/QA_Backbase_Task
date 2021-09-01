package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.Login_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	
	String BaseURL = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com/";
	WebDriver driver;
	Login_PF Login;
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
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
	}
	
	@When("User opens URL")
	public void click() {
		Login.clickOnSignup1();	
	}
	
	@And("^User enters Email as (.*) and Password as <password> (.*)$")
	public void user_enters_email_and_password_as(String email, String password) {
		
		Login.enterEmail(email);
		
		Login.enterPassword(password);
	}
	
	
	@And("Click on Login")
	public void click_on_signin_button() {
		Login.clickOnLogin();
	}

	@Then("it should go the home page")
	public void it_should_go_the_home_page() {
		String expectedTitle= "conduit";
		String actualTitle= driver.findElement(By.xpath("/html/body/app-root/app-layout-header/nav/div/a")).getText();
		Assert.assertEquals(expectedTitle,actualTitle,"xxxxxxx- Failed: The Tittle not found -xxxxxxx");
        System.out.println(actualTitle); 
        }
	
	@And("close browser")
		public void close_browser() {
			driver.close();
			driver.quit();
		}

}