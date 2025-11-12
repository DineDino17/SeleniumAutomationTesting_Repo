package arrays;

import java.util.Arrays;

public class arrayExample {

	public static void main(String[] args) {
		arrayExample obj = new arrayExample();
		//obj.arrayValues();
		//obj.declareArray();
		//obj.largestNumber();
		//obj.secondLargestNum();
		//obj.reverseSortArray();
		//obj.maxValueOfTriplets();
		//obj.zerosAtEndOfArray();
		//obj.tempArray();
		//obj.reverseArrayInGroupOfSize();
		//obj.reverseArrayInGroupOfSizeNew();
		//obj.reverseArrayString();
		//obj.maxConsecutiveOnesOrZeros();
		obj.rotateArray();

	}
	public void arrayValues() {
		int[] number1 = new int[] {5,4,8,9};
		int[] number2 = new int[] {5,4,7,9};
		
		//Method 1
		if(number1.equals(number2)) {
			System.out.println("Both the arrays were same");
		}
		else {
			System.out.println("Arrays were different");
		}
		
		//Method 2
		for(int i=0; i<number1.length; i++) {
			if(number1[i] == number2[i] ) {
				System.out.println("Value is same");
			}
		}
		System.out.println("--------------------------------------------");
	}
	public void declareArray() {
		
		//Array starts with index 0
		//Size of array is fixed and we can't add more values than the given size. Here size is given as 5
		String[] name = new String[5];
		name[0]="Thor";
		name[1]="Steve";
		name[2]="Stark";
		name[3]="Hulk";
		name[4]="Natalie";
		//Below will throw Index 5 out of bounds for length 5 as we are trying to add 6th value
		//name[5]="Loki";
		
		//Here size is not declared but values of array was declared in the same line
		Integer[] marks = {91,87,56,45,63};
		//Below will throw Index 6 out of bounds for length 5 as we are trying to add new value for array which was declared already
		//Marks[6] = 60;
		
		String[] fruits;
		//This will throw error as size of array is fixed. We can't assign values in future without declaring the size
		//fruits = {"Apple","Grapes","Mango"};
		fruits = new String[3];
		fruits = new String[] {"Apple","Grapes","Mango"};
		
		Integer[] speed;
		speed = new Integer[] {100,200,150,220};
		
		//This will print the address of array which is address of fruits
		System.out.println("Directly trying to print Array: "+fruits); //[Ljava.lang.String;@24d46ca6
		//This will print the address of array which is address of fruits but as String
		System.out.println("Trying to print Array by coverting it to string: "+fruits.toString()); //[Ljava.lang.String;@24d46ca6
		//This will enter inside the address of array and print the values
		System.out.println("Deep to string fruits: "+Arrays.deepToString(fruits)); //[Apple, Grapes, Mango]
		System.out.println("Deep to string speed: "+Arrays.deepToString(speed)); //[100, 200, 150, 220]
		
		System.out.println("Length of Array is: "+name.length); //5
		//Prints value of Array
		System.out.println(Arrays.deepToString(name)); //[Thor, Steve, Stark, Hulk, Natalie]
		Arrays.sort(name);
		System.out.println(Arrays.deepToString(name)); //[Hulk, Natalie, Stark, Steve, Thor]
		
		
		//Prints value of Array 
		System.out.println(Arrays.toString(marks)); // This is enough to print 1 Dimensional array
		System.out.println(Arrays.deepToString(marks)); //[91,87,56,45,63]
		Arrays.sort(marks);
		System.out.println(Arrays.deepToString(marks)); //[45, 56, 63, 87, 91]
		//deepToString doesn't mean it'll convert the values to String
		System.out.println(marks[0]+marks[1]); //101
		
		//Printing the values using for loop
		for(int i=0;i<marks.length;i++) {
			Integer mark = marks[i];
			System.out.println("Value of "+i+" in marks is: "+mark);
		}
		/*
		Value of 0 in marks is: 45
		Value of 1 in marks is: 56
		Value of 2 in marks is: 63
		Value of 3 in marks is: 87
		Value of 4 in marks is: 91
		 */
		
	}
	
