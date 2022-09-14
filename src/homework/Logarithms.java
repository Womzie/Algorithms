package homework;

import edu.princeton.cs.algs4.*;

public class Logarithms {
    public static int log(int a, int b) {
        int count = 0;
        while(b / a >= 1){
            count++;
            b = b/a;
        }
        return count;
    }
}
