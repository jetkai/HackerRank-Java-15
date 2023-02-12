package prime_checker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    private final List<PrimeNumber> primeArray = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/prime_checker/input3"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        stringArray.remove(0);

        Solution solution = new Solution();
        solution.init(stringArray);

        bufferedReader.close();
    }

    public void init(List<String> stringArray) {
        stringArray.forEach(this::checkPrime);
        printPrime();
    }

    private void checkPrime(String nextNumber) {
        boolean isPrime = new BigInteger(nextNumber).isProbablePrime(1);
        //if (isPrime && !primeArray.contains(nextNumber))
        primeArray.add(new PrimeNumber(nextNumber, isPrime));
    }

    private void printPrime() {
        if(primeArray.size() < 4)
            IntStream.range(0, 4 - primeArray.size())
                    .mapToObj(i -> primeArray.get(0))
                    .forEach(System.out::println);

        IntStream.rangeClosed(1, primeArray.size())
                .mapToObj(i -> primeArray.stream().limit(i)
                        .collect(Collectors.toList())).forEach(x -> System.out.println(x.stream().map(PrimeNumber::getNumber).collect(Collectors.toList())));
    }

}

class PrimeNumber {

    private final String number;
    private final boolean prime;

    public PrimeNumber(String number, boolean prime) {
        this.number = number;
        this.prime = prime;
    }

    public boolean isPrime() {
        return prime;
    }

    public String getNumber() {
        return number;
    }
}