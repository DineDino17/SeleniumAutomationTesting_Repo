package testNGBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationAdv {
	WebDriver driver;
	@Test
	@Parameters({"userID","password","credentials"})
	public void loginWithCorrectPassword(String username, String password, String creds) {
		
		switch (creds) {
		case "Correct":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
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
			break;
		
		case "Incorrect":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement userNameIncorrect = driver.findElement(By.name("username"));
			userNameIncorrect.sendKeys("Admin");
			
			WebElement passwordIncorrect = driver.findElement(By.name("password"));
			passwordIncorrect.sendKeys("Test84616");
			
			WebElement loginBtnClick = driver.findElement(By.xpath("//button[text()=' Login ']"));
			loginBtnClick.click();
			
			WebElement dashBoardNA = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
			
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.visibilityOf(dashBoardNA));
			driver.quit();
			
			break;

		default:
			System.out.println("No or Incorrect Input");
			break;
		}
		
	}
}

