package bigdecimal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/bigdecimal/input"));
     //   List<BigDecimal> bigDecimalArray = bufferedReader.lines().map(BigDecimal::new).collect(Collectors.toList());
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        stringArray.remove(0); //Not needed
        sortArray(stringArray).forEach(System.out::println);
        bufferedReader.close();
    }

    public static List<String> sortArray(List<String> strings) {
        strings.sort(Comparator.comparing(T -> new BigDecimal(String.valueOf(T))).reversed());
        return strings;
    }
}