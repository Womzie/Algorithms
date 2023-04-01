package homework;
import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;

public class GeneralTree<T> {

    class Node {
        T value;
        ArrayList<Node> children;


        private Node(T value) {
            this.value = value;
        }


        public String toString() {
            String s =  "(" + value;
            int i = 0;
            if(children != null) {
                while (i < children.size()) {
                    s += " " + children.get(i).toString();
                    i++;
                }
            }
            return s + ")";
        }

        public void findNode(T i, T i1) {
            if(value == i){
                if(children == null) {
                    children = new ArrayList<Node>();
                }
                children.add(new Node(i1));
                }
            if(children != null) {
                for (Node child : children) {
                    child.findNode(i, i1);
                }
            }
        }
        }


    private Node root;

    public void setRoot(T i) {
        root = new Node(i);
    }

    public void addChild(T i, T i1) {
        root.findNode(i, i1);
    }

    @Override
    public String toString() {
        if(root == null){
            return "()";
        }
        return root.toString();

    }



}
