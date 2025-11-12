package testNGBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//XML not needed as we are giving data here itself using a different method
//If we don't have name attribute in @DataProvider, we need to use method name in @Test for the attribute dataProvider = "getData"
//Data Provider will suppress Parameters when both used
public class DataProvidersOnDiffClass {
	
	//We can access Data Provider class using Inheritance(Extends)
	//We can access Data Provider class using dataProviderClass attribute
	
	@Test(dataProvider = "UserCreds", dataProviderClass = DataUtilsJavaClass.class)
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
}
