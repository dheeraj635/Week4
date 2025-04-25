
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondMostFrequentWord {
    public static void main(String[] args) {
        String text = "apple banana apple orange banana apple orange orange banana apple";

        List<String> words = Arrays.stream(text.split("\\s+")) 
                .collect(Collectors.toList());

        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1) 
                .limit(1) 
                .forEach(entry -> System.out.println("Second Most Frequent Word: " + entry.getKey() + " -> " + entry.getValue()));
    }
}
