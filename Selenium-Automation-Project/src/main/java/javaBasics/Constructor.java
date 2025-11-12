package javaBasics;

public class Constructor {
	
	int x;
	int y;
	String name;
	
	//Below is example of setting constant value
	/*public Constructor() {
		this.x =100;
	}*/

	//Below is the example of getting value from main method
	
	public Constructor(int a, int b) {
		this.x = a;
		this.y = b;
	}
	//Constructor overloading
	public Constructor(String s) {
			this.name = s;
		}
	
	public static void main(String[] args) {
		//value passed to int a and int b
		Constructor setValue = new Constructor(150,200);
		//value passed to int x and int y for method
		setValue.changeInstanceVar(400,500);
		//value passed to String s
		Constructor setValueString = new Constructor("DineCons");
		//value passed to String name for method
		setValueString.changeInstanceVar("Dino");
	}
	//Method overloading
	public void changeInstanceVar(int x,int y) {
		System.out.println("Instance variable value of x changed using constructor by "+this.x);
		System.out.println("Instance variable value of y changed using constructor by "+this.y);
	}
	public void changeInstanceVar(String name) {
		System.out.println("Instance variable value of name changed using constructor by "+this.name);
	}
	
}
