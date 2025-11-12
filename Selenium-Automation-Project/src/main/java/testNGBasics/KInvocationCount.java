package testNGBasics;

import org.testng.annotations.Test;

public class KInvocationCount {
	
	//Runs same test multiple times for the given count
	//When Invocation count is 3, Test will run for 3 times
	//When Invocation Timeout is 2000, then all the 3 test should complete within 2 seconds
	@Test(invocationCount = 3, invocationTimeOut = 2000)
	public void testMethod1() {
		System.out.println("Test this method");
	}

}
