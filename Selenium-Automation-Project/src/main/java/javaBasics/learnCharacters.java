package javaBasics;


public class learnCharacters {

	public static void main(String[] args) {
		char c1 = 'A';
		char c2 = 65;
		char c3 = '\u0041';
		System.out.println("C1 is "+c1);
		System.out.println("C2 is "+c2);
		System.out.println("C3 is "+c3);
		
		String s1 = "First Name";
		String s2 = "";
		String s3 = " ";
		String s4 = "A B";
		
		System.out.println(s1.charAt(0));
		System.out.println("At index is "+s1.charAt(5
				));
	}

}
