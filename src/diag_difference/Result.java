package diag_difference;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/diag_difference/input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data/diag_difference/output"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(Stream.of(bufferedReader.readLine()
                                .replaceAll("\\s+$", "")
                                .split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int diagDiff1 = IntStream.range(0, arr.size()).map(i -> arr.get(i).get(i)).sum();
        int diagDiff2 = IntStream.range(0, arr.size()).map(i -> arr.get(i).get((arr.size() - 1) - i)).sum();
        return Math.abs(diagDiff1 - diagDiff2);
    }

}