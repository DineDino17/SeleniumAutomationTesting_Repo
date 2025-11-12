package javaBasics;

public class StringBufferExample {
	
	
	public static void main(String[] args) {
		
		//String, StringBuffer and StringBuilder were the child of CharSequence
		//Difference between String and StringBuffer
		
		//Using String literal
		String firstName = "Dine";
		System.out.println("First name before concating is: "+firstName);
		System.out.println("First name during concating is: "+firstName.concat("Dino"));
		//String fullName = firstName.concat("Dino");
		//System.out.println("New name after concating is: "+fullName);
		System.out.println("First name won't change after concating as String is Immutable: "+firstName);
		firstName.length();
		
		
		
		//StringBuffer is synchronized/Thread safe which means one user per time can access this
		//Using new Keyword and literal is not possible here
		StringBuffer name = new StringBuffer("Dine");
		System.out.println("Name before appending is: "+name);
		System.out.println("Name during appending is: "+name.append("Dino"));
		System.out.println("Name will change after appending as String Buffer is Mutable: "+name);
		
		
		System.out.println("------------------------------------------------------------");
		
		//StringBuffer Methods
		//Reverse --- String don't have any method to reverse string
		System.out.println("Reversing StringBuffer: "+name.reverse());
		System.out.println("------------------------------------------------------------");
		
		System.out.println("Length of StringBuffer: "+name.length());
		System.out.println("------------------------------------------------------------");
		System.out.println("Reversing StringBuffer: "+name.reverse());
		System.out.println("------------------------------------------------------------");
		System.out.println("Replacing StringBuffer: "+name.replace(0, 4, "Dino-"));
		System.out.println("------------------------------------------------------------");
		System.out.println("Deleting StringBuffer: "+name.delete(0, 5));
		System.out.println("------------------------------------------------------------");
		System.out.println("Inserting StringBuffer: "+name.insert(2,"Dine"));
		System.out.println("------------------------------------------------------------");
		System.out.println("Capacity of StringBuffer: "+name.capacity());
		
		
		//StringBuilder is Non synchronized/Not Thread safe which means many user per time can access this
		//Other than the above difference StringBuilder and StringBuffer are same and has same methods
		//Using new Keyword and literal is not possible here
		StringBuilder newName = new StringBuilder("Bond");
		System.out.println("Name before appending is: "+newName);
		System.out.println("Name during appending is: "+newName.append("Dino"));
		System.out.println("Name will change after appending as String Buffer is Mutable: "+newName);
	}
	

}
