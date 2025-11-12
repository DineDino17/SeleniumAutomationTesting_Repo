package testNGBasic;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageObjects.ShoppingWebXpathFile;

public class ShoppingWebTest extends ShoppingWebXpathFile{

	// For TestNG, Static should not be used and returns only void
	@Test
	public void TestRun() {
		ShoppingWebTest demoBankWebObj = new ShoppingWebTest();
		demoBankWebObj.demoBankWeb();
	}
	
	public void demoBankWeb (){
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demoqa.com/");
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		try {
		driver.findElement(username).sendKeys("standard_user");
		driver.findElement(password).sendKeys("secret_sauce");
		driver.findElement(submit).click();
		
		Thread.sleep(1000);
		//driver.switchTo().alert().accept();
		driver.findElement(addToCart).click();
		driver.findElement(shoppingCartLink).click();
		driver.findElement(shoppingCartItem1).isDisplayed();
		driver.findElement(checkout).click();
		
		Thread.sleep(2000);
		System.out.println("Test completed successfully");
		}
		catch(Exception e){
			System.err.println("Test failed due to "+e);
		}
		finally {
			driver.quit();
		}
		
	}

}

