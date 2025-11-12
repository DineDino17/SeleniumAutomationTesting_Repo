package testNGBasic;

import org.testng.annotations.Test;

@Test(invocationCount = 2, invocationTimeOut = 5000)
public class testNgGroupsExample {
	@Test(priority = 1, groups = {"Login App"})
	public void enterCreds() {
		System.out.println("Username Entered");
		System.out.println("Password Entered");
	}
	@Test(priority = 2, groups = {"Login App"})
	public void submitExm() {
		System.out.println("Submitted");
	}
	//When enabled = false then it means that it won't even consider the @Test annotation
	@Test(priority = 3, dependsOnMethods = "selectTranx",groups = {"Login App"}, enabled = true, alwaysRun = true)
	public void loginExm() {
		System.out.println("Login success");
	}
	@Test(priority = 4, groups= {"Get Details"})
	public void greetCustomer() {
		System.out.println("Customer greeted using account number");
	}
	@Test(priority = 5, groups= {"Get Details"})
	public void selectTranx() {
		System.out.println("Transaction selected");
	}
	@Test(priority = 6, dependsOnMethods = "selectTranx", groups= {"Create case"})
	public void createCase() {
		System.out.println("Case created using account number and transaction");
	}
}
