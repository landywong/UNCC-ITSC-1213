import java.util.ArrayList;

/**
 * TODO: Replace this paragraph with a one-sentence summary of what
 * the InsertionSort class does.
 *
 * TODO: Add a longer paragraph describing the algorithm in your own
 * words. (Hint: insertion sort builds the sorted portion of the list
 * one element at a time. For each element, it slides the larger
 * already-sorted elements one step to the right and drops the new
 * element into the gap.)
 *
 * @author  Landon Lwea
 * @version Tuesday, July 14, 2026
 */
public class InsertionSort extends BaseSorter<Integer> implements SortingAlgorithm<Integer> {

    /**
     * Sorts an array list using insertion method
     *
     * @param data is the list of integers beiing used
     * @return updated list now sorted
     */
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        // ====================================================================
        // STEP 1. Make a defensive copy of `data` so the caller's list is
        // not modified. The inherited copyList() helper from BaseSorter
        // does exactly this.
        //
        //     ArrayList<Integer> list = copyList(data);
        //
        // ====================================================================
        // STEP 2. Loop over every index `i` from 1 to list.size() - 1.
        //         (Index 0 is trivially "sorted" by itself.)
        //
        // For each `i`:
        //
        //   STEP 2a. Read the element at index i into a local variable
        //            named `key`. This is the element you are about to
        //            insert into the already-sorted prefix.
        //
        //   STEP 2b. Set `j = i - 1`.
        //
        //   STEP 2c. While `j >= 0` AND list.get(j) > key, slide the
        //            element at j one slot to the right (write it into
        //            j+1) and decrement j. (This is the "shift larger
        //            elements right to make a gap" step.)
        //
        //   STEP 2d. After the while loop ends, the gap is at index j+1.
        //            Place `key` there with list.set(j + 1, key).
        //
        // ====================================================================
        // STEP 3. Return the sorted list.
        //
        // ====================================================================
        // Once you have implemented the body, also do the to-do in
        // Main.java: add `algorithms.add(new InsertionSort());` so the
        // driver actually runs your sort.

        ArrayList<Integer> list = copyList(data);
        int n = list.size();
        for (int i = 1; i < n; i++) {
            int key = list.get(i);
            int j = i - 1;
            // Shift elements of the sorted portion that are greater than key
            // one position to the right
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
        return list;
    }

    /**
     * Prints type of sorting method
     * @return Insertion Sort
     */
    @Override
    public String getName() {
        return "Insertion Sort";
    }
}
