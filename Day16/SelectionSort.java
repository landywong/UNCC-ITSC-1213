import java.util.ArrayList;

/**
 * Interface for sorting algorithms.
 * <p>
 * Implementing classes must provide a method to sort a list of comparable elements,
 * and a method to return the name of the algorithm.
 */
public class SelectionSort extends BaseSorter<Integer> implements SortingAlgorithm<Integer> {

    /**
     * Sorts the provided ArrayList using Selection Sort.
     * @param data The list of integers to be sorted.
     * @return A new sorted ArrayList of integers.
     */
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        ArrayList<Integer> list = copyList(data);
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the index of the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            // Swap the found minimum with the first element of the unsorted part
            int temp = list.get(minIndex);
            list.set(minIndex, list.get(i));
            list.set(i, temp);
        }
        
        return list;
    }

    /**
     * Returns the name of the sorting algorithm.
     * @return A string representing the name of the algorithm.
     */
    @Override
    public String getName() {
        return "Selection Sort";
    }
}