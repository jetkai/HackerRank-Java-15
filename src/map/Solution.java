package map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/map/input"));
       // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        int amt = Integer.parseInt(stringArray.get(0));
        stringArray.remove(0); //Remove Amt

        List<String> customers = stringArray.stream().skip(amt * 2L).collect(Collectors.toList());
        List<String> inputData = stringArray.stream().limit(amt * 2L).collect(Collectors.toList());

        Solution solution = new Solution();

        Map<String, Object> phoneDataMap = solution.combinePhoneData(inputData);
        solution.printOutput(customers, phoneDataMap);
    }

    public void printOutput(List<String> customers, Map<String, Object> phoneDataMap) {
        for(String customer : customers) {
            Object customerPhoneNumber = phoneDataMap.get(customer);
            if(customerPhoneNumber != null) {
                System.out.printf("%s=%s%n", customer, customerPhoneNumber);
            } else {
                System.out.println("Not found");
            }
        }
       /* phoneDataMap.forEach((key, value) -> {
            if (customers.contains(key)) {
                System.out.printf("%s=%s%n", key, value);
            } else {
                System.out.println("Not found");
            }
        });*/
    }

    public Map<String, Object> combinePhoneData(List<String> inputData) {
        Map<String, Object> phoneData = new HashMap<>();
        for(int i = 0; i < inputData.size() - 1; i++) {
            String customerName = inputData.get(i);
            String customerPhoneNumber = inputData.get(i + 1);

            int totalNames = customerName.contains(" ") ? customerName.split(" ").length : 1;
            //Validate Customer Name
            if(customerName.matches("^[a-z ]*$") && (totalNames == 1 || totalNames == 2)) {
                //Validate Phone Number
                if (customerPhoneNumber.matches("\\d+") && customerPhoneNumber.length() == 8)
                    phoneData.put(customerName, Integer.parseInt(customerPhoneNumber));
            }
        }
        return phoneData;
    }

}