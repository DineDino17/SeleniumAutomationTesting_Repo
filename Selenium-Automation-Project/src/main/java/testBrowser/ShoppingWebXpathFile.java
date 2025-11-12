package testBrowser;

import org.openqa.selenium.By;

public class ShoppingWebXpathFile {
	
	public By username = By.xpath("//input[@id='user-name']");
	public By password = By.xpath("//input[@id='password']");
	public By submit = By.xpath("//input[@id='login-button']");
	public By addToCart = By.xpath("//button[text()='Add to cart']");
	public By shoppingCartLink = By.xpath("//a[@class='shopping_cart_link']");
	public By shoppingCartItem1 = By.xpath("//a[@class='shopping_cart_link']//span[text()='1']");
	public By remove1 = By.xpath("//button[text()='Remove']");
	public By checkout = By.xpath("//button[text()='Checkout']");
}
