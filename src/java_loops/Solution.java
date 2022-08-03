package java_loops;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("./data/java_loops/input"));
        int t = in.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            System.out.println("n:" +n);
            int prev = 0;
            int prevLoop = 1;
            for(int loop = 1; loop <= n; loop ++) {
                prevLoop = prevLoop * 2;
                int newAmt = prevLoop * b;
                int calc = 0;
                if(loop == 1) {
                    calc = a + b;
                    prevLoop = 1;
                } else {
                   calc = prev + newAmt;
                }
                prev = calc;
                stringBuilder.append(calc).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
        in.close();
    }
}
