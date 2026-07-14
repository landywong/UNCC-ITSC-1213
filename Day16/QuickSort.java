import java.util.ArrayList;

/**
 * The QuickSort class implements the quick sort algorithm.
 * It uses a divide-and-conquer strategy by selecting a pivot
 * and partitioning the list into two sublists that are then recursively sorted.
 */
public class QuickSort extends BaseSorter<Integer> implements SortingAlgorithm<Integer> {

    /**
     * Sorts the provided ArrayList using Quick Sort.
     * @param data The list of integers to be sorted.
     * @return A new sorted ArrayList of integers.
     */
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        ArrayList<Integer> list = copyList(data);
        // Recursively sort elements before and after partition
        quickSort(list, 0, list.size() - 1);
        return list;
    }

    /**
     * Recursive Quick Sort algorithm.
     * @param list The list to sort.
     * @param low The starting index.
     * @param high The ending index.
     */
    private void quickSort(ArrayList<Integer> list, int low, int high) {
        if (low < high) {
            // Rearranging elements smaller than the pivot to the left
            int pi = partition(list, low, high);
            // Recursively sort elements before and after partition
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    /**
     * Partitions the list and returns the pivot index.
     * @param list The list to partition.
     * @param low The starting index.
     * @param high The ending index.
     * @return The index of the pivot.
     */
    private int partition(ArrayList<Integer> list, int low, int high) {
        // Place elements smaller than pivot to the left of the pivot
        // and larger elements to the right
        int pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j) <= pivot) {
                i++;
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        int temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    /**
     * Returns the name of the sorting algorithm.
     * @return A string representing the name of the algorithm.
     */
    @Override
    public String getName() {
        return "Quick Sort";
    }
}