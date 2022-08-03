package dictionary_and_maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
       // BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/dictionary_and_maps/input"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        Solution solution = new Solution();
        solution.printOutput(stringArray);
    }

    public void printOutput(List<String> stringArray) {
        int maxLength = Integer.parseInt(stringArray.get(0));
        HashMap<String, String> phoneBook = new HashMap<>();

        //PhoneBook
        int bound = maxLength + 1;
        for (int i = 1; i < bound; i++) {
            String name = stringArray.get(i).split(" ")[0];
            String phoneNumber = stringArray.get(i).split(" ")[1];
            phoneBook.put(name, phoneNumber);
        }

        //Search Queries
        int bound1 = stringArray.size();
        for (int i = 1 + maxLength; i < bound1; i++) {
            String searchName = stringArray.get(i);
            String phoneNumber = phoneBook.get(searchName);
            if (phoneNumber != null) {
                System.out.printf("%s=%s%n", searchName, phoneNumber);
            } else {
                System.out.println("Not found");
            }
        }
    }
}