package testNGBasics;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class LThreadPoolSizeTimeouts {
	
	//This will run the same test for 3 time and 2 browsers will run in parallel
	@Test(invocationCount = 3, threadPoolSize = 2)
	public void testMethod1() {
		System.out.println("Test this method");
	}
	
	//This test should run within 1 second
	@Test(timeOut = 1000)
	public void testMethod2() {
		System.out.println("Test this method");
	}
	
	//This will ignore failure of test case when No such exception comes
	@Test(expectedExceptions = NoSuchElementException.class)
	public void testMethod3() {
		System.out.println("Test this method");
	}

}
