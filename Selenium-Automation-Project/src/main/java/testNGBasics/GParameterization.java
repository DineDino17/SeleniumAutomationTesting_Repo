package testNGBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GParameterization {
WebDriver driver;
	
	@BeforeSuite
	public void setDriver() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void getURL() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(dependsOnMethods = "getURL")
	@Parameters({"userID","password"})
	public void enterCreds(String username, String password) {
		WebElement userNameElement = driver.findElement(By.name("username"));
		userNameElement.sendKeys(username);
		
		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(password);
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()=' Login ']"));
		loginBtn.click();
	}
	@Test(dependsOnMethods = "enterCreds")
	public void validationOfLogin() {
		WebElement dashBoard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dashBoard));
		
	}
	
	@AfterSuite
	public void quitDriver() {
		driver.quit();
	}

}
