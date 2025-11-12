package testNGBasics;

import org.testng.annotations.Test;

public class FGroups {
	
	//We have Vivo, Samsung and Apple mobile with Functional, Regression and Sanity Group name
	//We also have Mobile name in Group name
	//ASCII order of groups will be collapsed when we have Priority, depends on Methods etc
	
	//We can either Include or Exclude the Group name under Group section in XML to run the methods
	//Exclude will suppress Include when we have no other like Priority, depends on Methods etc
	//As long as the depended method run, parent method always runs even when it is excluded
	
	//Depended method will always run at the end and not immediately when positive priority not used 
	/*
	 *  No priority set
	 	appleTest1  (forced to run at first)
		vivoTest1
		vivoTest2
		vivoTest4
		samsungTest1
		appleTest2  (runs later because of how TestNG ordered the remaining methods)
	 */
	//When positive priority used then both parent and depended method runs at end
	
	/*
	 * priority set for parent method
	    samsungTest1
		vivoTest1
		vivoTest2
		vivoTest4
		appleTest1  (priority=1)
		appleTest2  (runs later because of how TestNG ordered the remaining methods)
	 */
	
	/*
	 * Priority set for depended method
	 	Apple 1 in Regression and Sanity testing
		Samsung 1 in Functional testing
		Vivo 1 in Functional testing
		Vivo 2 in Functional testing
		Vivo 4 is Functional Testing
		Apple 2 in Functional and Sanity testing but depends on Apple 1(runs later because of how TestNG ordered the remaining methods)
	 */
	
	//As this method don't have any group name it won't run when we Include something to Run
	//This will run when we Exclude something to run because, Everything will run except excluded one.
	@Test
	public void realmeTest() {
		System.out.println("Realme test without any group");
	}
	@Test(groups= {"Vivo","Functional"})
	public void vivoTest1() {
		System.out.println("Vivo 1 in Functional testing");
	}
	@Test(groups= {"Vivo","Functional"})
	public void vivoTest2() {
		System.out.println("Vivo 2 in Functional testing");
	}
	//As long as the depended method run, it always runs
	@Test(groups= {"Regression"})
	public void vivoTest3() {
		System.out.println("Vivo 3 in Regression testing and with no Vivo group");
	}

	@Test(groups= {"Vivo","Functional"})
	public void vivoTest4() {
		System.out.println("Vivo 4 is Functional Testing");
	}
	@Test(groups= {"Samsung","Functional"})
	public void samsungTest1() {
		System.out.println("Samsung 1 in Functional testing");
	}
	@Test(groups= {"Samsung","Regression"})
	public void samsungTest2() {
		System.out.println("Samsung 2 in Regression testing");
	}
	@Test(priority=1, groups= {"Apple","Regression", "Sanity"})
	public void appleTest1() {
		System.out.println("Apple 1 in Regression and Sanity testing");
	}
	@Test(dependsOnMethods = "appleTest1",groups= {"Apple","Functional", "Sanity"})
	public void appleTest2() {
		System.out.println("Apple 2 in Functional and Sanity testing but depends on Apple 1");
	}
	

}
