package seleniumFunctions;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

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

		WebElement randomNum = driver.findElement(By.id("j_idt106:slider"));
		randomNum.click();
		randomNum.sendKeys("20");
		WebElement sliderValue = driver.findElement(By.xpath("//div[@class='ui-slider-range ui-corner-all ui-widget-header ui-slider-range-min']"));
		//Point sliderPoint = sliderValue.getLocation();
		//int xvalue = sliderPoint.getX();
		//int yvalue = sliderPoint.getY();
		Thread.sleep(3000);
		//String getSliderValue = sliderValue.getCssValue("width");
		Dimension getSliderValue = sliderValue.getSize();
		//(807, 690)
		System.out.println(getSliderValue);

     
        //driver.quit();

	}

}
