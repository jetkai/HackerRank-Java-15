package reflection;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.printMethods();
    }

    public void printMethods() {
        Class<Student> student = Student.class;
        Method[] methods = student.getDeclaredMethods();
        String methodNames = Arrays.stream(methods)
                .map(Method::getName)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.joining("\n"));
        System.out.printf("%s", methodNames);
    }
}

class Student {

    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}