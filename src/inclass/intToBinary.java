// UNFINISHED. DOES NOT WORK

package inclass;

public class intToBinary {
    public static void main(String[] args) {

        int in = 7;
        int d = 2 ^ 32;
        String out = "";
        while (d >= 1){
            if(in >= d){
                out += "1";

            }
            else{out += "0";}
            d/= 2;
        }
    }
}
