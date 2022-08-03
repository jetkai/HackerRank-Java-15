package lets_review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/lets_review/input"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        Solution solution = new Solution();
        solution.printText(stringArray);
    }

    public void printText(List<String> stringArray) {
        int maxLength = Integer.parseInt(stringArray.get(0));
        stringArray.remove(0); //Max amt of strings not needed anymore, can also get with stringArray.size(); which is safer.

        List<StringBuilder> answer = IntStream.range(0, maxLength)
                .mapToObj(StringBuilder::new)
                .collect(Collectors.toList());

        for(int sIndex = 0; sIndex < stringArray.size(); sIndex++) {
            String string = stringArray.get(sIndex);
            for(int i = 0; i < string.length(); i += 2) { //Even Loop
                StringBuilder stringBuilder = answer.get(sIndex);
                stringBuilder.append(string.charAt(i));
                answer.set(sIndex, stringBuilder);
            }

            //Split Even/Odd with Space
            StringBuilder sBuilder = answer.get(sIndex);
            sBuilder.append(" ");

            for(int i = 1; i < string.length(); i += 2) { //Odd Loop
                StringBuilder stringBuilder = answer.get(sIndex);
                stringBuilder.append(string.charAt(i));
                answer.set(sIndex, stringBuilder);
            }
        }
        answer.forEach(System.out::println);
    }
}