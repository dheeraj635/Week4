
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class WordFrequencyAnalyser {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog. The fox was quick and the dog was lazy.";

        List<String> words = Arrays.stream(text
                .toLowerCase()
                .replaceAll("[^a-z\\s]", "") 
                .split("\\s+")) 
                .collect(Collectors.toList());

        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int N = 3; 
        List<Map.Entry<String, Long>> topWords = wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(N)
                .collect(Collectors.toList());

        System.out.println("Top " + N + " most frequent words:");
        topWords.forEach(entry ->
                System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
