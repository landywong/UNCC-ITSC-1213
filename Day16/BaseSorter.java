import java.util.ArrayList;

/**
 * Abstract base class for sorting algorithms.
 * Provides shared utility methods and enforces implementation of the SortingAlgorithm interface.
 * 
 * @param <T> The type of elements that this sorter can sort. Must implement Comparable.
 */
public abstract class BaseSorter<T extends Comparable<T>> implements SortingAlgorithm<T> {

    /**
     * Creates and returns a deep copy of the input list to avoid modifying the original list.
     * @param original The original ArrayList of integers.
     * @return A copy of the original list.
     */
    protected ArrayList<T> copyList(ArrayList<T> original) {
        return new ArrayList<>(original);
    }
}