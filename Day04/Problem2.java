import java.util.Scanner;

public class Problem2 {

        // Display "odd" if the given integer n is odd, or "even" otherwise.
        public static void main(String[] args) {

            // set up Scanner to capture user input
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();

            // Add code here
            // if statement to calculate whether int is even or odd
            if (n % 2 == 0) {
                System.out.println("even");
            } else if (n % 2 != 0) {
                System.out.println("odd");
            } else {
                System.out.println("ERROR");
            }

        }//end main

}//end class

