package testNGBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizationAdvWithBrowser {
	WebDriver driver;
	@Test
	@Parameters({"userID","password","browser"})
	public void launchWithDifferentBrowser(String username, String password, String browser) {
		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Program failed");
			break;
		}
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
}

