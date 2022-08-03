package arrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/arrays/input"));
      //  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        stringArray.remove(0); //Not needed from HackerRank, using string.length (safer)
        bufferedReader.close();

        Solution solution = new Solution();
        solution.printOutput(stringArray);
    }

    public void printOutput(List<String> stringArray) {
        stringArray.stream().map(string
                          -> new ArrayList<>(List.of(string.split(" "))))
                          .forEach(strings -> {
                              Collections.reverse(strings);
                              String output = String.join(" ", strings);
                              System.out.println(output);
                          });
    }
}