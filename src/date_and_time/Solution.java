package date_and_time;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/date_and_time/input"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./data/date_and_time/output"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}

class Result {

    public static String findDay(int month, int day, int year) {
        String dateToString = month + ":" + day + ":" + year;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM:dd:yyyy");
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateToString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date != null ? new SimpleDateFormat("EEEE").format(date).toUpperCase() : null;
    }

}