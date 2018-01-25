package sorter.control.algorithms;


/**
 * An implementation of bubblesort.
 * <p>
 * See this class as a sample of how other algorithms should be implemented.
 * It does not have to be changed.
 *
 * @author Sara Stymne
 */
public class BubbleSortAlgorithm extends SortAlgorithm {

    /**
     * Constructs an instance of BubbleSort algorithm with the name set.
     * <p>
     * All algorithms should have a similar constructor!
     */
    public BubbleSortAlgorithm() {
        super("Bubble sort");
    }


    /**
     * Sorts the vector using bubblesort.
     * <p>
     * The sort() function should always be the main sorting
     * function of each algorithm
     *
     * @see SortAlgorithm#sort()
     */
    public void sort() {
        for (int i = 1; i < getElementCount(); ++i) {
            for (int j = getElementCount() - 1; j >= i; --j) {
                if (cmp(j, j - 1) < 0) swap(j, j - 1);
            }
        }
    }

}
