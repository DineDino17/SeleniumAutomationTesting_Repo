package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClass {

	public static void main(String[] args) {
		
		
		/*
		 * 	6,9,1,5,6,4,4,1,10
			smallest Integer - 1
			Position - 8
		 
		 * 	Formatted Array - 6,9,a,5,6,4,4,10,2
			smallest Integer - 6
			Position - 1
 
			Formatted Array - 6,9,2,a,6,4,4,10,2
			smallest Integer - 2
			Position - 3
 
		 */
		
		/*
		//Integer[] num = {6,9,1,5,6,4,4,1,10};
		String value = "a";
		Integer newNum = Integer.parseInt(value);
		
		Integer[] num = {6,9,1,newNum,6,4,4,1,10};
		
		int smallestNum = num[0];
		for(int i=0; i<num.length; i++) {
			try {
				
			if(num[i]<smallestNum) {
				smallestNum = num[i];
				}
				
			}
			catch(Exception e) {
				System.out.println("Iteration broke due to: "+e);
			}
		}
		List<Integer> numList = Arrays.asList(num);
		System.out.println("Position of smallest num is: "+numList.lastIndexOf(smallestNum));
		System.out.println("Smallest Integer in array is: "+smallestNum);
		*/
		
		/*
		List newNumList = new ArrayList();
		
		newNumList.add(6);
		newNumList.add(9);
		newNumList.add(1);
		newNumList.add("a");
		newNumList.add(6);
		newNumList.add(4);
		newNumList.add(4);
		newNumList.add(1);
		newNumList.add(10);
		
		System.out.println("New num list has: "+newNumList);
		
		int count = 0;
		int smallNumlist = (int) newNumList.get(0);
		int smallNumFromException = (int) newNumList.get(0);
		
		for(int i=0; i<newNumList.size(); i++) {
			try {
				
			if((int)newNumList.get(i)  < smallNumlist) {
				smallNumlist = (int)newNumList.get(i);
				}
				count++;
			}
			catch(Exception e) {
				
				System.out.println("Iteration broke due to: "+e);
				newNumList.indexOf(i);
				
				for(int j=0; j<=count; j++) {
					
					if((int)newNumList.get(j)  < smallNumFromException) {
						
						smallNumFromException = (int)newNumList.get(j);
						}
					System.out.println("Smallest Integer in array is: "+smallNumFromException);
					System.out.println("Position of smallest num is: "+newNumList.indexOf(smallNumFromException));
				}
			}
		}
		
		
		if(count = ) {
	
		System.out.println("Position of smallest num is: "+newNumList.lastIndexOf(smallNumlist));
		System.out.println("Smallest Integer in array is: "+smallNumlist);
		}			*/
		
		String input = ("6,9,1,5,6,4,4,1,10");
		
		String[] parts = input.split(",");
		System.out.println("String array by split: "+Arrays.deepToString(parts));
		
		int smallestNum = Integer.MAX_VALUE;
		int position = -1;
		
		for(int i=0; i<parts.length; i++) {
			String value = parts[i];
			try {
				int num = Integer.parseInt(value);
				if(num<= smallestNum) {
					smallestNum = num;
					position = i+1;
				}
			}
			catch(Exception e) {
				break;
			}
		}
		
		if (position != -1) {
            System.out.println("Input: " + input);
            System.out.println("Smallest Integer is: " + smallestNum);
            System.out.println("Position is: " + position);
            System.out.println();
        } else {
            System.out.println("Input: " + input);
            System.out.println("No valid integers before invalid input.");
            System.out.println();
        }

	}			


}
