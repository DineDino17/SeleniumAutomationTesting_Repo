package arrays;


public class TwoDimensionalArray {
    public static void main(String[] args) {

        // Create a 2D array (3 rows, 3 columns)
        int[][] numbers = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Iterate using nested for loops
        System.out.println("Using normal for loop:");
        for (int i = 0; i < numbers.length; i++) {               // Rows
            for (int j = 0; j < numbers[i].length; j++) {        // Columns
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println(); // Move to next line after each row
        }

        // Iterate using enhanced for loop
        System.out.println("\nUsing enhanced for loop:");
        for (int[] row : numbers) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
