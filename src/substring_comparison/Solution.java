package substring_comparison;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/substring_comparison/input"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        Solution solution = new Solution();

        String input1 = inputArray.get(0);
        int input2 = Integer.parseInt(inputArray.get(1));

        String smallestAndLargest = solution.getSmallestAndLargest(input1, input2);
        System.out.println(smallestAndLargest);
    }

    public String getSmallestAndLargest(String s, int k) {
        List<String> strings = new ArrayList<>();

        for(int i = 0; i <= s.length(); i++) {
            int max = i + k;
            if(max > s.length()) {
                break;
            }
            strings.add(s.substring(i, max));
        }

        strings = strings.stream().sorted().collect(Collectors.toList());

        String smallest = strings.get(0);
        String largest = strings.get(strings.size() - 1);

        return smallest + "\n" + largest;
    }
}