import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

package day21;

public class CountWordInFiles {
        public static void main(String[] args) {
            String filePath = "input.txt";
            Map<String, Integer> wordCount = new HashMap<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
                    for (String word : words) {
                        if (!word.isEmpty()) {
                            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
                return;
            }

            List<Map.Entry<String, Integer>> sortedWords = wordCount.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .collect(Collectors.toList());

            System.out.println("Top 5 most frequent words:");
            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
}
