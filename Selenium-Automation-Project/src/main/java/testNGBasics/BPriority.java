package testNGBasics;

import org.testng.annotations.Test;


public class BPriority {
	
	//Methods will run in ASCII order. To control that we can set priority
	
	//Going to super market buying pen and coming back to home
	@Test(priority=-2)
	public void walkToSuperMarket() {
		System.out.println("1. Walking to supermarket to buy a pen");
	}
	@Test(priority=-1)
	public void reachedSuperMarket() {
		System.out.println("2. Reached Supermarket");
	}
	//When priority is not given, it'll consider priority as 0 and runs in ASCII order
	@Test
	public void foundAPen() {
		System.out.println("4. Found a pen");
	}
	@Test
	public void checkingForPen() {
		System.out.println("3. checking for a pen");
	}
	@Test(priority=1)
	public void checkingForPrice() {
		System.out.println("5. Checking for a price");
	}
	@Test(priority=2)
	public void billingAPen() {
		System.out.println("6. Billing a pen");
	}
	@Test(priority=5)
	public void boughtAPen() {
		System.out.println("7. Bought a pen");
	}
	@Test(priority=8)
	public void walkingBackToHome() {
		System.out.println("8. Walking back to home");
	}

}
