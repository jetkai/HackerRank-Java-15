package strings_introduction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/strings_introduction/input"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        Solution solution = new Solution();
        solution.solve(stringArray);
    }

    private void solve(List<String> stringArray) {
        System.out.println(lengthOfString(stringArray));
        System.out.println(lexicographically(stringArray));
        System.out.println(formattedString(stringArray));
    }

    private int lengthOfString(List<String> stringArray) {
        String string1 = stringArray.get(0);
        String string2 = stringArray.get(1);
        return string1.length() + string2.length();
    }

    private String lexicographically(List<String> stringArray) {
        byte char1 = (byte) stringArray.get(0).charAt(0);
        byte char2 = (byte) stringArray.get(1).charAt(0);
        return char1 > char2 ? "Yes" : "No";
    }

    private String formattedString(List<String> stringArray) {
        String string = stringArray.stream().map(String::valueOf).collect(Collectors.joining(" ")).toLowerCase();
        StringBuilder newString = new StringBuilder();
        boolean wasSpace = true;
        for (int i = 0; i < string.length(); i++) {
            if (wasSpace) {
                newString.append((String.valueOf(string.charAt(i))).toUpperCase());
                wasSpace = false;
            } else {
                newString.append(string.charAt(i));
            }
            if (string.charAt(i) == ' ') {
                wasSpace = true;
            }
        }
        return newString.toString();
    }

}