package md5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data/md5/input"));
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> stringArray = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        Solution solution = new Solution();
        solution.solve(stringArray);
    }

    private void solve(List<String> stringArray) {
        stringArray.stream().map(this::digest).map(this::byteToString).forEach(System.out::println);
    }

    public byte[] digest(String value) {
        MessageDigest message;
        try {
            message = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        message.update(value.getBytes());
        return message.digest();
    }

    public String byteToString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte byt : bytes) {
            builder.append(String.format("%02x", byt));
        }
        return builder.toString();
    }

}