package inclass;

import edu.princeton.cs.algs4.StdOut;

public class BinaryTree {

    class Node {
        int value;
        Node left;
        Node right;

        private Node(int value) {
            this.value = value;
        }

        public String toString() {
            String s =  "(" + value;
            if (left != null)  s += left.toString();

            if (right != null) s += right.toString();


            return s + ")";
        }
    }

    private Node root;

    public BinaryTree() {
        root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(7);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
    }

    public String toString() {
        return root.toString();
    }

    public static void main(String[] unused) {
        BinaryTree t = new BinaryTree();
        StdOut.println(t.toString());
    }

}
