package static_init_block;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("./data/static_init_block/input"));
        int b = in.nextInt();
        int h = in.nextInt();

        if(b <= 0 || h <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else
            System.out.println(b * h);

        in.close();
    }

}
