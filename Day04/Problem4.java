import java.util.Scanner;

public class Problem4 {

    /*
     * Calculates final weekly pay given hours worked and hourly wage,
     * paying time-and-a-half for any hours > 40.
     *
     */
    public static void main(String[] args) {

        // set up Scanner to capture user input
        Scanner input = new Scanner(System.in);
        int hours = input.nextInt();
        double wage = input.nextDouble();
        // Add code here
        // calculate worker pay
        double pay = 0;

        // determine if hour > 40 (time and a half) or < 40
        if (hours <= 40) {
            // normal pay
            pay = hours * wage;
            System.out.println(pay);
        } else if (hours > 40) {
            // time and a half pay
            double extra = (hours - 40) * wage * 1.5;
            pay = 40 * wage;
            pay = pay + extra;
            System.out.println(pay);
        }

    }// end main

}// end class
