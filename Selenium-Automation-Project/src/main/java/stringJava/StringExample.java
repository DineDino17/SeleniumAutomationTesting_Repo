package stringJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringExample {

	
	public static void main(String[] args) {
		
		StringExample obj = new StringExample();
		//obj.palindromeCheck();
		//obj.convertString();
		//obj.regexPattern();
		//obj.checkForRotation();
		//obj.checkCharIsPresentIn2DArray();
		//obj.firstNonRepeating();
		obj.romanCharToNum();
		//obj.removeVowels();
		//obj.reverseString();
		//obj.stringCounter();
		//obj.splitString();
		//obj.stringMethods();
	}
	public void palindromeCheck() {
		String name = "Malayalam";
		//String name1 = "Dinesh";
		String name1 = "Dinenid";
		
		/*
		for(int i=0; i<name.length(); i++) {
			int left = i;
			int right = (name.length()-1)-i;
			char leftChar = name.charAt(left);
			char rightChar = name.charAt(right);
			if(left<right) {
			if(String.valueOf(leftChar).equalsIgnoreCase(String.valueOf(rightChar))) {
				System.out.println("It is palindrome");
			}
			else {
				System.out.println("It is not a palidrome");
				break;
				}
			}
			else {
				break;
			}
		}
		*/
		
		int palindrome = 0;
		int left = 0;
		int right = name.length()-1;
		while(left < right) {
			if(! name.valueOf(name.charAt(left)).equalsIgnoreCase(name.valueOf(name.charAt(right)))) {
				palindrome = 1;
				break;
			}
			left++;
			right--;
		}
		if(palindrome == 0) {
			System.out.println("Given string is palindrome");
		}
		else {
			System.out.println("Given string is not a palindrome");
		}
		
		//Using String Builder
		StringBuilder sb = new StringBuilder(name1);
		String reversedString = sb.reverse().toString();
		if(name1.equalsIgnoreCase(reversedString)) {
			System.out.println("Name1 is Palindrome");
		}
		else {
			System.out.println("Name1 is not a Palindrome");
		}
		
	}
	public void convertString() {
		int num = 10;
		String value = String.valueOf(num);//Can be used for every data types
		System.out.println(value);
	}
	
	public void regexPattern() {
		
		//Converting string to regex pattern
		String input = "DineshKumar";
		String inputLowerCase = input.toLowerCase();
		
		String pattern = "aeiou";
		String regexPattern = "["+pattern+"]";
		System.out.println("Regex Name: "+regexPattern);
		//-------------------------------------------------------------------------------------------------//
		
		String removedRegexPattern = inputLowerCase.replaceAll(regexPattern, "");
		System.out.println("Removed regex pattern from input: "+removedRegexPattern);
		
		//Converting array to regex pattern
		char[] charArray = {'a','e','i','o','u'};
		String inputForCharArray = "DineshKumar";
		
		String charArrayToString = new String(charArray);
		System.out.println("Char array to string: "+charArrayToString);
		
		String charArrayRegexPattern = "["+charArrayToString+"]";
		System.out.println("Char array to string regex pattern: "+charArrayRegexPattern);
		
		String removedCharFromPattern = inputForCharArray.toLowerCase().replaceAll(charArrayRegexPattern, "");
		
		//-------------------------------------------------------------------------------------------------//
		if(removedCharFromPattern.isBlank()) {
			System.out.println("All input found in pattern");
		}
		else {
			System.out.println("Char not found in pattern is/are: "+removedCharFromPattern);
		}
		
		
		
		//Converting 2D array to regex pattern
		char[][] charArrayPattern = {{'a','e','i','o','u'},
				{'b','c','d','f'},
				{'j','k','l'}};
		String inputToCheck = "Dine";

		//Using for each loop to get the character in 2d array.
		StringBuilder sb = new StringBuilder("[");
		//Now sb has [

		for(char[] row : charArrayPattern) {
			for(char value: row) {
				sb.append(value);
			}
		}
		sb.append("]");
		String regexPatternOfCharArray = sb.toString();
		System.out.println("Regex pattern from given char pattern: "+sb);  	//[aeioubcdfjkl]

		//-------------------------------------------------------------------------------------------------//
		String replaceWithPattern = inputToCheck.toLowerCase().replaceAll(regexPatternOfCharArray, "");
		if(replaceWithPattern.isBlank()) {
			System.out.println("All characters present in given pattern");
		}
		else {
			System.out.println("These characters not present in given pattern: "+replaceWithPattern);
		}
		
	}
	
	public void removeVowels() {
		String name = "Dinesh";
		String vowelsRemoved = name.replaceAll("[AEIOUaeiou]", "");
		System.out.println("name after removing vowels: "+vowelsRemoved);
	}
	
	public void checkForRotation() {
		String input = "abcd";
		String output = "cdab";
		int rotation = 0;
		
		System.out.println("Substring "+input.substring(0, input.length()-1));
		
		for(int i=0; i<input.length(); i++) {
			
			char last = input.charAt(input.length()-1);
			input = last + input.substring(0,input.length()-1);
			
			rotation += 1;
			
			if(input.equals(output)) {
				System.out.println("Rotation needed: "+rotation);
				break;
			}
		}
	}
	
	public void checkCharIsPresentIn2DArray() {
		char[][] charArrayData = {{'a','e','i','o','u'},
						 {'b','c','d','f'},
						 {'j','k','l'}};
		
		String input = "Dine";
		for(int i=0; i<charArrayData.length; i++) {
			for(int j=0; j<charArrayData[i].length; j++) {
				char value = charArrayData[i][j];
				for(int k=0; k<input.length(); k++) {
					if(String.valueOf(input.charAt(k)).equalsIgnoreCase(String.valueOf(value))) {
						System.out.println("Value found in "+i+" array is "+value);
					}
				}
			}
		}
		//Alternative Way
		String newInput = "Dio";
		Set<Character> setOfCharArray = new HashSet<Character>();
		
		for(char[] rowsOfCharArray:charArrayData) {
			for(char valuesOfCharArray : rowsOfCharArray) {
				setOfCharArray.add(Character.toLowerCase(valuesOfCharArray));
			}
		}
		
		List<Character> charListOfNewInput = new ArrayList<Character>();
		char[] newInputCharArrray = newInput.toCharArray();
		for(char newInputValue : newInputCharArrray) {
			if(! setOfCharArray.contains(Character.toLowerCase(newInputValue))){
				charListOfNewInput.add(Character.toLowerCase(newInputValue));
			}
		}
		
		if(charListOfNewInput.isEmpty()) {
			System.out.println("All characters present in new input");
		}
		else {
			System.out.println("Characters were missing in new input");
		}
		
		//Using Regex Pattern
		char[][] charArrayPattern = {{'a','e','i','o','u'},
				 {'b','c','d','f'},
				 {'j','k','l'}};
		String inputToCheck = "Dine";
		
		//Using for each loop to get the character in 2d array.
		StringBuilder sb = new StringBuilder("[");
		//Now sb has [
		
		for(char[] row : charArrayPattern) {
			for(char value: row) {
				sb.append(value);
			}
		}
		sb.append("]");
		String regexPatternOfCharArray = sb.toString();
		System.out.println("Regex pattern from given char pattern: "+sb);  	//[aeioubcdfjkl]
		
		String replaceWithPattern = inputToCheck.toLowerCase().replaceAll(regexPatternOfCharArray, "");
		if(replaceWithPattern.isBlank()) {
			System.out.println("All characters present in given pattern");
		}
		else {
			System.out.println("These characters not present in given pattern: "+replaceWithPattern);
		}
		
		
	}
	
	public void firstNonRepeating() {
		/*input: s = "geeksforgeeks"
			Output: 'f'
			Explanation: 'f' is the first character in the string which does not repeat.	*/
		
		String input = "geeksforgeeks";
		//String input = "aabbaa";
		int length = input.length();
		int repeating = 0;
		
		for (int i = 0; i < length; ++i) {
			boolean found = false;

			for (int j = 0; j < length; ++j) {
				if (i != j && input.charAt(i) == input.charAt(j)) {
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("Not Found: "+input.charAt(i));
				break; //Use this if we want to find first non-repeating char
			}
			else {
				repeating += 1;
			}
		}
		if(repeating == length) {
			System.out.println("Repeating");
		}
		
		/*
		for(int i=0; i<length; i++) {
			String charInput = String.valueOf(input.charAt(i));
			int remInputIndex = Math.min(i+1, length-1);
			String remInput = input.substring(remInputIndex);
			if(!remInput.contains(charInput)) {
				System.out.println(charInput+" is the first character which does not repeat");
				break;
			}
			else {
				repeating += 1;
			}
		}
		if(repeating == length) {
			System.out.println("All characters repeating");
		}		*/
	}
	
	public void romanCharToNum() {
		
		/*
		Input: s = "IX"
		Output: 9
		Explanation: IX is a Roman symbol which represents 10 - 1 = 9

		Input: s = "XL"
		Output: 40
		Explanation: XL is a Roman symbol which represents 50 - 10 = 40

		Input: s = "MCMIV"
		Output: 1904
		Explanation: M is 1000, CM is 1000 - 100 = 900, and IV is 4. So we have total as 1000 + 900 + 4 = 1904
		
		*/

		String input = "XL";
		
		HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
		romanMap.put('I', 1);
		romanMap.put('V', 5);
		romanMap.put('X', 10);
		romanMap.put('L', 50);
		romanMap.put('C', 100);
		romanMap.put('D', 500);
		romanMap.put('M', 1000);
		
		int romanNumCalc = 0;
		
		if(input.length()>1) {
		for(int i=0; i<input.length(); i++) {
			
			char valuei = input.charAt(i);
			int endChar = Math.min(i+1, input.length()-1);
			char valuej = input.charAt(endChar);
			
			int romanIntValuei = romanMap.get(valuei);
			int romanIntValuej = romanMap.get(valuej);
			
			if(romanIntValuei > romanIntValuej && romanNumCalc == 0) {
				romanNumCalc += romanIntValuei;
			}
			else if(romanIntValuei < romanIntValuej) {
				int result = romanIntValuej - romanIntValuei;
				romanNumCalc = romanNumCalc + result;
			}
		}
		}
		else {
			romanNumCalc = romanMap.get(input.charAt(0));
		}
		
		System.out.println("Value of Roman character is: "+romanNumCalc);
	
	}
	
	public void convertStringToArray() {
		String name = "Dinesh";
		char[] nameCharArray = name.toCharArray();
		char singleChar = nameCharArray[0];
		String stringFromChar = ""+singleChar;
		
		System.out.println("Characted converted to string: "+stringFromChar);
		
		
		String[] nameArrayOld = {"a","b","c","d","d","d","",""};
		
		//This will create a new ArrayList and store the converted list here
		//This will help to work on list efficiently
		List<String> nameListNew = new ArrayList<String>(Arrays.asList(nameArrayOld));
		
	}
	public void reverseString() {
		String name = "Dinesh";
		int lengthOfName = name.length();
		String reversedName = "";
		
		for(int i =lengthOfName-1; i>=0; i--){
			String charfromName = ""+name.charAt(i);
			//This won't work as Strings are immutable
			reversedName.concat(charfromName);
			//This works
			reversedName = reversedName.concat(charfromName);
		}
		System.out.println("Reversed string: "+reversedName);
		
		String john = "John";
		//Using String Builder
		StringBuilder sb = new StringBuilder(john);
		sb.reverse();
		System.out.println("Reversed string using String Builder: "+sb);
		
	}
	public void stringCounter() {
		//Input: xxyyyrrrrrzzzz
		//Output:x2y3r5z4
		
		String input = "xxyyyrrrrrzzzz";
		String modInput = input.concat("@");
		int inputSize = modInput.length();
		int count = 1;
		String output = "";
		
		
		for(int i=1; i<inputSize; i++) {
			
			if(modInput.charAt(i-1) == modInput.charAt(i)) {				
				count += 1;
			}
			else{
				output = output+modInput.charAt(i-1)+count;
				count = 1;
			}
		}
		
		System.out.println("Output of String is: "+output);
	}
	public void splitString() {
		String sentence = "What in the world is this!!";
		String[] splitSentence = sentence.split(" ");
		String[] tempArray = new String[splitSentence.length];
		System.out.println("Splited string in array: "+Arrays.deepToString(splitSentence));
		
		int finalCount = splitSentence.length-1;
		
		for(int i=0; i<splitSentence.length; i++) {
			tempArray[finalCount] = splitSentence[i];
			finalCount--;
		}
		System.out.println("Reverse of splitSentence is: "+Arrays.deepToString(tempArray));
	}

	public void stringMethods() {
		String harryPotter = "Harry. Potter!!. game. boom";
		String[] splitSentence = harryPotter.split("[.]");
		System.out.println("Splited string in array: "+Arrays.deepToString(splitSentence));
		//Splited string in array: [Harry,  Potter!!,  game,  boom]
		
		String game1 = "FootBall";
		String game2 = "Cricket";
		String game3 = "FootBall";
		boolean result = game1.equals(game2);
		System.out.println("Equals method: "+result);	//Equals method: false
		System.out.println("Value of method: "+game3.valueOf("o"));
		
		
	}
}
