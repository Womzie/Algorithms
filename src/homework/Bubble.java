package homework;
import java.util.Comparator;
import edu.princeton.cs.algs4.*;

public class Bubble {
    public static void sort(Double[] b) {
        for(int i = 1; i <= b.length; i++){
            for(int j = 0; j < b.length - i; j ++){
                if(!less(b[j], b[j+1])){
                    exch(b, j, j+1);
                }
            }
        }
    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


}
