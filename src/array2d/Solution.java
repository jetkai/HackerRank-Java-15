package array2d;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/array2d/input"));
        //  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Solution solution = new Solution();
        solution.printOutput(bufferedReader);

        bufferedReader.close();
    }

    public void printOutput(BufferedReader bufferedReader) {
        List<List<Integer>> inputDataListByLine = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                inputDataListByLine.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<Integer>> hourglassList = hourglassLogic(inputDataListByLine);

        int maxValue = sumByHighestHourglass(hourglassList);
        System.out.println(maxValue);
    }

    /**
     * Example Input:
     * 1 1 1 0 0 0
     * 0 1 0 0 0 0
     * 1 1 1 0 0 0
     * 0 0 0 0 0 0
     * 0 0 0 0 0 0
     * 0 0 0 0 0 0
     * TODO
     * Example Output Required:
     * 1 1 1     1 1 0     1 0 0
     *   1         0         0
     * 1 1 1     1 1 0     1 0 0
     */
    private List<List<Integer>> hourglassLogic(List<List<Integer>> hourglassList) {
        //split into 3x3 array
        //2nd line requires 1 int only, requires to loop through the remaining 2 still

        List<List<Integer>> finalHourglassList = new ArrayList<>();

        int hourglassMaxLength = hourglassList.size();
        for(int i = 0; i < hourglassMaxLength; i++ ) {
            //hourglassList.get(0) = [1, 1, 1, 0, 0, 0]

            List<Integer> line1; //Max 3 Values
            List<Integer> line2 = new ArrayList<>(); //Max 1 Value
            List<Integer> line3 = new ArrayList<>(); //Max 3 Values

            line1 = hourglassList.get(i);
            if(hourglassMaxLength > i + 1)
                line2 = hourglassList.get(i + 1);
            if(hourglassMaxLength > i + 2)
                line3 = hourglassList.get(i + 2);

            for(int skip = 0; skip < hourglassMaxLength; skip++) {
                List<Integer> finalLine1 = line1.stream().skip(skip).limit(3).collect(Collectors.toList());
                List<Integer> finalLine2 = line2.stream().skip(skip + 1).limit(1).collect(Collectors.toList());
                List<Integer> finalLine3 = line3.stream().skip(skip).limit(3).collect(Collectors.toList());
                finalLine1.addAll(finalLine2);
                finalLine1.addAll(finalLine3);

                /*
                 * Hourglass can only be a maximum of 7 values
                 * 1 1 1
                 *    0
                 * 1 1 1
                 */
                if (finalLine1.size() == 7)
                    finalHourglassList.add(finalLine1);
            }
        }

        return finalHourglassList;
    }

    private int sumByHighestHourglass(List<List<Integer>> hourglassList) {
        Optional<Integer> hourglass = hourglassList.stream()
                .map(x -> x.stream().mapToInt(Integer::intValue).sum())
                .collect(Collectors.toList()).stream()
                .max(Comparator.comparing(Integer::valueOf));
        return hourglass.orElse(-1);
    }
}