import java.util.ArrayList;

/**
 * Main class to demonstrate and compare sorting algorithms.
 *
 * @author Denis Jacob Machado (ITSC-1213, Summer 2026)
 */
public class Main {

    /**
     * Entry point to the program. Generates input data and runs each
     * sorting algorithm against the same input, then prints the
     * algorithm name, the original list, the sorted list, and the
     * elapsed time in nanoseconds.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        ArrayList<Integer> input = ArrayGenerator.generate(10, 100);

        ArrayList<SortingAlgorithm<Integer>> algorithms = new ArrayList<>();
        algorithms.add(new BubbleSort());
        algorithms.add(new InsertionSort());
        algorithms.add(new SelectionSort());
        algorithms.add(new QuickSort());

        // Iterate through all sorting algorithms and test each one.
        for (SortingAlgorithm<Integer> algo : algorithms) {
            System.out.println("=== New Sorting Algorithm ===\n");
            ArrayList<Integer> inputCopy = new ArrayList<>(input);
            long start = System.nanoTime();
            ArrayList<Integer> sorted = algo.sort(inputCopy);
            long end = System.nanoTime();
            ResultPrinter.print(algo, input, sorted, end - start);
        }
    }
}
