package homework;

import edu.princeton.cs.algs4.*;

import java.io.IOException;
import java.util.regex.Pattern;

public class ConComp {
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

        }
        return tGraph;
    }



    public static void main(String[] args) throws IOException {

        Graph g = readG(args[0]);

        CC con = new CC(g);
        StdOut.println(con.count());
        //DFS(g);


        //BFS(g, 0);

       //FWWPR(g,0);



    }
}

