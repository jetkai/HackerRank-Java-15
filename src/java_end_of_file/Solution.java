package java_end_of_file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("./data/java_end_of_file/input"));
        int linePos = 1;
        while(in.hasNext()) {
            System.out.printf("%s %s%n", linePos, in.nextLine());
            linePos++;
        }
        in.close();
    }

}
