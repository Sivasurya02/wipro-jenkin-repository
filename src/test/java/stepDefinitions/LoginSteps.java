package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	WebDriverWait wait;
	
	@Before("@LoginTest")
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://the-internet.herokuapp.com/login");
	}
	
	@When("the user enters valid username {string} and password {string}")
	public void the_user_enters_valid_username_and_password(String Username, String Password) {
		// Write code here that turns the phrase above into concrete actions
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		name.sendKeys(Username);
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		pass.sendKeys(Password);
	}
	
	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type=submit]")));
		login.click();
	}
	
	@Then("the user should see a successful login message")
	public void the_user_should_see_a_successful_login_message() {
		// Write code here that turns the phrase above into concrete actions
		String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash"))).getText();
        Assert.assertTrue(msg.contains("You logged into a secure area!"));
	}
	
	@After("@LoginTest")
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
