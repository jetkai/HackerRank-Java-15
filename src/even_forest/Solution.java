package even_forest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Complete the evenForest function below.
    static int evenForest(int t_nodes, int t_edges, List<Integer> t_from, List<Integer> t_to) {
        System.out.printf("Nodes: %s, Edges: %s\n", t_nodes, t_edges);
        System.out.println("tFrom: "+ Arrays.toString(t_from.toArray()));
        System.out.println("tTo: "+ Arrays.toString(t_to.toArray()));

        System.out.println((Collections.frequency(t_to, 1) - 1));
        return 0;
    }

    public static void main(String[] args) throws IOException {
      //  Files.readAllLines(Path.of("./data/even_tree/input")).replaceAll("\\s+$", "");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/even_tree/input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data/even_tree/output"));
        //TODO UNCOMMENT THIS
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        for (int i = 0; i < tEdges; i++) {
            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            tFrom.add(Integer.parseInt(tFromTo[0]));
            tTo.add(Integer.parseInt(tFromTo[1]));
        }
        int res = evenForest(tNodes, tEdges, tFrom, tTo);

      //  bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
