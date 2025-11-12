package testNGBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.annotations.Test;


public class SendText {
	@Test(priority = 1, description = "This is the example of Send Text")
	public void sendTextTestNG() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		try {
		driver.get("https://www.leafground.com/dashboard.xhtml");
		driver.manage().window().maximize();
		
		//Browser Menu
		WebElement elementMenu = driver.findElement(By.id("menuform:j_idt40"));
		elementMenu.click();
		//Using link text which is the exact test of this a in DOM
		WebElement textBox = driver.findElement(By.linkText("Text Box"));
		textBox.click();
		
		WebElement nameTB = driver.findElement(By.name("j_idt88:name"));
		nameTB.sendKeys("Dines"+Keys.BACK_SPACE);
		System.out.println("Success");
		
		WebElement appendTB = driver.findElement(By.id("j_idt88:j_idt91"));
		appendTB.sendKeys(" is capital");
		
		WebElement disabledTB = driver.findElement(By.id("j_idt88:j_idt93"));
		boolean status = disabledTB.isEnabled();
		System.out.println("TB status is enabled: "+status);
		
		WebElement clearTB = driver.findElement(By.id("j_idt88:j_idt95"));
		clearTB.clear();
		
		WebElement retrieveTB = driver.findElement(By.id("j_idt88:j_idt97"));
		String text = retrieveTB.getDomAttribute("value");
		System.out.println(text);
		
		WebElement enterEmailTB = driver.findElement(By.id("j_idt88:j_idt99"));
		enterEmailTB.sendKeys("test@gmail.com"+Keys.TAB);
		
		WebElement aboutYourselfTB = driver.findElement(By.id("j_idt88:j_idt101"));
		aboutYourselfTB.sendKeys("I'm Good");
		
		WebElement textEditorBox = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		textEditorBox.sendKeys("Make this word as bold and this as italic");
		
		WebElement pressEnterForError = driver.findElement(By.id("j_idt106:thisform:age"));
		new Actions(driver).scrollToElement(pressEnterForError).perform();
		pressEnterForError.click();
		pressEnterForError.sendKeys(Keys.ENTER);
		WebElement getErrorMsg = driver.findElement(By.id("j_idt106:thisform:j_idt110_error-detail"));
		String errorMsg = getErrorMsg.getText();
		System.out.println(errorMsg);
		
		WebElement keyboardDisplayTB = driver.findElement(By.id("j_idt106:j_idt122"));
		keyboardDisplayTB.click();
		WebElement keyboardDisplay = driver.findElement(By.className("keypad-row"));
		boolean isKeyboardFound = keyboardDisplay.isDisplayed();
		System.out.println("Keyboard Displayed: "+isKeyboardFound);
		
		System.out.println("Test complete for Send Text");
		}
		finally {
		driver.quit();
		}

	}
	@Test(priority = 3, enabled = true, description = "This is the example of Radio button which can't be found", expectedExceptions = {MoveTargetOutOfBoundsException.class})
	public void radioButton() throws InterruptedException {
		WebDriver driver =new ChromeDriver();
		try {
		driver.get("https://designsystem.digital.gov/components/radio-buttons/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		WebElement scrollTo = driver.findElement(By.xpath("//h3//following-sibling::fieldset[@class='usa-fieldset']//div//input[@value='sojourner-truth']")); 
		new Actions(driver).scrollToElement(scrollTo).perform();
		Thread.sleep(2000);
		boolean elementSel = scrollTo.isSelected();
		System.out.println("Is element selected: "+elementSel);
		Thread.sleep(2000);
		scrollTo.click();
		}
		finally {
		driver.quit();
		}
		
	}
	@Test(priority = 2, description = "This is the decsription of Radio button in leaf ground")
	public void radioButtonLeafGround() {
		WebDriver driver =new ChromeDriver();
		try {
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
		finally {
		driver.quit();
		}
		
	}

}
