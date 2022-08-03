package username_regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputArray = bufferedReader.lines().collect(Collectors.toList());
        inputArray.remove(0);
        inputArray.stream().map(username -> new UserChecker(username).isValid()).forEach(System.out::println);
        bufferedReader.close();
    }
}

class UserChecker {

    private final String username;

    public UserChecker(String username) {
        this.username = username;
    }

    public String isValid() {
        Pattern whitelist = Pattern.compile("^[a-zA-Z]+[a-zA-Z_0-9]*");
        Pattern blacklist = Pattern.compile("[^a-zA-Z0-9_]+");
        boolean isValid = (this.username.length() >= 8 && this.username.length() <= 30)
                && !blacklist.matcher(username).matches() && whitelist.matcher(username).matches();
        return isValid ? "Valid" : "Invalid";
    }
}