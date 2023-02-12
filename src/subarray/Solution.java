package subarray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/subarray/input"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();
        Solution solution = new Solution();
        solution.solve(stringArray);
    }

    private void solve(List<String> stringArray) {
        int length = Integer.parseInt(stringArray.get(0));
        String[] valuesAsString = stringArray.get(1).split(" ");
        int[] values = Arrays.stream(valuesAsString).mapToInt(Integer::parseInt).toArray();
        List<Integer> negativeValues = new ArrayList<>();

        for(int i = 0; i < length; i++) {
            for(int i2 = 0; i2 < length; i2++) {
                int nextInt = i2 % length;
                int finalValue = 0;
                for(int range = i; range <= nextInt; range++) {
                    finalValue += values[range];
                }
                if(finalValue < 0) {
                    negativeValues.add(finalValue);
                }
                //System.out.println("["+i+" : "+nextInt+"]");
            }
        }
        System.out.println(negativeValues.size());
    }

}