import java.util.ArrayList;

/**
 * The ResultPrinter class provides a static method to display the results
 * of a sorting algorithm, including its name, the original input list,
 * and the sorted output.
 * 
 * @author Denis Jacob Machado (ITSC-1213, Summer 2025)
 */
public class ResultPrinter {

    /**
    * Prints the algorithm name, input, and sorted output with timing.
    * @param algorithm The sorting algorithm used.
    * @param original The original input list.
    * @param sorted The sorted output list.
    * @param timeInNs Time taken in nanoseconds.
    */
    public static void print(SortingAlgorithm<Integer> algorithm, ArrayList<Integer> original, ArrayList<Integer> sorted, long timeInNs) {
        System.out.println("Algorithm: " + algorithm.getName());
        System.out.println("Original:  " + original);
        System.out.println("Sorted:    " + sorted);
        System.out.println("Time (ns): " + timeInNs);
        System.out.println("------------------------------");
    }
    
    public static void print(SortingAlgorithm<Integer> algorithm, ArrayList<Integer> original, ArrayList<Integer> sorted) {
        print(algorithm, original, sorted, 0);
    }
    
    /**
    * Constructs a ResultPrinter. (No internal state)
    */
    public ResultPrinter() {}
    
}