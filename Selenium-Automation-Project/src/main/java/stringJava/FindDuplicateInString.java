package stringJava;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInString {

	public static void main(String[] args) {
		String name = "DineshDino";
		if(findDuplicate(name)) {
			System.out.println("No duplicates found");
		}
		else {
			System.out.println("Duplicate found");
		}
 
	}
	
	public static boolean findDuplicate(String input) {
		
		Set<Character> set = new HashSet<Character>();
		
		char[] charInput = input.toCharArray();
		for(char c: charInput) {
			if(set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}

}
