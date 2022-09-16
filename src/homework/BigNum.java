// Team members: Anders, Nuzhat, Katie, Skye

package homework;
import java.util.ArrayList;
import edu.princeton.cs.algs4.*;
// package bignum

public class BigNum {
    ArrayList<Integer> numbers;

    // Constructor
    BigNum(String num){
        numbers = new ArrayList<>();
        // Turn our string num into an arrayList of integers
        for(int i = 0; i < num.length(); i++){
            int temp = Integer.parseInt(num.substring(i,i+1));
            numbers.add(temp);
        }
        // checks if the string is empty and returns 0
        if(num.equals("")) {
            numbers.add(0);
        }
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();

        for (Integer number : this.numbers) {
            temp.append(number);
        }
        return temp.toString();
    }

    public BigNum plus(BigNum b) {
        StringBuilder normal= new StringBuilder();
        //initialize variables
        int temp = 0;
        int i = this.numbers.size()-1;
        int j = b.numbers.size()-1;
        int biggest = Math.max(i, j);
        boolean carry = false;

        // While still in the largest arrayList
        while(biggest >= 0){
            temp = 0;
            // Allowing addition of BigNums of different sizes
            if(i >= 0)temp += this.numbers.get(i);
            if(j >= 0)temp += b.numbers.get(j);

            // carry the one
            if(carry){
                temp += 1;
            }
            if(temp > 10){
                temp = temp%10;
                carry = true;
            }
            else{ carry = false;}

            normal.insert(0, temp);
            i--;
            j--;
            biggest--;
        }
        if(carry){
            normal.insert(0, temp);
        }
        return new BigNum(normal.toString());
    }

    public BigNum times(BigNum b) {
        if(b.numbers.size() == 0 || this.numbers.size() == 0) return new BigNum("0");
        BigNum result = new BigNum("");

        for(int i = this.numbers.size()-1; i >= 0; i--){
            for(int j = b.numbers.size()-1; j >= 0; j--){
                int product = (this.numbers.get(i)) * (b.numbers.get(j));

                //add the 0s for the other
                String tempResult = product +
                        "0".repeat(Math.max(0, b.numbers.size() - j - 1)) +
                        "0".repeat(Math.max(0, this.numbers.size() - i - 1));


                result = result.plus(new BigNum(tempResult));
            }
        }
        return result;
    }
}
