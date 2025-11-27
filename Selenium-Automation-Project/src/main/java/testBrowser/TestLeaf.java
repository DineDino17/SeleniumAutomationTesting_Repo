package testBrowser;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLeaf {
	WebDriver driver;
	RemoteWebDriver driverRemote;
	//RemoteWebDriver driver;
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public static void main(String[] args) {
		//This is not needed as driver was already set in System environment variables
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		TestLeaf runTestObj = new TestLeaf();
		//runTestObj.textBox();
		//runTestObj.button();
		//runTestObj.dropDown();
		runTestObj.waitTest();
		//runTestObj.handlingWindowTest();
		//runTestObj.handlingAlertTest();
		runTestObj.tearDown();
			
		
	}
	public void keys() throws AWTException {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).build().perform();
		
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
	}
	
	public void waitAndScreenshot() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		
		fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath("locator"));
			}
		});
		
		
		//Function function = new Function();
		
		
		RemoteWebDriver remoteDriver = (RemoteWebDriver)driver;
		File fileSrc = remoteDriver.getScreenshotAs(OutputType.FILE);
		File fileDest = new File("./screenshots/driver.png");
		
		FileHandler.copy(fileSrc, fileDest);
		
	}
	public void textBox() {
		try {
			driver = new ChromeDriver();
			
			driver.get("https://www.leafground.com/dashboard.xhtml");
			//driver.navigate().to("");
			//driver.navigate().back();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			Actions actions = new Actions(driver);
			//For switching to active element directly
			//driver.switchTo().activeElement();
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search...']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menuform:j_idt40")));
			WebElement menu = driver.findElement(By.id("menuform:j_idt40"));
			//WebElement menu = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
			menu.click();
			
			WebElement textBoxOpt = driver.findElement(By.xpath("//a//span[text()='Text Box']"));
			textBoxOpt.click();
			
			WebElement typeName = driver.findElement(By.xpath("//h5[text()='Type your name']//following-sibling::div//input[@type='text']"));
			typeName.sendKeys("Dine Dino");
			
			WebElement appendText = driver.findElement(By.xpath("//h5[text()='Append Country to this City.']//following-sibling::div//input[@type='text']"));
			System.out.println("Append text box is enabled: "+appendText.isEnabled());
			appendText.sendKeys(" is Great");
						
			WebElement disabledText = driver.findElement(By.xpath("//h5[text()='Verify if text box is disabled']//following-sibling::div//input[@type='text']"));
			System.out.println("Text box is enabled: "+disabledText.isEnabled());
			
			WebElement retriveText = driver.findElement(By.xpath("//h5[text()='Retrieve the typed text.']//following-sibling::div//input[@type='text']"));
			System.out.println("Retrived text is: "+retriveText.getDomAttribute("value"));
			
			
			WebElement textEditor = driver.findElement(By.id("j_idt88:j_idt103_editor"));
			actions.scrollToElement(textEditor).perform();
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.visibilityOf(textEditor));
			textEditor.click();
			driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("Hi and Bye");
		
			WebElement errorMsg = driver.findElement(By.id("j_idt106:thisform:age"));
			actions.scrollToElement(errorMsg).perform();
			Thread.sleep(1000);
			errorMsg.click();
			errorMsg.sendKeys(Keys.ENTER);

			// Hold the SHIFT key
			actions.keyDown(Keys.SHIFT);
			

			// Type text while SHIFT is held (so it will type in uppercase)
			actions.sendKeys("selenium");

			// Release the SHIFT key
			actions.keyUp(Keys.SHIFT);

			// Build and perform the full sequence
			actions.build().perform();
			//wait.until(ExpectedConditions.domAttributeToBe(driver.findElement(By.id("javax.faces.error.xhtml")), "id", "javax.faces.error.xhtml"));
			//WebElement errorPage = driver.findElement(By.xpath("//h1[text()='An Error Occurred:']"));
			//System.out.println("Error page displayed "+errorPage.isDisplayed());
			
			Thread.sleep(2000);
			actions.scrollToElement(driver.findElement(By.id("j_idt106:j_idt122"))).perform();
			
			WebElement sliderBox = driver.findElement(By.id("j_idt106:slider"));
			actions.scrollToElement(driver.findElement(By.id("j_idt106:slider"))).perform();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("j_idt106:slider"))));
			
			sliderBox.sendKeys("10");
			Thread.sleep(1000);
			WebElement slider = driver.findElement(By.cssSelector("div[style='width: 10%;']"));
			System.out.println(slider.getDomAttribute("style"));
			String sliderValue = slider.toString();
			System.out.println("Slider value is: "+sliderValue);
			
			Thread.sleep(2000);
			System.out.println("Test Text box passed");
			
		}
		catch(Exception e){
			System.err.println("Test Text box failed due to "+e);
		}
	}
	
	public void button() {
		try {
			driver = new ChromeDriver();
			
			driver.get("https://www.leafground.com/dashboard.xhtml");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			Actions actions = new Actions(driver);
			
			WebElement menu = driver.findElement(By.id("menuform:j_idt40"));
			//WebElement menu = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
			menu.click();
			
			WebElement buttonOpt = driver.findElement(By.xpath("//a//span[text()='Button']"));
			buttonOpt.click();
			
			WebElement btnColor = driver.findElement(By.xpath("//span[text()='Success']"));
			actions.moveToElement(btnColor).perform();
			Thread.sleep(2000);
			System.out.println(btnColor.getCssValue("background-color"));
			//java.awt.Color newColor = Color.fromString(btnColor.getCssValue("background-color")).getColor();
			
			if(btnColor.getCssValue("background-color").equals("salmon")) {
				System.out.println("Color is salmon");
			}
			else {
				System.out.println("Color is green");
			}
			
			Thread.sleep(2000);
			System.out.println("Test Button passed");
			
		}
		catch(Exception e){
			System.err.println("Test Text box failed due to "+e);
		}
	}
	
	public void dropDown() {
		try {
			driver = new ChromeDriver();
			
			driver.get("https://www.leafground.com/dashboard.xhtml");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			Actions actions = new Actions(driver);
			
			WebElement menu = driver.findElement(By.id("menuform:j_idt40"));
			//WebElement menu = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
			menu.click();
			
			WebElement dropDownOpt = driver.findElement(By.xpath("//a//span[text()='Dropdown']"));
			dropDownOpt.click();
			
			WebElement favTool = driver.findElement(By.xpath("//h5[text()='Which is your favorite UI Automation tool?']//following-sibling::div//select"));
			Select favAutoToolDD = new Select(favTool);
			favAutoToolDD.selectByVisibleText("Selenium");
			
			Thread.sleep(2000);
			System.out.println("Dropdown test is passed");
			
		}
		catch(Exception e){
			System.err.println("Test Dropdown failed due to "+e);
		}
	}
	
	public void waitTest() {
		try {
			driver = new ChromeDriver();
			
			driver.get("https://www.leafground.com/dashboard.xhtml");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			Actions actions = new Actions(driver);
			
			WebElement menu = driver.findElement(By.id("menuform:j_idt40"));
			//WebElement menu = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
			menu.click();
			
			WebElement waitsOpt = driver.findElement(By.xpath("//a//span[text()='Waits']"));
			waitsOpt.click();
			
			
			WebElement waitForVisible = driver.findElement(By.xpath("//h5[contains(text(),'Wait for Visibility')]//following-sibling::div//button"));
			
			/*
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'I am here')]")));
			System.out.println("Element is visible");
			*/
			
			Wait<WebDriver> fluentWaitAlertOpt = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
			
			fluentWaitAlertOpt.until(new Function<WebDriver, WebElement>(){
				public WebElement apply(WebDriver driver) {
					return waitForVisible;
				}
			});
			waitForVisible.click();
			
			//Fluent wait
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(4)).ignoring(NoSuchElementException.class);
			
			fluentWait.until(new Function<WebDriver, WebElement>() {
				
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//span[contains(text(),'I am here')]"));
				}
				
			});
			
			System.out.println("Element is visible");
			
			
			
			WebElement waitForInVisible = driver.findElement(By.xpath("//h5[contains(text(),'Wait for Invisibility')]//following-sibling::div//button//span[text()='Click']"));
			waitForInVisible.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt87:j_idt93")));
			System.out.println("Element is invisible");
			
			WebElement waitForClickable = driver.findElement(By.xpath("//h5[contains(text(),'Wait for Clickability')]//following-sibling::div//button//span[text()='Click First Button']"));
			waitForClickable.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='Message Content']")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='j_idt87:j_idt96']//span[text()='Click Second']")));
			driver.findElement(By.xpath("//button[@id='j_idt87:j_idt96']//span[text()='Click Second']")).click();
			System.out.println("Element is clickable");
			
			WebElement waitForChangeText = driver.findElement(By.xpath("//h5[contains(text(),'Wait for Text Change')]//following-sibling::div//button//span[text()='Click']"));
			waitForChangeText.click();
			wait.until(ExpectedConditions.textToBe(By.xpath("//button[@id='j_idt87:j_idt99']//span[text()='Did you notice?']"),"Did you notice?"));
			System.out.println("Element text is changed");
			
			
			Thread.sleep(2000);
			System.out.println("Wait test is passed");
			
		}
		catch(Exception e){
			System.err.println("Test waits failed due to "+e);
		}
	}
	
	public void handlingWindowTest() {
		try {
			driver = new ChromeDriver();
			
			driver.get("https://www.leafground.com/dashboard.xhtml");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			Actions actions = new Actions(driver);
			
			WebElement browserMenu = driver.findElement(By.id("menuform:j_idt39"));
			browserMenu.click();
			
			WebElement windowOpt = driver.findElement(By.xpath("//a//span[text()='Window']"));
			windowOpt.click();
			
			Thread.sleep(5000);
			String orgWindow = driver.getWindowHandle();
			//driver.switchTo().window(orgWindow);
			
			WebElement openNewWindowBtn = driver.findElement(By.xpath("//h5[contains(text(),'Click and Confirm new Window Opens')]//following-sibling::button"));
			openNewWindowBtn.click();
			
			
			Set<String> allWindows = driver.getWindowHandles();
			for(String newWindow:allWindows) {
				String titleOfWindow = driver.switchTo().window(newWindow).getTitle();
				System.out.println(titleOfWindow);
				
				if(titleOfWindow.equals("Dashboard")) {
					driver.switchTo().window(newWindow);
					break;
				}
			}
			
			
			WebElement searchBar = driver.findElement(By.xpath("//input[@placeholder='Search...']"));
			searchBar.sendKeys("Hey, I'm here");
			
			driver.switchTo().window(orgWindow);
			
			
			WebElement closeNewWindowBtn = driver.findElement(By.xpath("//span[contains(text(),'Close Windows')]"));
			closeNewWindowBtn.click();
			
			Thread.sleep(3000);
			Set<String> newOpenWindows = driver.getWindowHandles();
			for(String newWindow:newOpenWindows) {
				driver.switchTo().window(newWindow);
				if(!newWindow.equals(orgWindow)) {
					driver.close();
				}
			}
			
			driver.switchTo().window(orgWindow);
			Set<String> currentWindows = driver.getWindowHandles();
			WebElement openWithDelayBtn = driver.findElement(By.xpath("//span[contains(text(),'Open with delay')]"));
			openWithDelayBtn.click();
			
			wait.until((ExpectedCondition<Boolean>) handleNewWindow -> {
				Set<String> newWindows = handleNewWindow.getWindowHandles();
				return newWindows.size() > currentWindows.size();
			});
			Set<String> newCurrentWindows = driver.getWindowHandles();
			for (String delayWindow : newCurrentWindows) {
				driver.switchTo().window(delayWindow);
				if(!delayWindow.equals(orgWindow)) {
					driver.manage().window().maximize();
					driver.close();
				}
				
			}
			System.out.println("New window is visible");
			
			driver.switchTo().window(orgWindow);
			WebElement browserMenuNew = driver.findElement(By.id("menuform:j_idt37"));
			browserMenuNew.click();
			
			WebElement alertOpt = driver.findElement(By.xpath("//a//span[text()='Alert']"));
			alertOpt.click();
			
			
				
			Thread.sleep(2000);
			System.out.println("Window handling is passed");
			
		}
		catch(Exception e){
			System.err.println("Window handling failed due to "+e);
		}
	}
	
	public void handlingAlertTest() {
		try {
			driver = new ChromeDriver();
			
			driver.get("https://www.leafground.com/dashboard.xhtml");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			Actions actions = new Actions(driver);
			
			WebElement browserMenu = driver.findElement(By.id("menuform:j_idt39"));
			browserMenu.click();
			
			WebElement AlertOpt = driver.findElement(By.xpath("//a//span[text()='Alert']"));
			AlertOpt.click();
			
			
			WebElement simpleAlert = driver.findElement(By.id("j_idt88:j_idt91"));
			simpleAlert.click();
			
			Alert alert = driver.switchTo().alert();
			alert.accept();
			
			WebElement alertConfirm = driver.findElement(By.id("j_idt88:j_idt93"));
			alertConfirm.click();
			Thread.sleep(2000);
			alert.accept();
			
			WebElement sweetAlert = driver.findElement(By.id("j_idt88:j_idt95"));
			sweetAlert.click();
			
			WebElement sweetPopup = driver.findElement(By.id("j_idt88:j_idt98"));
			
			//driverRemote = (RemoteWebDriver) driver; 
			//To take the screenshot of Element RemoteWebdriver is not needed, WebElement extend TakesScreenshot
			File elementSrc = sweetPopup.getScreenshotAs(OutputType.FILE);
			File elementDest = new File("./screenshots/testElment.png");
			FileHandler.copy(elementSrc, elementDest);
			
			
			driver.findElement(By.id("j_idt88:j_idt98")).click();
			
			WebElement promptAlert = driver.findElement(By.id("j_idt88:j_idt104"));
			promptAlert.click();
			alert.sendKeys("Close this Alert");
			alert.accept();
			Thread.sleep(2000);
			
			File fileSrcPrompt = promptAlert.getScreenshotAs(OutputType.FILE);
			File fileDestPrompt = new File("./screenshots/promptAlert.png");
			FileHandler.copy(fileSrcPrompt,fileDestPrompt);
			
			RemoteWebDriver remoteWebDriver = (RemoteWebDriver) driver;
			File fileSrcDriverPrompt = remoteWebDriver.getScreenshotAs(OutputType.FILE);
			File fileDestDriverPrompt = new File("./screenshot/promptDriverScreen.png");
			FileHandler.copy(fileSrcDriverPrompt, fileDestDriverPrompt);
			
			/*
			//This will work only when RemoteWebDriver used as driver
			File screenShotSource = driver.getScreenshotAs(OutputType.FILE);
			File screenShotDestination = new File("./screenshots/test.png");
			FileHandler.copy(screenShotSource, screenShotDestination);
			*/
			
			WebElement dismissAlert = driver.findElement(By.id("j_idt88:j_idt93"));
			dismissAlert.click();
			Thread.sleep(2000);
			alert.dismiss();
			
			//getScreenshotAs method will not be available in WebDriver so RemoteWebDriver is needed
			//But WebDriver is already used in our code so I stored WebDriver in the RemoteWebDriver using casting
			driverRemote = (RemoteWebDriver) driver;
			File screenShotSource = driverRemote.getScreenshotAs(OutputType.FILE);
			File screenShotDestination = new File("./screenshots/test.png");
			FileHandler.copy(screenShotSource, screenShotDestination);
			
			Thread.sleep(2000);
			System.out.println("Alert handling is passed");
			
		}
		catch(Exception e){
			System.err.println("Alert handling failed due to "+e);
			//File screenShot = new File(driver);
		}
	}


	
	public void tearDown() {
		driver.quit();
	}

}
