package seleniumFunctions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LauchBrowser {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		
		
		driver.get("https://www.testleaf.com/");
		System.out.println("Hello World");
		driver.quit();
		
		WebDriver edgedriver = new EdgeDriver();
		edgedriver.get("https://www.testleaf.com/");
		edgedriver.quit();
	}

}
