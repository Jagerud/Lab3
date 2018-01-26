package sorter.control.algorithms;

public class InsertionSortAlgorithm extends SortAlgorithm {

    public InsertionSortAlgorithm() {
        super("Insertion sort");
    }

    /**
     * Sorts the vector using Insertionsort.
     * <p>
     * The sort() function should always be the main sorting
     * function of each algorithm
     *
     * @see SortAlgorithm#sort()
     */
    @Override
    public void sort() {
        int j;
        for (int i = 0; i < getElementCount(); ++i) {
            for (j = i - 1; ((j >= 0) && (cmp(j, j + 1) > 0)); --j) {
                swap(j + 1, j);
            }
        }
    }
}
