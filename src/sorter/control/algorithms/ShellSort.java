package sorter.control.algorithms;

public class ShellSort extends SortAlgorithm {
    public ShellSort() {
        super("ShellSort");
    }

    /*public void sort() {
        for( int gap = getElementCount() / 2; gap > 0;
             gap = gap == 2 ? 1 : (int) ( gap / 2.2 ) )
            for( int i = gap; i < getElementCount(); i++ ) {
                int j = i;
                for( ; j >= gap && cmp(j, j - gap) < 0; j -= gap )
                    swap(j, j - gap);
            }
    }*/
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
    /*int j;
    for( int gap = a.length / 2; gap > 0; gap /= 2 )
    {
        for( int i = gap; i < a.length; i++ )
        {
            T tmp = a[ i ];
            for( j = i; j >= gap && tmp.compareTo( a[ j - gap ] ) < 0; j -= gap )
            {
                a[ j ] = a[ j - gap ];
            }
            a[ j ] = tmp;
        }
    }*/
}
