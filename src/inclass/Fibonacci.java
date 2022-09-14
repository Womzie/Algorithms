package inclass;

import edu.princeton.cs.algs4.*;

public class Fibonacci {

    private static int[] cachedEntries = new int[47];

    static int fib(int n){
        if (cachedEntries[n] > 0) return cachedEntries[n];
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int fib = fib(n-1) + fib(n-2);
        cachedEntries[n] = fib;
        return fib;
    }

    static int fib2(int n){
       return go(n,0,1);
    }
    private static int go(int n, int a, int b){
        if( n == 0) return a;
        if (n == 1) return b;

        return go(n-1, b, a+b);
    }
   public static void main(String[] args) {
       StdOut.println("fib(2) = " + fib(2));
       StdOut.println("fib(5) = " + fib(5));
       StdOut.println("fib(46) = " + fib(46));

       StdOut.println("fib2(2) = " + fib(2));
       StdOut.println("fib2(5) = " + fib(5));
       StdOut.println("fib2(46) = " + fib(46));

    }

}
