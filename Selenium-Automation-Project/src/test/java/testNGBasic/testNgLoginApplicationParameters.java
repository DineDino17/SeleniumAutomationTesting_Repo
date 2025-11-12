package testNGBasic;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test(invocationCount = 2, invocationTimeOut = 5000)
public class testNgLoginApplicationParameters {
	@Parameters({"username", "password"})
	@Test(priority = 1, groups = {"Login App"})
	public void enterCreds(String username, String password) {
		System.out.println("Username Entered was: "+username);
		System.out.println("Password Entered was: "+password);
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
	@Parameters({"accountNumber"})
	@Test(priority = 4, groups= {"Get Details"})
	public void greetCustomer(int accountNumber) {
		System.out.println("Customer greeted using account number: "+accountNumber);
	}
	@Parameters({"tranxType"})
	@Test(priority = 5, groups= {"Get Details"})
	public void selectTranx(String tranxType) {
		System.out.println("Transaction selected for: "+tranxType);
	}
	@Test(priority = 6, dependsOnMethods = "selectTranx", groups= {"Create case"})
	public void createCase() {
		System.out.println("Case created using account number and transaction");
	}
}
