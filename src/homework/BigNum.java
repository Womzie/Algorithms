package homework;
import java.util.ArrayList;
import edu.princeton.cs.algs4.*;
// package BigNum

public class BigNum {
    ArrayList<Integer> numbers;

    BigNum(String num){
        numbers = new ArrayList<Integer>();

        for(int i = 0; i < num.length(); i++){
            int temp = Integer.parseInt(num.substring(i,i+1));
            numbers.add(temp);
        }
        if(num.length() == 0) {
            numbers.add(0);
        }
    }

    @Override
    public String toString() {
        String temp = "";

        for(int i = 0; i < this.numbers.size(); i++){
            temp += numbers.get(i);
        }
        return temp;
    }
    // currently doesn't work for BigNums of different sizes
    public BigNum plus(BigNum b) {
        String normal= "";
        int temp = 0;
        int i = this.numbers.size()-1;

        int j = b.numbers.size()-1;
        int biggest = Math.max(i,j);
        boolean carry = false;
        while(biggest >= 0){
            temp = 0;
            if(i >= 0)temp += this.numbers.get(i);
            if(j >= 0)temp += b.numbers.get(j);

            if(carry){
                temp += 1;
            }
            if(temp > 10){
                temp = temp%10;
                carry = true;
            }
            else{ carry = false;}

            normal = temp + normal;
            i--;
            j--;
            biggest--;
        }
        if(carry){
            normal = temp + normal;
        }
        BigNum c = new BigNum(normal);
        return c;
    }

    public BigNum times(BigNum b) {

        return null;
    }
}
