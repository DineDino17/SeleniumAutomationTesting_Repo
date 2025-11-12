package seleniumFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class hoverOrMoveToElement {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		Actions hoverBlog = new Actions(driver);
		WebElement cursorOnBlog = driver.findElement(By.xpath("//span[text()='Blogs']//parent::a//parent::li"));
		//WebElement cursorOnBlog = driver.findElement(By.id("blogsmenu"));
		hoverBlog.moveToElement(cursorOnBlog).perform();
		System.out.println("Cursor moved");
		Thread.sleep(2000);
		WebElement seleniumBtn = driver.findElement(By.xpath("//span[text()='Selenium143']"));
		seleniumBtn.click();
		System.out.println("Element clicked");
		
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
