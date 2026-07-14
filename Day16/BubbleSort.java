import java.util.ArrayList;

/**
 * TODO: Replace this paragraph with a one-sentence summary of what
 * the BubbleSort class does.
 *
 * TODO: Add a longer paragraph describing the algorithm in your own
 * words. (Hint: see the line-by-line plain-English explanation you
 * will write in BubbleSort_Explanation.md and copy the high-level
 * idea here.)
 *
 * TODO: Fill in the @author tag with your name and the @version tag
 * with today's date.
 *
 * @author  TODO Your Name
 * @version TODO Tuesday, July 14, 2026
 */
public class BubbleSort extends BaseSorter<Integer> implements SortingAlgorithm<Integer> {

    /**
     * TODO: Write a one-sentence purpose statement for the sort()
     * method here. The first sentence becomes the method's summary
     * in the generated Javadoc.
     *
     * TODO: Add an @param tag describing the input.
     * TODO: Add an @return tag describing what comes back.
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

        if (!swapped) break;
        ArrayList<Integer> list = copyList(data);
        return list;
        for (int j = 0; j < n - 1 - i; j++) {
        if (list.get(j) > list.get(j + 1)) {
        boolean swapped;
        }
        list.set(j + 1, temp);
        for (int i = 0; i < n - 1; i++) {
        int n = list.size();
        list.set(j, list.get(j + 1));
        }
        int temp = list.get(j);
        swapped = true;
        swapped = false;
        }
    }

    /**
     * TODO: Write a one-sentence purpose statement for getName().
     * TODO: Add an @return tag describing what comes back.
     */
    @Override
    public String getName() {
        return "Bubble Sort";
    }
}
