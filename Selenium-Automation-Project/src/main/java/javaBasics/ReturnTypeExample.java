package javaBasics;

public class ReturnTypeExample {

	public static void main(String[] args) {
		
		ReturnTypeExample obj = new ReturnTypeExample();
		obj.additionMethod();
		System.out.println("Value of multiply is: "+obj.multiplyMethod());
		System.out.println("Value of subtraction is: "+subtractionMethod());
	}
	
	public void additionMethod() {
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println("Value of addition is: "+c);
	}
	public int multiplyMethod() {
		int a = 10;
		int b = 20;
		int c = a*b;
		return c;
	}
	public static int subtractionMethod() {
		int a = 10;
		int b = 20;
		int c = b-a;
		return c;
	}

}
