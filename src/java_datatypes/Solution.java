package java_datatypes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("./data/java_datatypes/input"));
        int t = in.nextInt();

        List<DataType> dataTypes = new ArrayList<>(
                List.of(new DataType("byte", Byte.MIN_VALUE, Byte.MAX_VALUE),
                        new DataType("short", Short.MIN_VALUE, Short.MAX_VALUE),
                        new DataType("int", Integer.MIN_VALUE, Integer.MAX_VALUE),
                        new DataType("long", Long.MIN_VALUE, Long.MAX_VALUE)));

        for(int i = 0; i < t; i++) {
            try {
                long x = in.nextLong();
                //This is not my writing, this is required for sample
                System.out.println(x + " can be fitted in:");
                //Output the correct data that the sample wants
                dataTypes.stream()
                        .filter(dataType -> x >= dataType.getMinValue() && x <= dataType.getMaxValue())
                        .forEach(dataType -> System.out.printf("* %s%n", dataType.getName()));
            } catch(Exception e) {
                //This is not my writing, this is required for sample
                System.out.println(in.next()+" can't be fitted anywhere.");
            }
        }
        in.close();
    }

}

class DataType {

    private final String name;
    private final long minValue;
    private final long maxValue;

    public DataType(String name, long minValue, long maxValue) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getName() {
        return name;
    }

    public long getMinValue() {
        return minValue;
    }

    public long getMaxValue() {
        return maxValue;
    }
}
