package dataMining;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\\\Users\\\\1\\\\IdeaProjects\\\\MyProject\\\\src\\\\dataMining\\\\transactions.csv"));
        HashMap<String, Integer> map = new HashMap();

        while (reader.ready()) {
            String[] string = reader.readLine().split(";");
            if (map.get(string[0]) == null) {
                map.put(string[0], 1);
            } else {
                map.put(string[0], map.get(string[0]) + 1);
            }
        }
        reader.close();

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);


    }
}
