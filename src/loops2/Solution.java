package loops2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
       // BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/loops2/input"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        int input = Integer.parseInt(stringArray.get(0));

        Solution solution = new Solution();
        solution.printCalc(input);
    }

    public void printCalc(int input) {
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.printf("%s x %s = %s%n", input, i, (input * i)));
    }
}