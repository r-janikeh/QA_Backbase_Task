package StepDefinitions;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

import POM.SingUp_PF;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingUp_Steps {
	String BaseURL = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com/";

	WebDriver driver;
	SingUp_PF SingUp ;


	@Test
	@Given("User Launch The browser")
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

		throw new io.cucumber.java.PendingException();
	}


	@When("User opens URL")
	public void user_opens_url(String string) {
		System.out.println("The browser launched");

	}

	@And("Click on Sign up")
	public void click_on_sign_up() {

		//I use the Page factor model
		SingUp.clickOnSignup1();

	}


	@And("^user enters Username as (.*) Email as (.*)  and Password as (.*)$")
	public void user_enters_username_as_email_as_and_password_as(String username, String email, String password) {




		driver.findElement(By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[1]/input")).clear();

		Random randomGeneratorUser = new Random();  
		int randomInt1 = randomGeneratorUser.nextInt(10); 
		SingUp.enterUsername("user"+ randomInt1 +"@gmail.com");


		driver.findElement(By.xpath("/html/body/app-root/app-auth-page/div/div/div/div/form/fieldset/fieldset[2]/input")).clear();
		Random randomGeneratorEmail = new Random();  
		int randomInt2 = randomGeneratorEmail.nextInt(10);  
		SingUp.enterEmail("email"+ randomInt2 +"@gmail.com");

		SingUp.enterPassword(password);

	}


	@And("Click on Sign up button.")
	public void click_on_sign_up_button() {
		SingUp.clickOnSignup2();
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
