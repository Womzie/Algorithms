package inclass;

public class inA {
    Comparable[] A;
    public static void main(String[] args) {

        Comparable<Integer> [] z = new Comparable[]{1, 2, 3, 4, 1};
        System.out.println(max(z));

    }


    //Invariant: temp is the largest of the first i-1 elements
    public static Comparable max(Comparable[] A){
        Comparable temp = A[0];
        for (int i = 1; i < A.length; i++) {
            // Initialization: i=1, temp is equal to the largest of the first 0 elements in A
            // Maintenance:    At the start of iteration i, temp is equal to the largest of the first i-1 elements in A
            //                 At the start of integration i + 1, temp is equal to the maximum of the first i elements in A
            // Termination:    i = A.length, temp is the maximum of the entire array
            if(A[i].compareTo(temp) > 0){
                temp = A[i];
            }


        }
        return temp;
    }
    // This is literally just induction

    /*
    Alain style invariant
     Invariant:
            temp = max(A[0:i-1])
     Initialization:
            i = 0, max(A[0:0]) = A[0]
     Maintenance:
        Assume: invariant holds for value i
            r = max(A[0:i-1])
        Need to prove: invariant holds for value i+1
            "max(r,a[i])"
            r = "max(max(A[0:i-1]), a[i])
            r = max(A[0:i])
            "i++"
            r = max(A[0: i-1])
                         ^new updated i, so same as assumption, therefore by induction it is true for the entire loop
     Termination:
            r = max(A[0:A.length])
    */

}
