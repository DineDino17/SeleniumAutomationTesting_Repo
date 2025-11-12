package readAndWriteData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileExample {

	public static void main(String[] args) throws IOException {
		
		FileInputStream readPropertyFile = new FileInputStream("./src/test/resources/environment.properties");
		Properties propertyFile = new Properties();
		propertyFile.load(readPropertyFile);
		System.out.println("Browser is: "+propertyFile.getProperty("browser"));
		System.out.println("Browser path is: "+propertyFile.getProperty("chromeDriverPath"));
		
		
		String browser = propertyFile.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("webdriver.chrome.driver");
		}
		

	}

}
