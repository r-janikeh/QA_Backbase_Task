package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM.Login_PF;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FavoriteArticles {
	
	String BaseURL = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com/";
	WebDriver driver;
	Login_PF Login;
	
	
	@Given("User Launch The browser and login")
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
	
	
	
	@When("Click on tags from right side in the home page")
	public void click_on_tags() {
		
		driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[2]/div/div[1]/a[1]")).click();
		String TagTitle = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/div/ul/li[3]/a")).getText();
		System.out.println("the chose tag is"+TagTitle); 
	}
	
		@And("Click on Favorite icon from a article")
		public void click_on_Favorite_icon() {
		driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/app-article-preview[1]/div/app-article-meta/div/app-favorite-button/button")).click();
		}
		
		@And("The number should increase")
		public void number_should_increase() {
		String expectedTitle= "1";
		String actualTitle= driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/app-article-preview[1]/div/app-article-meta/div/app-favorite-button/button")).getText();
		Assert.assertEquals(expectedTitle,actualTitle,"xxxxxxx- Failed: The Tittle not found -xxxxxxx");
        System.out.println(actualTitle); 
        }
	
	
	@And("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}
}
