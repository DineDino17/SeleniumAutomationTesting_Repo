package javaBasics;

public class MethodOverloading {

	int a;
	String alpha;
	String name = new String("John");
	//name = "Don";
	static int b =50;
	
	
	boolean tryBooMethod() {
		return true;
	}
	
	public static void main(String[] args) {
		MethodOverloading objName = new MethodOverloading();
		objName.stringDine("Dino");
		objName.stringDine("Dino", 10);
		objName.stringDine(10);
		objName.stringDine((Integer)10);
		System.out.println(objName.a);
		System.out.println(b);
	}
	private void stringDine(String name) {
		int a=17;
		String myName = name;
		System.out.println(myName+" "+a);
		//Use this if variable name is same and wanted to use instance variable instead of local variable
		System.out.println(myName+" "+this.a);
	}
	private void stringDine(String name, int num) {
		String myName = name;
		System.out.println(myName+num+alpha);
	}
	private void stringDine(int num) {
		int num1 = num;
		int a = 0;
		System.out.println(a);
		System.out.println(num1+" "+this.tryBooMethod());
		//System.out.println(num1+this.a);
	}
	private void stringDine(Integer num) {
		int num1 = num;
		System.out.println(num1+" "+this.tryBooMethod());
		//System.out.println(num1+this.a);
	}
	
	
	}
