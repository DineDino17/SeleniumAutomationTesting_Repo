package seleniumFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDownExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().window().maximize();
		List<WebElement> monthDD = driver.findElements(By.xpath("//select[@id='month']//option"));
		for (WebElement monthDDOptions : monthDD) {
			System.out.println(monthDDOptions.getText());
		}
		
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		//Browser Menu
		WebElement elementMenu = driver.findElement(By.id("menuform:j_idt40"));
		elementMenu.click();
		
		WebElement dropDownMenu = driver.findElement(By.linkText("Dropdown"));
		dropDownMenu.click();
		
		//WebElement countryDD = driver.findElement(By.id("j_idt87:country_input"));
		Select selCountryDD = new Select(driver.findElement(By.xpath("//select[@id='j_idt87:country_input']")));
		//selCountryDD.selectByValue(null);
		List <WebElement> countryOptions = selCountryDD.getOptions();
		if(countryOptions.isEmpty()) {
			System.out.println("List is Empty");
		}
		else {
			int optSize = countryOptions.size();
			System.out.println("Options size were "+optSize);
		}
		for (WebElement countryDDValues : countryOptions) {
			System.out.println(countryDDValues.getAttribute("innerText"));
		}
		
		//Choose the course
		WebElement chooseCourse = driver.findElement(By.id("j_idt87:auto-complete_input"));
		chooseCourse.sendKeys("po");
		Thread.sleep(2000);
		List <WebElement> courseList = driver.findElements(By.xpath("//ul[@class='ui-autocomplete-items ui-autocomplete-list ui-widget-content ui-widget ui-corner-all ui-helper-reset']//li"));
		
		for (WebElement courseOpt : courseList) {
			if (courseOpt.getDomAttribute("data-item-value").equals("PostMan") ) {
				courseOpt.click();
				System.out.println("Course option: "+courseOpt.getText());
				break;
			}
		}
		
		Thread.sleep(1000);
		chooseCourse.sendKeys(Keys.BACK_SPACE);
		
		//Select Language
		List<WebElement> languageDD = driver.findElements(By.xpath("//select[@id='j_idt87:lang_input']//option"));
		int langSize = languageDD.size();
		System.out.println("Total options is: "+langSize);
		for (WebElement langOptions : languageDD) {
			System.out.println(langOptions.getDomAttribute("textContent"));
		}
		
		//Select value from drop-down-Automation Tools //Select drop-down values using send keys
		WebElement automationToolDD = driver.findElement(By.className("ui-selectonemenu"));
		automationToolDD.sendKeys("cypr");
	
		//Select value from drop-down-Automation Tools
		Thread.sleep(1000);
		Select selectToolValue = new Select(automationToolDD);
		selectToolValue.selectByIndex(2);
		WebElement selectedValue = selectToolValue.getFirstSelectedOption();
		System.out.println("Selected value is: "+selectedValue.getText());
		
		//No of values in drop-down-Automation Tools
		List <WebElement> storeDDValues = selectToolValue.getOptions();
		for (WebElement toolsOption : storeDDValues) {
			String toolsValues = toolsOption.getText();
			System.out.println(toolsValues);
		}
		int totalValues = storeDDValues.size();
		System.out.println("Total values is "+totalValues);

	}

}
