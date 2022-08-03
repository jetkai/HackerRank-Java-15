package primality_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        stringArray.stream().map(Solution::isPrimeAsString).forEach(System.out::println);
        bufferedReader.close();
    }

    public static String isPrimeAsString(String input) {
        boolean isPrime = new BigInteger(input).isProbablePrime(1);
        return isPrime ? "prime" : "not prime";
    }
}