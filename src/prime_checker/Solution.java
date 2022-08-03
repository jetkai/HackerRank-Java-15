package prime_checker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private final List<PrimeNumber> primeArray = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/prime_checker/input3"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());


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
/*        if(primeArray.size() < 4) {
            int bound = 4 - primeArray.size();
            for (int i = 0; i < bound; i++) {
                PrimeNumber primeNumber = primeArray.get(0);
                System.out.println(primeNumber);
            }
        }*/

      //  while(primeArray.size() > 4) {
/*        IntStream.range(0, primeArray.size()).filter(i -> i + 1 <= primeArray.size() - 1).forEach(i -> {
            PrimeNumber compare1 = primeArray.get(i);
            PrimeNumber compare2 = primeArray.get(i + 1);
            if (compare1.getNumber().equals(compare2.getNumber()))
                primeArray.remove(i);
        });*/
      //  }
        int bound = primeArray.size();
        for (int i = 1; i <= bound; i++) {

            String collect = primeArray.stream()
                    .limit(i)
                    .filter(PrimeNumber::isPrime)
                    .map(PrimeNumber::getNumber)
                    .collect(Collectors.joining(" "));

            System.out.println(collect);
        }
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