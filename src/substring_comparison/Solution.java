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
        List<String> inputArray = bufferedReader.lines().collect(Collectors.toList());
        System.out.println(getSmallestAndLargest(inputArray.get(0), Integer.parseInt(inputArray.get(1))));
        bufferedReader.close();
    }

    public static String getSmallestAndLargest(String s, int k) {
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        List<String> strings = new ArrayList<>();

        for(int i = 0; i <= s.length(); i++) {
            int min = i;
            int max = i + k;
            if(max > s.length())
                break;
            strings.add(s.substring(min, max));
        }

        strings.sort(String.CASE_INSENSITIVE_ORDER);

        String smallest = strings.get(0);
        String largest = strings.get(strings.size() - 1);

        return smallest + "\n" + largest;
    }
}