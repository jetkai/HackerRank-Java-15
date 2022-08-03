package ip_regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/ip_regex/input"));
        List<String> inputArray = bufferedReader.lines().collect(Collectors.toList());

        inputArray.stream().map(IP -> new MyRegex(IP).isValid()).forEach(System.out::println);

        bufferedReader.close();
    }

}

class MyRegex {

    private final boolean isValid;

    public MyRegex(String ipAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.rangeClosed(0, 3).forEach(i -> {
            stringBuilder.append("([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])");
            if (i != 3)
                stringBuilder.append("\\.");
        });
        Pattern pattern = Pattern.compile(stringBuilder.toString());
        this.isValid = pattern.matcher(ipAddress).matches();
    }

    public boolean isValid() {
        return isValid;
    }
}