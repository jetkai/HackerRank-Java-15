package biginteger_multiply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputArray = bufferedReader.lines().collect(Collectors.toList());
        String value1 = inputArray.get(0);
        String value2 = inputArray.get(1);
        System.out.println(bigIntegerAdd(value1, value2));
        System.out.println(bigIntegerMultiply(value1, value2));
        bufferedReader.close();
    }

    public static BigInteger bigIntegerAdd(String input1, String input2) {
        BigInteger a = new BigInteger(input1);
        BigInteger b = new BigInteger(input2);
        return a.add(b);
    }

    public static BigInteger bigIntegerMultiply(String input1, String input2) {
        BigInteger a = new BigInteger(input1);
        BigInteger b = new BigInteger(input2);
        return a.multiply(b);
    }

}