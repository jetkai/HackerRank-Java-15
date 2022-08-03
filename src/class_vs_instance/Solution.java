package class_vs_instance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named even_forest.Solution. */
       // BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/class_vs_instance/input"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for(int i = 0; i < n; i++) {
            int age = Integer.parseInt(bufferedReader.readLine());
            Person person = new Person(age);
            person.amIOld();
            IntStream.range(0, 3).forEach(i2 -> person.yearPasses());
            person.amIOld();
            System.out.println();
        }

    }
}

class Person {

    private int age;

    public Person(int initialAge) {
        if(initialAge < 0) {
            initialAge = 0;
            System.out.println("Age is not valid, setting age to 0.");
        }
        this.age = initialAge;
    }

    public void amIOld() {
        String ageMessage;

        if(this.age < 13)
            ageMessage = "You are young.";
        else if(this.age < 18)
            ageMessage = "You are a teenager.";
        else
            ageMessage = "You are old.";

        System.out.println(ageMessage);
    }

    public void yearPasses() {
        this.age++;
    }
}