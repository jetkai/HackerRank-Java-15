package pattern_syntax_checker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/pattern_syntax_checker/input"));
        List<String> inputArray = bufferedReader.lines().collect(Collectors.toList());

        inputArray.remove(0);

        Result.printAnswer(inputArray);

        bufferedReader.close();
    }

}

class Result {

    public static void printAnswer(List<String> inputArray) {
        inputArray.forEach(s -> {
            try {
                Pattern.compile(s);
                System.out.println("Valid");
            } catch (PatternSyntaxException exception) {
                System.out.println("Invalid");
            }
        });
    }

}