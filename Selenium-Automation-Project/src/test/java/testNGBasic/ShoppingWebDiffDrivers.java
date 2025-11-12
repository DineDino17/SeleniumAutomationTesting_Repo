package testNGBasic;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import pageObjects.ShoppingWebXpathFile;

public class ShoppingWebDiffDrivers extends ShoppingWebXpathFile{
	RemoteWebDriver driver;
	// For TestNG, Static should not be used and returns only void
	@Test
	public void TestRun() {
		
		System.out.println("1. Chrome");
		System.out.println("2. Edge");
		System.out.println("Select the brrowser to run Test");
		Scanner input = new Scanner(System.in);
		//For getting string input .nextLine() needs to be used
		String a = input.nextLine();
		String browser="";
		
		if(a.equals("1")) {
			browser = "chrome";
		}
		else if(a.equals("2")) {
			browser = "edge";
		}
		else {
			System.out.println("No browser found");
		}
		System.out.println("Selected browser is: "+browser);
		
		input.close();// Closing scanner to avoid memory leaks
		
		demoBankWeb(browser);
		
	}
	
	public void demoBankWeb (String browser){
		
		
		switch(browser) {
		case "chrome":
			driver = new ChromeDriver();
			break; //If break is not used then it'll continue to switch next case as well 
		case "edge":
			driver = new EdgeDriver();
			break;
		}
		//WebDriver driver = new ChromeDriver();
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

