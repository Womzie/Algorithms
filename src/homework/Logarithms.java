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

    public static int factorial(int n){
        // Invariant: r = k!
        // Initialization
        //      k= = 1, r = 1 ==> 1 = r = k! = 1! = 1
        //Maintenance:
        //      k'        = k + 1, r' = r*k'
        //      r         = k! (assumption)
        //      r * (k+1) = k! * (k+1)
        //      r*(k+1)   = (k+1)! (definition of factorial)
        //      r*k'      = (k')!
        //      r'        = (k')!
        //Termination
        //      Exit the loop when k reaches n ==> k = n && have computed n!
        int fac = 1;
        for(int i = 2; i <= n; i++){
            fac *= i;
        }
        return fac;
    }

    public static void main(String[] args) {
        StdOut.println(factorial(15));
    }
    }
