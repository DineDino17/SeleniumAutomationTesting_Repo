package seleniumFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class RadioButtonExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://designsystem.digital.gov/components/radio-buttons/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement scrollTo = driver.findElement(By.xpath("//h3//following-sibling::fieldset[@class='usa-fieldset']//div//input[@value='sojourner-truth']")); 
		new Actions(driver).scrollToElement(scrollTo).perform();
		Thread.sleep(2000);
		boolean elementSel = scrollTo.isSelected();
		System.out.println("Is element selected: "+elementSel);
		
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		//Browser Menu
		WebElement elementMenu = driver.findElement(By.id("menuform:j_idt40"));
		elementMenu.click();

		//Radio button Menu
		WebElement radioButtonMenu = driver.findElement(By.linkText("Radio Button"));
		radioButtonMenu.click();
		
		WebElement unselectableRB = driver.findElement(By.xpath("//label[text()='Chennai']//preceding-sibling::div"));
		unselectableRB.click();
		
		WebElement ageGroup = driver.findElement(By.xpath("//label[text()='1-20 Years']//preceding-sibling::div"));
		boolean selectedRB = ageGroup.isSelected();
		if(!selectedRB) {
			ageGroup.click();
		}
		
		WebElement defSafari = driver.findElement(By.xpath("(//table[@id='j_idt87:console2']//td//div[@class='ui-radiobutton ui-widget']//span)[3]"));
		boolean defSafariSel = defSafari.isSelected();
		System.out.println("Default "+defSafariSel);
		
		List<WebElement> defaultSelect = driver.findElements(By.xpath("//table[@id='j_idt87:console2']//label"));
		boolean list = defaultSelect.isEmpty();
		int listSize = defaultSelect.size();
		System.out.println("Is list empty: "+list+" Size is "+listSize);
		for (WebElement rbSelected : defaultSelect) {
			if(rbSelected.isSelected()) {
				System.out.println(rbSelected);
				System.out.println(rbSelected.getText());
				break;
			}
		}
	}

}
