package duplicate_words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/duplicate_words/input"));
        List<String> inputArray = bufferedReader.lines().collect(Collectors.toList());
        inputArray.remove(0);
        inputArray.stream().map(Result::replaceDuplicates).forEach(System.out::println);
        bufferedReader.close();
    }

}

class Result {

    public static String replaceDuplicates(String input) {
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
        while (m.find()) input = input.replaceAll(m.group(), m.group(1));
        return input;
    }

}