package seleniumFunctions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Browser Menu
		WebElement elementMenu = driver.findElement(By.id("menuform:j_idt40"));
		elementMenu.click();

		//Check-box Menu
		WebElement checkboxMenu = driver.findElement(By.linkText("Check Box"));
		checkboxMenu.click();
		
		//WebElement basicCB = driver.findElement(By.xpath("//span[text()='Basic']//preceding-sibling::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"));
		//WebElement basicCB = driver.findElement(By.id("j_idt87:j_idt89_input"));
		//basicCB.click();

		//WebElement ajaxCB = driver.findElement(By.xpath("//span[text()='Ajax']//preceding-sibling::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"));
		WebElement ajaxCB = driver.findElement(By.xpath("//span[text()='Ajax']//preceding-sibling::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"));
		ajaxCB.click();

		WebElement toggleSwitch = driver.findElement(By.id("j_idt87:j_idt100"));
		toggleSwitch.click();

		//WebElement cbDisabled = driver.findElement(By.xpath("//span[text()='Disabled']//preceding-sibling::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default ui-state-disabled ui-state-disabled']"));
		WebElement cbDisabled = driver.findElement(By.xpath("//span[text()='Disabled']//preceding-sibling::div//input[@id='j_idt87:j_idt102_input']"));
		boolean isEnabled = cbDisabled.isEnabled();
		System.out.println(isEnabled);

		WebElement javaLang = driver.findElement(By.xpath("//label[text()='Java']//parent::td//div/input"));
		boolean selected = javaLang.isSelected();
		if(!selected) {
			javaLang.click();
		}
	}
}
