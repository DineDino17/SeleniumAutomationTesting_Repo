package seleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		System.out.println("Hello World");
		
		//Click
		WebElement menu = driver.findElement(By.id("menuform:j_idt40"));
		menu.click();
		System.out.println("Menu clicked");
		
		WebElement button = driver.findElement(By.className("rotated-icon"));
		button.click();
		System.out.println("Button option clicked");
		
		WebElement clickTitle = driver.findElement(By.xpath("//span[text()='Click']"));
		clickTitle.click();
		System.out.println("Title clicked");
		
		Thread.sleep(2000);
		driver.quit();
		
		
		
	}

}
