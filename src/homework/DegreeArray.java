package homework;
import edu.princeton.cs.algs4.*;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DegreeArray {
    private static DirectedEdge[] directions;
    private static int[][] dist;
    private static int[][] next;


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
    public static Graph readG(String filename){

        In in = new In(filename);
        String[] lines = in.readAllLines();
        int[] numbers = parseLine(lines[0]);
        //StdOut.println(numbers[0]);
        //StdOut.println(numbers[1]);

        Graph tGraph = new Graph(numbers[0]);
        directions = new DirectedEdge[numbers[1]];
        for (int i = 1 ; i <= numbers[1]; i++) {
            int[] temp = parseLine(lines[i]);
            tGraph.addEdge(temp[0] -1,temp[1] - 1);
            directions[i-1] = new DirectedEdge(temp[0] - 1, temp[1] - 1, 0 );
        }
        return tGraph;
    }

    public static void BFS(@NotNull Graph g, int start){
        int[] dist = new int[g.V()];
        int[] Q = new int[g.V()];
        int Qsize = 0;
        for (int v = 0; v < g.V(); v++) {
            dist[v] = -1;
            Q[v] = -1;
        }
        dist[start] = 0;
        Q[0] = start;
        Qsize ++;

        while(Qsize > 0){
            int u = Q[0];
            Qsize--;
            if(Qsize > 0){
                for (int i = 1; i < g.V(); i++) {
                    Q[i-1] = Q[i];
                }
                Q[g.V()-1] = -1;
            }
            else{
                Q[0] = -1;
            }
            //StdOut.println(Qsize);
            for (int i = 0; i < g.E(); i++) {
                if(directions[i].from() == u){
                    int v = directions[i].to();
                    if(dist[v] < 0 ){
                        Q[Qsize] = v;
                        Qsize ++;
                        dist[v] = dist[u] + 1;
                    }
                }
            }
        }
        for (int i = 0; i < g.V(); i++) {
            StdOut.print(dist[i] + " ");
        }
    }

    public static void FWWPR(EdgeWeightedDigraph g, int start){
        dist = new int[g.V()][g.V()];
        next = new int[g.V()][g.V()];
        for (int i = 0; i < g.V(); i++) {
            for (int j = 0; j < g.V(); j++) {
                dist[i][j] = 100000;
                next[i][j] = -1;

            }
        }

        for(DirectedEdge d : g.edges()){
            int u = d.from();
            int v = d.to();

            dist[u][v] = (int)d.weight();
            next[u][v] = v;
        }
        for(int i = 0; i < g.V(); i++){
            dist[i][i] = 0;
            next[i][i] = i;
        }

        for (int k = 0; k < g.V(); k++) {
            for (int i = 0; i < g.V(); i++) {
                for (int j = 0; j < g.V(); j++) {
//                    if(dist[i][j] == -1){
//                        dist[i][j] = dist[i][k] + dist[k][j];
//                        next[i][j] = next[i][k];
//                    }
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }


        for(int j : dist[start]){
            StdOut.print(j + " ");
        }
        StdOut.println();

    }

    public static void main(String[] args) throws IOException {

        Graph g = readG(args[0]);

        for(int i = 0; i < g.V(); i++){
            int sum = 0;
            for (int j : g.adj(i)) {
                sum += g.degree(j);
            }
            StdOut.print(sum + " ");
        }
        //BFS(g, 0);

       //FWWPR(g,0);



    }
}

