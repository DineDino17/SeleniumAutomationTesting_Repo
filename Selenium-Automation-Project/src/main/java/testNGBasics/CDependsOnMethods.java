package testNGBasics;

import org.testng.annotations.Test;

public class CDependsOnMethods {
	
	//Scenario: Send funds to Payee using net banking
	
	//depends on methods used suppress priority when both used 
	//When only negative priority used, then Priority runs first and then depends on methods will run after negative priority
	//Zero or No Priority runs in ASCII order
	//Positive priority
	//When we have both Depends on methods and priority then it will run immediately after method and suppress priority
	//When we have two methods depends on same method then priority will be considered between two methods
	//Then Priority continues to run the method
	
	
	/*
	
		//Runs first as it has lower priority
		@Test(priority=-3)
		public void netBankingServerIsUp() {
			System.out.println("1. Server looks good for netbanking");
		}
		
		//Depends on methods will run after priority 
		@Test(priority=-10,dependsOnMethods = "netBankingServerIsUp")
		public void enterCreds() {
			System.out.println("2. Entered Login Credentials");
		}
		
		//Second to run
		@Test(priority=-7,dependsOnMethods = "enterCreds")
		public void loginSuccess() {
			System.out.println("3. Login Success");
		}
	*/
	

	//-12 has lower priority but that got suppressed by depends on methods, so -10 will run
	@Test(priority=-10)
	public void netBankingServerIsUp() {
		System.out.println("1. Server looks good for netbanking");
	}
	
	//When we have only Depends on methods then it will run after priority 
	@Test(dependsOnMethods = "netBankingServerIsUp")
	public void enterCreds() {
		System.out.println("2. Entered Login Credentials");
	}
	
	//Second to run
	@Test(priority=-7)
	public void loginSuccess() {
		System.out.println("3. Login Success");
	}
	
	//When we have both Depends on methods and priority then it will run immediately after method and suppress priority
	@Test(priority=-12, dependsOnMethods = "loginSuccess")
	public void dashboardLaunched() {
		System.out.println("4. Netbanking Dashboard launched");
	}
	
	//2. Entered Login Credentials will run as there is no negative priority now
	
	//When we have same priority then, it'll follow ASCII Order
	@Test(priority=0)
	public void goToTransferSection() {
		System.out.println("5. Navigate to Transfer Section");
	}
	
	@Test(priority=0)
	public void selectPayee() {
		System.out.println("6. Select Payee to send the funds");
	}
	
	@Test(priority=8)
	public void xenterAmountAndConfirm() {
		System.out.println("7. Enter Amount and confirm");
	}
	
	//When we have both Depends on methods and priority then it will run immediately after method and suppress priority
	//When we have two methods depends on same method then priority will be considered between two
	
	//When enabled = false then we get the below error
	//testNGBasics.DDependsOnMethods.transferSuccess() is depending on method public void testNGBasics.DDependsOnMethods.sendFunds(), which is not annotated with @Test or not included.
	
	@Test(priority=4, dependsOnMethods = "xenterAmountAndConfirm", enabled = true)
	public void sendFunds() {
		System.out.println("8. Review and send funds");
	}
	@Test(priority=10)
	public void done() {
		System.out.println("11. Done");
	}
	@Test(dependsOnMethods = "sendFunds")
	public void transferSuccess() {
		System.out.println("9. Funds transfer success");
	}
	
	@Test(priority=2, dependsOnMethods = "xenterAmountAndConfirm")
	public void logoutFromNetBanking() {
		System.out.println("10. Logout from netbanking");
	}

}
