package plus_minus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/plus_minus/input"));

        //Skip first two lines
        for(int i = 0; i < 2; i++)
            bufferedReader.readLine();

        //Read n from BufferReader
        int n = Integer.parseInt(bufferedReader.readLine().split(" {2}")[0].trim());

        //Read array from BufferReader
        List<Integer> arr = Stream.of(bufferedReader.readLine().split(" {2}")[0]
                        .replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

        Result.plusMinus(n, arr);

        bufferedReader.close();
    }

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void plusMinus(int n, List<Integer> arr) {
        Store formats = new Store(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        for(Integer ar : arr) {
            if(ar > 0) {
                formats.getPositive().add(ar);
            } else if (ar < 0) {
                formats.getNegative().add(ar);
            } else {
                formats.getZeros().add(ar);
            }
        }

        double positivePercentage = (double) formats.getPositive().size() / n;
        double negativePercentage = (double) formats.getNegative().size()/ n;
        double zeroPercentage = (double) formats.getZeros().size() / n;

        System.out.printf("%.6f%n%.6f%n%.6f%n", positivePercentage, negativePercentage, zeroPercentage);
    }

}

class Store {

    private final List<Integer> positive;
    private final List<Integer> negative;
    private final List<Integer> zeros;

    public Store(List<Integer> positive, List<Integer> negative, List<Integer> zeros) {
        this.positive = positive;
        this.negative = negative;
        this.zeros = zeros;
    }

    public List<Integer> getNegative() {
        return negative;
    }

    public List<Integer> getPositive() {
        return positive;
    }

    public List<Integer> getZeros() {
        return zeros;
    }
}