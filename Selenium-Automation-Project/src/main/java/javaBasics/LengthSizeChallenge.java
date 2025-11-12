package javaBasics;
import java.util.*;

public class LengthSizeChallenge {
    public static void main(String[] args) {
    	LengthSizeChallenge testObj = new LengthSizeChallenge();
    	testObj.arrayReverse();
    	//listAndSize();
    }
    
    public void arrayReverse() {
    	int[] num = {1,5,8,6,9};
    	//This won't return exact values from array instead it returns address of array
    	System.out.println("Array of num is: "+num);
    }
    public static void listAndSize(){
    	// Part 1: Array
        int[] numbers = {5, 10, 15, 20, 25};
        System.out.println("Array length: " + numbers.length);

        // Part 2: String
        String message = "LengthVsSize";
        System.out.println("String length: " + message.length());

        // Part 3: ArrayList
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Mango");
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Grape");
        System.out.println("ArrayList size: " + fruits.size());

        // Part 4: 2D Array
        int[][] grid = new int[4][3];
        System.out.println("2D Array rows: " + grid.length);
        System.out.println("2D Array columns: " + grid[0].length);
    }
}


