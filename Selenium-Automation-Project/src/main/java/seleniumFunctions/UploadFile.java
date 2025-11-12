package seleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");

	    WebElement fileInput = driver.findElement(By.id("file-upload"));
	    fileInput.sendKeys("C:\\Users\\DineDino\\Downloads\\UploadFile.txt");
	    driver.findElement(By.id("file-submit")).click();

	}

}
