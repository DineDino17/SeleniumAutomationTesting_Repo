package testBrowser;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingWebTest extends ShoppingWebXpathFile{

	public static void main(String[] args) {
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
		
		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		driver.findElement(addToCart).click();
		driver.findElement(shoppingCartLink).click();
		driver.findElement(shoppingCartItem1).isDisplayed();
		driver.findElement(checkout).click();
		
		Thread.sleep(3000);
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

