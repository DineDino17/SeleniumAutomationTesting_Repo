package javaBasics;

public class DataTypes {
	//Instance variables returns default values
	int a;
	boolean boo;
	float flo;

	public static void main(String[] args) {
		//When method is static
		//Object and class name is not needed when both method is in same class but we can use it if we want
		staticMethod();
		DataTypes.staticMethod();
		DataTypes testing = new DataTypes();
		testing.helloMethod();
		//String printHello = testing.helloMethod();
		//System.out.println(printHello);
		testing.dataTypesMethod();
		testing.testThis();

	}
	public void dataTypesMethod() {
		DataTypes testNormalMethod = new DataTypes();
		testNormalMethod.helloMethod();
		DataTypes.staticMethod();
		staticMethod();
		byte eightBitsMin128To127 = 127;
		short sixteenBitsMin32768To32767 = 32767;
		int thirtyTwoBitsMin2147483648To2147483647 = 2147483647;
		long sixtyFourBitsMin9223372036854775808To9223372036854775807 = 9223372036854775807l;
		float thirtyTwoBitsUpto7Decimal = 2.55f;
		double sixtyFourBitsUpto16Decimal = 8.562148552123336655555;
		System.out.println("This is from data types method");
		
	}
	public String helloMethod() {
		System.out.println("This is from hello method");
		return "World";
	}
	
	public static void staticMethod() {
		System.out.println("This is from static method");
	}
	public static void staticMethod1() {
		System.out.println("This is from static method1");
	}
	public void testThis() {
		System.out.println(a);
		System.out.println(boo);
		System.out.println(flo);
	}
}

