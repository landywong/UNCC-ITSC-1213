import java.util.ArrayList;
import java.util.Random;

/**
 * Utility class for generating ArrayLists of random integers.
 * Provides methods to generate random integer sequences with or without a seed,
 * and supports an optional default upper bound.
 * <p>
 * Useful for testing sorting algorithms or other list-based operations.
 * 
 * @author Denis Jacob Machado (ITSC-1213, Summer 2025)
 */
public class ArrayGenerator {

    /**
     * Generates a random list of integers.
     * @param size The number of elements in the list.
     * @param bound The upper bound for random integers.
     * @return A randomly filled ArrayList of integers.
     */
    public static ArrayList<Integer> generate(int size, int bound) {
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(bound));
        }
        return list;
    }

    /**
    * Generates a random list of integers.
    * The upper bound for random integers is 100.
    * @param size The number of elements in the list.
    * @return A randomly filled ArrayList of integers.
    */
    public static ArrayList<Integer> generate(int size) {
        return generate(size, 100); // default upper bound
    }
    
    
}