	//Method Over loading is used below
	public void customPrintArray(String[] Array) {
		//This is custom re-usable method to print String of 1 Dimensional Array
		for(int i=0;i<Array.length;i++) {
			System.out.println("Value of "+i+" in Array is: "+Array[i]);
		}
	}
	public void customPrintArray(Integer[] Array) {
		//This is custom re-usable method to print Integer of 1 Dimensional Array
		for(int i=0;i<Array.length;i++) {
			System.out.println("Value of "+i+" in Array is: "+Array[i]);
		}
	}
	public void largestNumber() {
		Integer[] numbers = {1,81,56,75,24};	
		Arrays.sort(numbers); //{1, 24, 56, 75, 81}
		customPrintArray(numbers);
		/*
	 	Value of 0 in Array is: 1
		Value of 1 in Array is: 24
		Value of 2 in Array is: 56
		Value of 3 in Array is: 75
		Value of 4 in Array is: 81
	    */
		System.out.println("Second largest number in numbers Arrays is: "+numbers[numbers.length-2]); //75
		
		//Finding the largest number in array by reading and storing the value one by one
		int[] newNumbers = {10, 50, 40, 60, 30, 5};
		int largestNum=newNumbers[0];
		for(int i=0; i<newNumbers.length;i++) {
			if(newNumbers[i]>largestNum) {
				largestNum = newNumbers[i];
			}
		}
		System.out.println("Largest number in newNumbers array is: "+largestNum); //60
	}
	
	public void secondLargestNum() {
		//Sorting an array in ascending
		Integer[] num = {20, 13, 96, 47, 15};	
		for(int i=0; i<num.length; i++) {
			for(int j=i+1;j<num.length;j++) {
				if(num[j]<num[i]) {
					int smallNum = num[j];
					num[j]=num[i];
					num[i]=smallNum;
				}
			}
			
		}
		System.out.println("Sorted Array in ascending: "+Arrays.deepToString(num));
		//Printing second largest number in array after sorting
		System.out.println("Second Largest Num in array is: "+num[num.length-2]);
	}
	public void reverseSortArray() {
		Integer[] num = {60,58,100,32,150};
		for(int i=0; i<num.length; i++) {
			for(int j=i+1; j<num.length; j++) {
				if(num[i]<num[j]) {
					int smallNum = num[i];
					num[i] = num[j];
					num[j] = smallNum;
				}
			}
		}
		System.out.println("Sorted Array in descending: "+Arrays.deepToString(num));
		int n = Integer.MIN_VALUE;
	}
	
