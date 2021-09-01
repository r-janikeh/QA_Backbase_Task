package StepDefinitions;

import java.util.Random;
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

public class CRUDarticles {

	String BaseURL = "https://candidatex:qa-is-cool@qa-task.backbasecloud.com/";
	WebDriver driver = null;
	Login_PF Login;


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

	@When("Click on New atricle button")
	public void click_on_newarticle_button() {
		driver.findElement(By.xpath("/html/body/app-root/app-layout-header/nav/div/ul/li[2]/a")).click();
	}

	@And("User enters data on the fields")
	public void user_enters_data(String articletitle, String about, String article, String tag) {

		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(10);  
		driver.findElement(By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[1]/input")).sendKeys("articletitle"+ randomInt +"test");

		driver.findElement(By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[2]/input")).sendKeys("about_test");
		driver.findElement(By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[3]/textarea")).sendKeys("article_test");

		driver.findElement(By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/fieldset[4]/input")).sendKeys("tag_test");
	}	

	@And("Click on Punlish Article button")
	public void click_on_punlish_article_button()
	{
		driver.findElement(By.xpath("/html/body/app-root/app-editor-page/div/div/div/div/form/fieldset/button")).click();
	}

	@Then("it should go the Article page detail")
	public void it_should_go_the_Article_page_detail() {

		String articl_data = driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[2]/div[1]/div/div/p")).getText();
		System.out.println(articl_data);  
	}


	//comment and post
	@When("User enters comment and post")
	public void user_enters_comment_and_post() {

		driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[2]/div[3]/div/div/form/fieldset/div[1]/textarea")).sendKeys("TEST");
		driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[2]/div[3]/div/div/form/fieldset/div[2]/button")).click();

		String expectedTitle= "TEST";
		String actualTitle= driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[2]/div[3]/div/app-article-comment/div/div[1]/p")).getText();
		Assert.assertEquals(expectedTitle,actualTitle,"xxxxxxx- Failed: The Tittle not found -xxxxxxx");
		System.out.println(actualTitle); 

	}

	//delete comment
	@And("User delete the comment")
	public void user_delete_the_comment() {
		driver.findElement(By.xpath("/html/body/app-root/app-article-page/div/div[2]/div[2]/app-article-meta/div/span[1]/button")).click();
		String NoarticleS = driver.findElement(By.xpath("/html/body/app-root/app-home-page/div/div/div/div[1]/app-article-list/div[2]")).getText();
		System.out.println(NoarticleS);
	}


	@And("close browser")
	public void close_browser() {
		driver.close();
		driver.quit();
	}
}
