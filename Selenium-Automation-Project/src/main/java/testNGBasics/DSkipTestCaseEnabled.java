package testNGBasics;

import org.testng.annotations.Test;

public class DSkipTestCaseEnabled {
	
	//We can skip a Test case using enabled when it is not depended on any other method
	//If it is depended then it will get failed when enabled is false then it means there is no such method presents with @Test
	//By default enabled will be false so that Test case run
	//Enabled will suppress all the other options
	//When enabled is true, this method will run even when parent method fails
	//Description will provide some details of test after run
	@Test(priority=-2, description = "This has the lowest priority of all")
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
	
	//This will skip this test case
	@Test(priority=1, enabled = false)
	public void checkingForPrice() {
		System.out.println("5. Checking for a price");
	}
	@Test(priority=2, enabled=true)
	public void billingAPen() {
		System.out.println("6. Billing a pen");
	}
	//When alwaysRun is true then it'll run even when parent method fails
	@Test(priority=5, dependsOnMethods = "billingAPen", alwaysRun = true)
	public void boughtAPen() {
		System.out.println("7. Bought a pen");
	}
	@Test(priority=8)
	public void walkingBackToHome() {
		System.out.println("8. Walking back to home");
	}
}
