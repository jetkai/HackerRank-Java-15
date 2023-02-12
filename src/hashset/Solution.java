package hashset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/hashset/input"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        Set<String> hashSet = new HashSet<>();
        bufferedReader.close();
        stringArray.remove(0);

        Solution solution = new Solution();
        solution.solve(stringArray, hashSet);
    }

    private void solve(List<String> stringArray, Set<String> hashSet) {
        for(String name : stringArray) {
            hashSet.add(name);
            System.out.println(hashSet.size());
        }
    }

}