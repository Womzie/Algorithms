package homework;

import edu.princeton.cs.algs4.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Cte {

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

        int n = 1;
        for (int i = 0; i < numbers[0]; i++) {
            //StdOut.println(lines[n]);
            int[] temp = parseLine2(lines[n + 1]);
            sVerts[i] = new DirectedEdge(temp[0] - 1, temp[1] - 1, temp[2]);
            graphs[i] = readG(lines, n);

            n += graphs[i].E() + 1;
        }

    }
    public static EdgeWeightedDigraph readG(String[] lines, int n){

        int[] numbers = parseLine(lines[n]);
        //StdOut.println(numbers[0]);
        //StdOut.println(numbers[1]);

        EdgeWeightedDigraph tGraph = new EdgeWeightedDigraph(numbers[0]);
        //StdOut.println(numbers[1]);
        for (int i = 1; i <= numbers[1]; i++) {

            int[] temp = parseLine2(lines[n + i]);

            DirectedEdge d = new DirectedEdge(temp[0] - 1, temp[1] - 1, temp[2]);
            tGraph.addEdge(d);

        }
        return tGraph;
    }


    public static int[] DIJ(@NotNull EdgeWeightedDigraph g, DirectedEdge start) {
        int[] dist = new int[g.V()];
        Queue Q = new Queue();
        for (int v = 0; v < g.V(); v++) {
            dist[v] = -1;
        }
        dist[start.from()] = 0;
        dist[start.to()] = (int) start.weight();
        Q.enqueue(start.to());



        while (!Q.isEmpty()){
            int u = (int) Q.dequeue();

            for (DirectedEdge d : g.edges()){
                if(d.from() == u) {
                    int v = d.to();
                    if (dist[v] < 0) {

                        dist[v] = dist[u] + (int) d.weight();

                        Q.enqueue(v);

                    } else if (dist[v] > dist[u] + (int) d.weight()) {
                        dist[v] = dist[u] + (int) d.weight();

                        Q.enqueue(v);
                    }
                }
            }


        }

        return dist;



        //for (int i = 0; i < g.V(); i++) {
        //    StdOut.print(dist[i] + " ");
        //}
        //StdOut.println();

    }

    public static void finishCycle(EdgeWeightedDigraph g, int[] dist, DirectedEdge start){
        boolean f = false;
        int minCycle = 100000;
        for(DirectedEdge d : g.edges()){
            int j = d.to();
            if(j == start.from()){
                int i = d.from();
                if (dist[i] > 0) {
                    if (minCycle > dist[i] + d.weight()) {
                        minCycle = dist[i] + (int) d.weight();
                    }

                    f = true;

                }
            }
        }
        if(f){
            StdOut.print(minCycle + " ");
        }
        else{
            StdOut.print(-1 + " ");
        }
    }

    public static void main(String[] args) throws IOException {

        readGs(args[0]);

        for (int i = 0; i < graphs.length; i++) {
            EdgeWeightedDigraph g = graphs[i];
            //StdOut.println(g.toString());
            int[] dist = DIJ(g, sVerts[i]);
            //StdOut.println(Arrays.toString(dist));
            finishCycle(g, dist, sVerts[i]);



        }

    }
}

