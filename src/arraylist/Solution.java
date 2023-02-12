package arraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/arraylist/input2"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        solution.printOutput(bufferedReader, length);
        bufferedReader.close();
    }

    public void printOutput(BufferedReader bufferedReader, int length) throws IOException {

        //Example: IntegerArray of [5, 41, 77, 74, 22, 44]
        List<List<Integer>> listOfData = new ArrayList<>();

        //Example: Lookup request [1, 3] for index 1 of listOfData & index 3 of the 1st list
        List<List<Integer>> listOfLookupResults = new ArrayList<>();

        IntStream.range(0, length).forEach(i -> {
            try {
                listOfData.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int nextLength = Integer.parseInt(bufferedReader.readLine());

        IntStream.range(length, length + nextLength).forEach(i -> {
            try {
                listOfLookupResults.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        ArrayList<String> lookupResult = lookup(listOfData, listOfLookupResults);
        lookupResult.forEach(System.out::println);
    }

    private ArrayList<String> lookup(List<List<Integer>> listOfData, List<List<Integer>> listOfLookupResults) {
        ArrayList<String> lookupResult = new ArrayList<>();

        listOfLookupResults.stream().filter(listOfLookup -> listOfLookup.size() == 2).forEach(listOfLookup -> {
            int position1 = listOfLookup.get(0) - 1; //length is not in index 0, skip
            int position2 = listOfLookup.get(1);
            if (position1 <= listOfData.size()) {
                List<Integer> listOfDataArray = listOfData.get(position1);
                if (position2 <= listOfDataArray.size()) {
                    try {
                        int value = listOfDataArray.get(position2);
                        lookupResult.add(String.valueOf(value));
                    } catch (IndexOutOfBoundsException exception) {
                        lookupResult.add("ERROR!");
                    }
                } else {
                    lookupResult.add("ERROR!");
                }
            } else {
                lookupResult.add("ERROR!");
            }
        });

        return lookupResult;
    }

}