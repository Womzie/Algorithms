package homework;

public class trash {

    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }


    public static void main(String[] args) {
        int count = 0;
        for(int i = 2; i <= 2022; i++){
            if(gcd(i, 5) == 1){
                count++;
                System.out.println(i);
            }

        }
        System.out.println(count);
    }


}
