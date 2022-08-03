package recursion_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/recursion_3/input"));
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        int input = Integer.parseInt(stringArray.get(0));
        bufferedReader.close();

        Solution solution = new Solution();
        System.out.println(solution.factorial(input));
    }

    public int factorial(int input) {
        return input == 0 ? 1 : (input * factorial(input - 1));
    }
}