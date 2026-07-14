import java.util.ArrayList;

/**
 * the Bubble sort class sorts the numbers in an array by swaping items side by side
 *
 * The bubble sort functions by scanning items in a array from left to right, after selecting
 * the first item, it compares it to the next swaping position if out of place. This process
 * repeats until all items are sorted
 *
 * TODO: Fill in the @author tag with your name and the @version tag
 * with today's date.
 *
 * @author  Landon Lwea
 * @version Tuesday, July 14, 2026
 */
public class BubbleSort extends BaseSorter<Integer> implements SortingAlgorithm<Integer> {

    /**
     * Method to bubble sort an array list
     *
     * @param data is the list of integers in an array
     * @return an updated list now sorted
     */
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        // ====================================================================
        // The lines BELOW this banner are SHUFFLED on purpose. They are
        // exactly the lines a correct Bubble Sort needs -- but in the wrong
        // order. Reorder them so that the method:
        //
        //   1) makes a defensive copy of the input list,
        //   2) loops `n - 1` times, each pass setting `swapped = false` first,
        //   3) on each pass, walks j from 0 up to (but not including) n-1-i,
        //      swapping the j and j+1 elements when they are out of order
        //      and setting swapped = true,
        //   4) breaks out of the outer loop early when no swap happened on
        //      a pass (the list is already sorted),
        //   5) returns the sorted list.
        //
        // After you reorder them, the method should compile and produce a
        // correctly sorted ArrayList. Test by running Main and checking
        // that the "Sorted" line is in non-decreasing order.
        // ====================================================================

        boolean swapped;
        ArrayList<Integer> list = copyList(data);
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return list;
    }

    /**
     * Prints out name of sorting method
     * @return Bubble Sort
     */
    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
