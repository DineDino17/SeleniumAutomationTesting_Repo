package javaBasics;

import java.util.Arrays;

public class ArraysExample {

	public static void main(String[] args) {
		ArraysExample printArray = new ArraysExample();
		printArray.arrayReverse();
		//printArray.subjectArray();
		printArray.numberArray();
		

	}
	public void arrayReverse() {
    	int[] num = {1,5,8,6,9};
    	//This won't return exact values from array instead it returns garbage values
    	//System.out.println("Array of num is: "+num);
    	int reverseNum = 0;
    	//System.out.println("Array of reverse num is: "+reverseNum);
    	int[] reverseNumArray = new int[num.length];
    	
    	for(int i=1;i<(num.length+1);i++) {
    		int position = num.length-i;
    		reverseNum = num[position];
    		System.out.println("Array of reverse num is: "+reverseNum);
    		
    		//int[] reverseNumArray = new int[num.length];
    		reverseNumArray[i-1]=reverseNum;
    		System.out.println("Array of reverse num stored is: "+reverseNumArray[i-1]);
    		if(position == 0) {
    			break;
    		}
    	}
    		
    	for (int i=0;i<reverseNumArray.length;i++) {
    		System.out.println("Array of reverse num stored value is: "+reverseNumArray[i]);
    		if((reverseNumArray.length-i) == 0) {
    			break;
    		}
    	}	
    }
	public void subjectArray() {
		String subject[]= {"English","Tamil","Maths","Science","Social"};
		System.out.println("First value of array is "+subject[0]);
		System.out.println("Length of array is "+subject.length);
		System.out.println("Last value of array is "+subject[subject.length-1]);
		//Gives unreadable value so change the array to string
		System.out.println(subject);
		System.out.println("List of all subjects were "+Arrays.toString(subject));
	}
	public void numberArray() {
		int marks[] = new int [5];
		marks[0] = 96;
		marks[1] = 91;
		marks[2] = 90;
		marks[3] = 100;
		marks[4] = 100;
		System.out.println(marks);
		System.out.println("Marks for all subjects were "+Arrays.toString(marks));
	}
}
