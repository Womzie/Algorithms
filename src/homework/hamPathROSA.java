package homework;

import edu.princeton.cs.algs4.*;

import java.io.IOException;
import java.util.regex.Pattern;

public class hamPathROSA {

    private static Digraph[] graphs;



    public static int[] parseLine0(String line){
        Pattern spaces =  Pattern.compile("\\s+");
        String[] words = spaces.split(line);

        return new int[] {Integer.parseInt(words[0])};
    }
    public static int[] parseLine(String line){
        Pattern spaces =  Pattern.compile("\\s+");
        String[] words = spaces.split(line);

        return new int[] {Integer.parseInt(words[0]), Integer.parseInt(words[1])};
    }
    public static int[] parseLine2(String line){
        Pattern spaces =  Pattern.compile("\\s+");
        String[] words = spaces.split(line);

        return new int[] {Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2])};
    }
    public static void readGs(String filename) {

        In in = new In(filename);
        String[] lines = in.readAllLines();
        int[] numbers = parseLine0(lines[0]);
        //StdOut.println(numbers[0]);

        graphs = new Digraph[numbers[0]];

        int n = 2;
        for (int i = 0; i < numbers[0]; i++) {
            //StdOut.println(lines[n]);

            graphs[i] = readG(lines, n);

            n += graphs[i].E() + 2;
        }

    }
    public static Digraph readG(String[] lines, int n){

        int[] numbers = parseLine(lines[n]);


        Digraph tGraph = new Digraph(numbers[0]);
        //StdOut.println(numbers[1]);
        for (int i = 1; i <= numbers[1]; i++) {

            int[] temp = parseLine(lines[n + i]);

            tGraph.addEdge(temp[0] - 1, temp[1] - 1);

        }
        return tGraph;
    }

    public static String ham(Digraph g){
        StringBuilder assemblage = new StringBuilder("1 ");
        TopologicalX t = new TopologicalX(g);
        int last = -1;
        if(t.hasOrder()){
            for(int v : t.order()){
                assemblage.append(v + 1).append(" ");
                if(last != -1){
                    boolean flag = false;
                    for(int u : g.adj(last)){
                        if (v == u) {
                            flag = true;

                            break;
                        }
                    }
                    if(!flag){
                        return "-1";
                    }
                }
                last = v;
                //StdOut.println(v + " " + t.rank(v));
            }
            return assemblage.toString();
        }
        return "-1";
    }


    public static void main(String[] args) throws IOException {
        readGs(args[0]);


        for (Digraph g : graphs) {
            StdOut.print(ham(g));
            StdOut.println();
            //StdOut.println(g.toString());
        }


    }
}

