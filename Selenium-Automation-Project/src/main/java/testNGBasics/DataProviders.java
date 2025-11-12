package testNGBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//XML not needed as we are giving data here itself using a different method
//Data Provider will suppress Parameters when both used
//If we don't have name attribute in @DataProvider, we need to use method name in @Test for the attribute dataProvider = "getData"
public class DataProviders {
	
	@DataProvider(name = "UserCreds")
	public String[][] getData() {
		String [][] credentials = new String[3][2];
		
		//Each array will be separate data
		//Data Array 1
		credentials[0][0] = "Admin";	//First Value given to First Parameter(username)
		credentials[0][1] = "admin123";	//Second Value given to Second Parameter(password)
		
		//Data Array 2
		credentials[1][0] = "TestAdmin";
		credentials[1][1] = "Test@1234";
		
		//Data Array 3
		credentials[2][0] = "WrongUser";
		credentials[2][1] = "WrongPass";
		
		return credentials;
		
	}

	@Test(dataProvider = "UserCreds")
	public void loginWithGivenCreds(String username, String password) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement userNameElement = driver.findElement(By.name("username"));
		userNameElement.sendKeys(username);
		
		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(password);
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()=' Login ']"));
		loginBtn.click();
		
		WebElement dashBoard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dashBoard));
		driver.quit();
	}
	
	@Test(dataProvider = "UserCreds")
	//When single dimensional array is used then it'll take the index of arrays 0,1,2
	public void loginByCreds(String credentials[]) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement userNameElement = driver.findElement(By.name("username"));
		//For 0th Index Array, 0th value will be taken and so on
		userNameElement.sendKeys(credentials[0]);
		
		WebElement passwordElement = driver.findElement(By.name("password"));
		//For 0th Index Array, 1st value will be taken and so on
		passwordElement.sendKeys(credentials[1]);
		
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()=' Login ']"));
		loginBtn.click();
		
		WebElement dashBoard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dashBoard));
		driver.quit();
	}
}
