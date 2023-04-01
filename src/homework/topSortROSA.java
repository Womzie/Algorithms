package homework;

import edu.princeton.cs.algs4.*;

import java.io.IOException;
import java.util.regex.Pattern;

public class topSortROSA {

    private static EdgeWeightedDigraph[] graphs;
    private static DirectedEdge[] sVerts;


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
    public static Digraph readG(String filename){

        In in = new In(filename);
        String[] lines = in.readAllLines();
        int[] numbers = parseLine(lines[0]);
        //StdOut.println(numbers[0]);
        //StdOut.println(numbers[1]);

        Digraph tGraph = new Digraph(numbers[0]);
        for (int i = 1 ; i <= numbers[1]; i++) {
            int[] temp = parseLine(lines[i]);
            tGraph.addEdge(temp[0] -1,temp[1] - 1);

        }
        return tGraph;
    }

    public static void main(String[] args) throws IOException {

        Digraph g = new Digraph(readG(args[0]));
        Topological t = new Topological(g);
        if(t.hasOrder()) {
            for (int j : t.order()) {
                StdOut.print(j + 1 + " ");

            }
        }
        else{
            StdOut.print(-1 + " ");
        }






    }
}

