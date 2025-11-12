
package javaBasics;

public class StaticVariable {

	int x;
	static int y;
	static String name1 = "Dine";
	static String name2 = "Dine";
	static String name3 = new String("Don");
	static String name4 = new String("Alan");
	String name5 = new String("King");
	//StaticVariable printVar = new StaticVariable();
	
	public static void main(String[] args) {
		//Static variable stores values but Non-Static variable restarts every time on it's run
		StaticVariable printVar = new StaticVariable();
		printVar.printStaticandNonStatic();
		printVar.printStaticandNonStatic();
		StaticVariable printVar1 = new StaticVariable();
		printVar1.printStaticandNonStatic();
		printVar1.printStaticandNonStatic();
		
		StaticVariable obj1 = new StaticVariable();
		obj1.instanceMethod();
		StaticVariable obj2 = new StaticVariable();
		obj2.instanceMethod1();
		
		String name5 = new String("Kong");
		System.out.println("main method String: "+name5);
	}
	
	public void printStaticandNonStatic() {
		x++;
		y++;
		System.out.println("Non-Static is "+x+" Static is "+y);
	}
	public void instanceMethod() {
		StaticVariable.name1="Dino";
		System.out.println("Instance Method name1: "+name1);
		System.out.println("Instance Method name2: "+name2);
	}
	public void instanceMethod1() {
		System.out.println("Instance Method1 name1: "+name1);
		System.out.println("Instance Method1 name2: "+name2);
		
	}

}
