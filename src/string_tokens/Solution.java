package string_tokens;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/string_tokens/input"));

        List<String> inputArray = new ArrayList<>(List.of(bufferedReader.readLine().split("[^a-zA-Z]|[?]+")));
        inputArray.removeIf(String::isEmpty);

        Result.printAnswer(inputArray);

        bufferedReader.close();
    }

}

class Result {

    public static void printAnswer(List<String> inputArray) {
        System.out.println(inputArray.size());
        inputArray.forEach(System.out::println);
    }

}