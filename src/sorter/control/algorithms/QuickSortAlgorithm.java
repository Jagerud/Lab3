package sorter.control.algorithms;

import java.util.concurrent.ThreadLocalRandom;

public class QuickSortAlgorithm extends SortAlgorithm {
    public QuickSortAlgorithm() {
        super("QuickSortAlgorithm");
    }

    /**
     * Sorts the vector using Quicksort.
     * <p>
     * The sort() function should always be the main sorting
     * function of each algorithm
     *
     * @see SortAlgorithm#sort()
     */
    @Override
    public void sort() {
        int left = 0;
        int right = getElementCount() - 1;
        int v = ThreadLocalRandom.current().nextInt(left, right + 1);
        doer(left, right, v);

    }

    /**Quicksort algorithm, recursive method call when pointers cross
     * Performs
     *
     * @param left, left pointer
     * @param right, right pointer
     * @param v, pivot index
     */
    public void doer(int left, int right, int v) {

        if (right > left) {
            int l = left, r = right;

            do {
                while (cmp(l, v) < 0) {
                    l++;
                }
                while (cmp(r, v) > 0) {
                    r--;
                }

                if (l <= r) {
                    if (l == v) {
                        swap(l, r);
                        v = r;
                    } else if (r == v) {
                        swap(l, r);
                        v = l;
                    } else {
                        swap(l, r);
                    }
                    l++;
                    r--;
                }
            } while (l <= r);

            if (left < r) {
                v = ThreadLocalRandom.current().nextInt(left, r + 1);
                doer(left, r, v);
            }
            if (l < right) {
                v = ThreadLocalRandom.current().nextInt(l, right + 1);
                doer(l, right, v);
            }
        }
    }
}
