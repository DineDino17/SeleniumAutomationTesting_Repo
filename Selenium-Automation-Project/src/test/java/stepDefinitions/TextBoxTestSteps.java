package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class TextBoxTestSteps {
	WebDriver driver = new ChromeDriver();
	
	@Given("the user launches the Web Page")
	public void the_user_launches_the_web_page() {
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
	}
	@And("the user clicks menu bar")
	public void the_user_clicks_menu_bar() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menuform:j_idt40")));
		WebElement menu = driver.findElement(By.id("menuform:j_idt40"));
		menu.click();
	}
	    
	@And("the user clicks textbox option")
	public void the_user_clicks_textbox_option() {
		WebElement textBoxOpt = driver.findElement(By.xpath("//a//span[text()='Text Box']"));
		textBoxOpt.click();  
	}
	@And("the user enters {string} in typeName textbox")
	public void the_user_enters_in_textbox(String text) {
		WebElement typeName = driver.findElement(By.xpath("//h5[text()='Type your name']//following-sibling::div//input[@type='text']"));
		typeName.sendKeys(text);
	}

}
