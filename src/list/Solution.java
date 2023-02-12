package list;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/list/input"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        Solution solution = new Solution();
        solution.solve(stringArray);
    }

    private void solve(List<String> stringArray) {
        //Always defined
        int lengthOfList = Integer.parseInt(stringArray.get(0)); //not needed
        int numberOfQueries = Integer.parseInt(stringArray.get(2));
        int startIndexForQueries = 3;
        
        String[] valuesAsStringArray = stringArray.get(1).split(" ");
        List<Integer> listOfValues = Arrays.stream(valuesAsStringArray)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        List<Query> listOfQueries = new ArrayList<>();
        List<String> queries = stringArray.subList(startIndexForQueries, startIndexForQueries + (numberOfQueries * 2));
        for(int i = 0; i < queries.size(); i++) {
            String name = queries.get(i);
            if (name == null || !name.equalsIgnoreCase("insert") && !name.equalsIgnoreCase("delete")) {
                continue;
            }
            int[] values = Arrays.stream(queries.get(i + 1).split(" ")).mapToInt(Integer::parseInt).toArray();
            listOfQueries.add(new Query(name, values));
        }

        listOfQueries.forEach(query -> query.handle(listOfValues));

        String finalOutput = listOfValues.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(finalOutput);
    }
    
    static class Query {
        private final String name;
        private final int[] values;

        public Query(String name, int[] values) {
            this.name = name;
            this.values = values;
            
        }

        public void handle(List<Integer> listOfValues) {
            if(name.equalsIgnoreCase("insert")) {
                if(values.length != 2) {
                    return;
                }
                int position = values[0];
                int value = values[1];
                listOfValues.add(position, value);
            } else if(name.equalsIgnoreCase("delete")) {
                Arrays.stream(values).forEach(listOfValues::remove);
            }
        }
    }

}