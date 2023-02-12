package generics;

import java.io.IOException;
import java.lang.reflect.Method;


class Printer {

    public static void printArray(Object[] objectArray) {
        for(Object object : objectArray) {
            if(object instanceof Integer) {
                System.out.println(((Integer) object).intValue());
            } else if(object instanceof String) {
                System.out.println(object);
            }
        }
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray")) {
                count++;
            }
        }

        if(count > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }

}