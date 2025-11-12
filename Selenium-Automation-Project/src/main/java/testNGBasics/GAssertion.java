package testNGBasics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GAssertion {
	
	//Assertion is like If else statements in TestNG
	//This is used for simple checks in our code
	@Test
	public void assertionExample() {
	String name1 = "Dine";
	boolean result = false;
	
	if(name1.equals("Dine")) {
		System.out.println("Print true");
	}
	else {
		System.out.println("Print false");
	}
	
	Assert.assertEquals(name1, "Dino");		//AssertionError: expected [Dino] but found [Dine]
	Assert.assertNotEquals(name1, "Dino");	//No Error
	
	Assert.assertTrue(result);		//expected [true] but found [false]
	
	}

}
