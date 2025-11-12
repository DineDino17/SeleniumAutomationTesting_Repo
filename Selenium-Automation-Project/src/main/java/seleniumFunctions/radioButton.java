package seleniumFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class radioButton {

	public void selectByValue(WebElement Element, String value) {
		Select selectByValue = new Select(Element);
		selectByValue.selectByValue(value);
	}
	
}
