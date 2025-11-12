package javaBasics;

public class CallMethods {

	int a;
	static int b;
	String alpha;
	public static void main(String[] args) {
		//When method is static
		//Object and class name is not needed when both method is in same class but we can use it if we want
		//Object is not needed when both method is in different class but we need to use class name
		DataTypes testObjName = new DataTypes();
		testObjName.dataTypesMethod();
		testObjName.helloMethod();
		DataTypes.staticMethod();
		staticMethod();
		CallMethods testInsideCallClass = new CallMethods();
		testInsideCallClass.diffMethod();
	}
	public void diffMethod() {
		//Same object name can be created in different methods but not on same method
		DataTypes testObjName = new DataTypes();
		testObjName.helloMethod();
		DataTypes.staticMethod1();
	}
	public static void staticMethod() {
		String s1 = "Dine";
		String s2 = new String("Dine");
		String s3 = new String("Dine");
		//Instance variable value set by constructor which is created by default class. Static also refers class so it'll conflict.
		//Cannot make a static reference(Method) to the non-static(Variable) field a 
		//System.out.println(a);
		//Cannot use this in a static context
		//System.out.println(this.alpha);
		System.out.println(b);
	}

}