	public void maxValueOfTriplets() {
		/*Input:  arr[ ] = [10, 3, 5, 6, 20]
		Output: 1200
		Explanation: Multiplication of 10, 6 and 20*/
		
		Integer[] arr = {10, 3, 5, 6, 20};
		Arrays.sort(arr);
		int maxValue = arr[arr.length-1]*arr[arr.length-2]*arr[arr.length-3];
		System.out.println("Max value of multiplication of 3 num in array is: "+maxValue);
	}
	public void zerosAtEndOfArray() {
		//Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
		//Output: [1, 2, 4, 3, 5, 0, 0, 0]
		Integer[] num = {10, 20, 0, 50, 0, 60, 0};
		//Arrays.sort(num);
		//System.out.println("Sorted Array with 0s: "+Arrays.deepToString(num));
		
		//Reverse sorted here 
		for(int i=0; i<num.length; i++) {
			//Directly we can use num[i]<num[j] in if condition
			int smallNum = num[i];
			for(int j=i+1;j<num.length;j++) {
				if(smallNum<num[j]) {
					int largeNum = num[j];
					num[j]=num[i];
					num[i]=largeNum;	
				}
			}
		}
		System.out.println("Sorted Array with 0s in reverse: "+Arrays.deepToString(num));
		//[60, 50, 20, 10, 0, 0, 0]
		
		Integer[] num1 = {10, 50, 0, 40, 0, 60, 0};
		//Arrays.sort(num1);
		//System.out.println("Sorted Array with 0s: "+Arrays.deepToString(num1));
		
		//Moved 0s at end without sorting
		for(int i=0; i<num1.length; i++) {
			for(int j=i+1;j<num1.length;j++) {
				if(num1[i].equals(0)) {
					int largeNum = num1[j];
					num1[j]=num1[i];
					num1[i]=largeNum;	
				}
			}
		}
		System.out.println("Sorted Array with 0s only in end: "+Arrays.deepToString(num1));
		//[10, 50, 40, 60, 0, 0, 0]
		

		/*
		{10, 50, 40, 0, 0, 60, 0};
					3  4
		{10, 50, 40, 0, 0, 60, 0};
		            3      5
		{10, 50, 40, 60, 0, 0, 0};  */
		
		
		Integer[] num2 = {10, 50, 0, 40, 0, 60, 0};
		//Arrays.sort(num2);
		//System.out.println("Sorted Array with 0s: "+Arrays.deepToString(num2));
		int length = num2.length-1;
		for(int i=length; i>=0; i--) {
			for(int j=i-1;j>=0;j--) {
				if(num2[i].equals(0)) {
					int largeNum = num2[j];
					num2[j]=num2[i];
					num2[i]=largeNum;	
				}
			}
		}
		System.out.println("Sorted Array with 0s only in front: "+Arrays.deepToString(num2));
		//[0, 0, 0, 10, 50, 40, 60]
		
	}
	public void tempArray() {
		
		//0s at end using temp array
		Integer[] num = {10, 50, 0, 40, 0, 60, 0};
		//Creating a temporary Array and storing the values from original array
		Integer[] tempArray = new Integer[num.length];
		//Storing numbers other than 0
		int j = 0;
		for(int i=0; i<num.length; i++) {
			if(!num[i].equals(0)) {
				tempArray[j]=num[i];
				j++;
			}
		}
		System.out.println("Values in tempArray without 0 is: "+Arrays.deepToString(tempArray));
		//Storing 0s where null is present. null is not a value so .equals cannot be used
		for(int i=0; i<num.length; i++) {
			if(tempArray[i]==null) {
				tempArray[i]=0;
			}
		}
		System.out.println("Values in tempArray with 0 is: "+Arrays.deepToString(tempArray));
		
		
		//Trying to keep the 0s first and then other numbers
		Integer[] newNum = {10, 50, 0, 40, 0, 60, 0};
		//Creating a temporary Array and storing the values from original array
		Integer[] tempArrayNew = new Integer[newNum.length];
		//Storing numbers 0
		int k = 0;
		for(int i=0; i<newNum.length; i++) {
			if(newNum[i].equals(0)) {
				tempArrayNew[k]=0;
				k++;
			}
		}
		System.out.println("Values in tempArray without num other than 0 is: "+Arrays.deepToString(tempArrayNew));
		
		
		//Storing other numbers where null is present. null is not a value so .equals cannot be used
		for(int i=0; i<newNum.length; i++) {
			if(!newNum[i].equals(0)) {
				//Value of k is already incremented in previous loop so value of k will be 3 now
				tempArrayNew[k]=newNum[i];
				k++;
			}
		}
		System.out.println("Values in tempArray with other numbers is: "+Arrays.deepToString(tempArrayNew));
		
	}
	public void reverseArrayInGroupOfSize() {
		/*
		Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8], k = 3
		Output: [3, 2, 1, 6, 5, 4, 8, 7]
		Explanation: Elements is reversed: [1, 2, 3] → [3, 2, 1], [4, 5, 6] → [6, 5, 4], and the last group [7, 8](size < 3) is reversed as [8, 7]. 

		Input: arr[] = [1, 2, 3, 4, 5], k = 3
		Output: [3, 2, 1, 5, 4]
		Explanation: First group consists of elements 1, 2, 3. Second group consists of 4, 5.

		Input: arr[] = [5, 6, 8, 9], k = 5
		Output: [9, 8, 6, 5]
		Explanation: Since k is greater than array size, the entire array is reversed.
		*/
		Integer[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//Integer[] num = {1, 2, 3, 4, 5};
		//Integer[] num = {5, 6, 8, 9};
		int k = 12;
		int lengthOfArray = num.length;
		int remainingNum = num.length%k;
		int noOfGroups = num.length/k;
		System.out.println("Length of array is: "+lengthOfArray);
		System.out.println("When k is "+k+" and array length is "+lengthOfArray+", "+remainingNum+" values will be remaining");
		System.out.println("When k is "+k+" and array length is "+lengthOfArray+", "+noOfGroups+" groups will be formed");
		
		int newGroup =0;
		for(int i=1; i<=noOfGroups; i++) {
			int group = i*k;	
			for(int j=newGroup; j<group;j++) {
			int temp = num[j];
			num[j]=num[group-1];
			num[group-1]=temp;
			group--;
			}
			newGroup=newGroup+k;
		}
		int leftNum = (k*noOfGroups)+remainingNum;
		int lastGroupNo = (noOfGroups*k);
		if(remainingNum>1) {
			for(int i=lastGroupNo;i<leftNum;i++) {
				int temp = num[i];
				num[i]=num[leftNum-1];
				num[leftNum-1]=temp;
				leftNum--;
			}
		}
		
		System.out.println("Final num array is: "+Arrays.deepToString(num));
		
	}
	
	public void reverseArrayInGroupOfSizeNew() {
		Integer[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		//Integer[] num = {1, 2, 3, 4, 5};
		//Integer[] num = {5, 6, 8, 9};
		int k = 4;
		int lengthOfArray = num.length;
		/*
		for(int i=0; i<lengthOfArray; i+=k) {
			int left = i;
			int right = (k+i)-1;
			while(left<right){
				if(right<lengthOfArray) {
				int temp = num[left];
				num[left] = num[right];
				num[right] = temp;
				left++;
				}
				right--;
			}
		}
		*/
		
		//Alternate way
		for(int i=0; i<lengthOfArray; i+=k) {
			int left = i;
			int right = Math.min((k+i)-1,lengthOfArray-1);
			while(left<right){
				int temp = num[left];
				num[left] = num[right];
				num[right] = temp;
				left++;
				right--;
			}
		}
		
		System.out.println("Final num array after reverse in group: "+Arrays.deepToString(num));
		
	}
	
	public void reverseArrayString(){
		
		String[] name = {"D","I","N","E","S","H"};
		
			int left = 0;
			int right = name.length-1;
			while(left<right) {
				String temp = name[left];
				name[left] = name[right];
				name[right] = temp;
				left++;
				right--;
			}
		System.out.println("Reverse of String Array: "+Arrays.deepToString(name));
	}
	
	public void maxConsecutiveOnesOrZeros(){
	
	/*
	Input: arr[] = [0, 1, 0, 1, 1, 1, 1]
	Output: 4
	Explanation: The maximum number of consecutive 1’s in the array is 4 from index 3-6.

	Input: arr[] = [0, 0, 1, 0, 1, 0]
	Output: 2
	Explanation: The maximum number of consecutive 0’s in the array is 2 from index 0-1.

	Input: arr[] = [0, 0, 0, 0]
	Output: 4
	Explanation: The maximum number of consecutive 0’s in the array is 4.
	 */
		Integer[] num = {0, 1, 0, 1, 1, 1, 1};
		//Integer[] num = {0, 0, 1, 0, 1, 0};
		//Integer[] num = {0, 0, 0, 0};
		int zeros = 0;
		int ones = 0;
		
		for(int i=0; i<num.length; i++) {
			int left = i;
			int right = Math.min(i+1, num.length-1);
			if(num[left] == num[right]){
				if(num[i].equals(0)) {
					zeros++;
				}
				else {
					ones++;
				}
			}
			
		}
		if(zeros>ones) {
		System.out.println("The maximum number of consecutive 0’s in the array is: "+zeros);
		}
		else {
		System.out.println("The maximum number of consecutive 1’s in the array is: "+ones);
		}
		
	}
	public void rotateArray() {
		/*Input: arr[] = {1, 2, 3, 4, 5, 6}, d = 2
				Output: {3, 4, 5, 6, 1, 2}
				Explanation: After first left rotation, arr[] becomes {2, 3, 4, 5, 6, 1} and after the second rotation, arr[] becomes {3, 4, 5, 6, 1, 2}

				Input: arr[] = {1, 2, 3}, d = 4
				Output: {2, 3, 1}
		*/
		
		//Integer[] num = {1, 2, 3, 4, 5, 6};
		Integer[] num = {1, 2, 3};
		int rotation = 4;
		
		//Rotate right to left
		for(int i=0; i<rotation; i++) {
			int rotateNum = num[0];
			for(int j=0; j<num.length; j++) {
				num[j] = num[Math.min(j+1, num.length-1)];
			}
			num[num.length-1] = rotateNum;
		}
		System.out.println("Array Rotation right to left: "+Arrays.deepToString(num));
		
		//Rotate left to right
		Integer[] numNew = {1, 2, 3, 4, 5, 6};
		int numNewRotation = 2;
		
		for(int i=0; i<numNewRotation; i++){
			int lastNum = numNew[numNew.length-1];
			for(int j=numNew.length-1; j>=0; j--) {	
				numNew[j] = numNew[Math.max(j-1, 0)];
			}
			numNew[0] = lastNum;
		}
		System.out.println("Array Rotation left to right: "+Arrays.deepToString(numNew));
		
		//Alternate way
		// Function to left rotate array by d positions
		int[] arr = { 1, 2, 3, 4, 5, 6 };
        int d = 2;
	    int n = arr.length;
	    // Repeat the rotation d times
	    for (int i = 0; i < d; i++) {
	        // Left rotate the array by one position
	        int first = arr[0];
	        for (int j = 0; j < n - 1; j++) {
	            arr[j] = arr[j + 1];
	            }
	            arr[n - 1] = first;
	        }
	        
	    for (int i = 0; i < arr.length; i++)
	        System.out.print(arr[i] + " ");
		
	}
	
	/*
	 * Not working
	for(int j=0; j<rotation; j++) {
	int lastNum = num[num.length-1];
	
	int left = Math.max(num.length-2,0);
	int right = Math.max(num.length-1,0);
	
	for(int i = 0; i<num.length; i++) {
		num[right] = num[left];
		left--;
		right--;
	}
	num[0]=lastNum;
	System.out.println("For rotation: "+Arrays.deepToString(num));
	}
	System.out.println("Rotated num: "+Arrays.deepToString(num)); */
	

			
}
