package inclass;
import edu.princeton.cs.algs4.*;

public class MyMath {

    /**
     * Raise the first argument to the power of the second argument
     * @param a the base
     * @param b the exponent (b >=0)
     * @return the base raised to the exponent
     */
    public static int pow(int a, int b){
        if(b == 0) return 1;
        return a * pow(a, b-1);

    }

    public static int pow2(int a, int b){
        if(b==0) return 1;
        if(b%2 ==0) {
            int r = pow2(a, b/2);
            return r * r;
        }
        int r= pow2(a, (b-1)/2);
    
        return a * r * r;



    }

    public static void main(String[] args) {
        StdOut.println(pow2(2,11));
    }
}
