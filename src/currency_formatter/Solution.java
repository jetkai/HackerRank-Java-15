package currency_formatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/currency_formatter/input"));

        String[] valueArray = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Currency> currencyList = new ArrayList<>(Arrays.asList(
                new Currency("US", NumberFormat.getCurrencyInstance(Locale.US)),
                new Currency("India", NumberFormat.getCurrencyInstance(new Locale("en", "IN"))),
                new Currency("China", NumberFormat.getCurrencyInstance(Locale.CHINA)),
                new Currency("France", NumberFormat.getCurrencyInstance(Locale.FRANCE)))
        );

        for (String s : valueArray) {
            double valueAsDouble = Double.parseDouble(s);
            for (Currency currency : currencyList) {
                System.out.printf("%s: %s%n", currency.getName(), currency.getFormat().format(valueAsDouble));
            }
        }

        bufferedReader.close();
    }
}

class Currency {

    private final String name;
    private final NumberFormat format;

    public Currency(String name, NumberFormat format) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public NumberFormat getFormat() {
        return format;
    }
}