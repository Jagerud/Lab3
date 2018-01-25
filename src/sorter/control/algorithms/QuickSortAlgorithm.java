package sorter.control.algorithms;

import sorter.control.DataSet;

/**
 * Created by Sand on 2016-03-09.
 */
public class QuickSortAlgorithm extends SortAlgorithm {
    private DataSet vector;

    public QuickSortAlgorithm() {
        super("Quick sort");
    }

    @Override
    public void sort() {

        //boolean check = true;
        vector = handler.getWidget().getVector();
        int pivotIndex = (int) Math.floor(Math.random() * (getElementCount() - 1));
        if (pivotIndex < getElementCount()) {

            int q = poop(pivotIndex, (getElementCount() - 1));
            //int q=partition(a,p,r);
            poop(pivotIndex, q);
            poop(q + 1, (getElementCount() - 1));

            //return j
            /*sort(a,pivotIndex,q);
            sort(a,q+1,rangeIndex);*/
        }
    }

    public int poop(int pivotIndex, int r) {
        int x = vector.indexOf(pivotIndex);
        int rangeIndex = pivotIndex - 1; //mellan range och pivot
        int j = r + 1;

        while (true) {
            rangeIndex++; //oklar
            while (rangeIndex < getElementCount() && cmp(rangeIndex, x) < 0) { //inte säker på cmp:n
                rangeIndex++;
                System.out.println("sup/**/");
            }
            j--;

            while (j > pivotIndex && cmp(vector.indexOf(j), x) < 0) {
                System.out.println("--j");
                j--;
            }
            if (rangeIndex < j) {
                System.out.println("rangeIndex <j");
                swap(rangeIndex, j);
            } else {
                return j;
            }

        }
    }
}//a[rangeIndex] < x