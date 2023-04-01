package homework;

import edu.princeton.cs.algs4.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.regex.Pattern;

public class acyclROSA {

    private static EdgeWeightedDigraph[] graphs;
    private static DirectedEdge[] sVerts;


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
        sVerts = new DirectedEdge[numbers[0]];
        graphs = new EdgeWeightedDigraph[numbers[0]];

        int n = 2;
        for (int i = 0; i < numbers[0]; i++) {
            //StdOut.println(lines[n]);
            int[] temp = parseLine(lines[n + 1]);
            sVerts[i] = new DirectedEdge(temp[0] - 1, temp[1] - 1, 0);
            graphs[i] = readG(lines, n);

            n += graphs[i].E() + 2;
        }

    }
    public static EdgeWeightedDigraph readG(String[] lines, int n){

        int[] numbers = parseLine(lines[n]);
        //StdOut.println(numbers[0]);
        //StdOut.println(numbers[1]);

        EdgeWeightedDigraph tGraph = new EdgeWeightedDigraph(numbers[0]);
        //StdOut.println(numbers[1]);
        for (int i = 1; i <= numbers[1]; i++) {

            int[] temp = parseLine(lines[n + i]);

            DirectedEdge d = new DirectedEdge(temp[0] - 1, temp[1] - 1, 0);
            tGraph.addEdge(d);

        }
        return tGraph;
    }
    public static void main(String[] args) throws IOException {

        readGs(args[0]);

        for (int i = 0; i < graphs.length; i++) {
            EdgeWeightedDigraph g = graphs[i];
            EdgeWeightedDirectedCycle c = new EdgeWeightedDirectedCycle(g);
            if(c.hasCycle()){
                StdOut.print(-1 + " ");
            }
            else{
                StdOut.print(1 + " ");
            }
            //StdOut.println(g.toString());



        }

    }
}

