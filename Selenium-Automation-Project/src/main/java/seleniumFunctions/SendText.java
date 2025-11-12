package seleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendText {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
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
		//This will switch to the active element which is in focus
		driver.switchTo().activeElement();
		//driver.quit();

	}

}
