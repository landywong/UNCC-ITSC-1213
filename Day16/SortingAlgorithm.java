import java.util.ArrayList;

/**
 * A generic interface that defines the structure for sorting algorithms.
 * 
 * @param <T> The type of elements to be sorted, must be Comparable.
 * 
 * @author Denis Jacob Machado (ITSC-1213, Summer 2025)
 */
public interface SortingAlgorithm<T extends Comparable<T>> {

    /**
    * Sorts the provided ArrayList of integers.
    * Implementations should not modify the original input list.
    * @param data The list of integers to be sorted.
    * @return A new sorted ArrayList of integers.
    */
    ArrayList<T> sort(ArrayList<T> data);

    /**
     * Returns the name of the sorting algorithm.
     * @return A string representing the name of the algorithm.
     */
    String getName();
}