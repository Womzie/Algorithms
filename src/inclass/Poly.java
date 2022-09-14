package inclass;

import edu.princeton.cs.algs4.StdOut;

public class Poly {
    private static double[] coeffs;

    // double array of coefficients of variable
    public Poly(double [] coeffs){
        this.coeffs = coeffs;
    }

    static double eval(double x){ // plug in x and evaluate polynomial
        double sum = 0;

        for(int i = coeffs.length - 1; i >= 0; i--){
            sum += coeffs[i] * (power(x, i));
        }
        return sum;
    }

    static double eval2(double x){
        double sum = coeffs[0];

        for (int i = 1; i <= coeffs.length-1; i++){
            sum *= x ;
            sum += coeffs[i];

        }
        return sum;
    }

    static double power(double x, int i){
        if (i == 0) return 1;
        if (i == 1) return x;
        else{
            return x * power(x, i -1);
        }
    }

    public static void main(String[] args) {
        Poly p = new Poly(new double[]{1,2,3});
        StdOut.println(Poly.eval2(2));
    }
}
