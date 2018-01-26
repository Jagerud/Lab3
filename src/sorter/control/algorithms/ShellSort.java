package sorter.control.algorithms;

public class ShellSort extends SortAlgorithm {
    public ShellSort() {
        super("ShellSort");
    }

    /**
     * Sorts the vector using Shellsort.
     * <p>
     * The sort() function should always be the main sorting
     * function of each algorithm
     *
     * @see SortAlgorithm#sort()
     */
    public void sort() {
        for (int gap = getElementCount() / 2; gap > 0; gap /= 2.2) {
            if (gap == 2) {
                gap = 1;
            }
            for (int i = gap; i < getElementCount(); i++) {
                for (int j = i; j >= gap && cmp(j, j - gap) < 0; j -= gap) {
                    swap(j, j - gap);
                }
            }
        }
    }
}
