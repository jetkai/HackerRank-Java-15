package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/sort/input"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();
        stringArray.remove(0); //remove length, not needed

        Solution solution = new Solution();
        solution.solve(stringArray);
    }

    private void solve(List<String> stringArray) {
        List<Student> students = new ArrayList<>();

        for(String string : stringArray) {
            String[] values = string.split(" ");
            if(values.length != 3) {
                continue;
            }
            int id = Integer.parseInt(values[0]);
            String name = values[1];
            double cgpa = Double.parseDouble(values[2]);
            students.add(new Student(id, name, cgpa));
        }

        Comparator<Student> comparator = Comparator.naturalOrder();
        List<String> sortedNameArray = students.stream()
                .sorted(comparator)
                .map(Student::getName)
                .collect(Collectors.toList());

        sortedNameArray.forEach(System.out::println);
    }

    static class Student implements Comparable<Student> {
        private final int id;
        private final String name;
        private final double cgpa;

        public Student(int id, String name, double ccpa) {
            this.id = id;
            this.name = name;
            this.cgpa = ccpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }

        @Override
        public int compareTo(Student student) {
            return cgpa == student.cgpa
                    ? Comparator.comparing(Student::getName).compare(this, student)
                    : Comparator.comparingDouble(Student::getCgpa).compare(student, this);
        }
    }

}