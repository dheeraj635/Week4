
import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

public class FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";

        // Regex to find repeating words
        String regex = "\\b(\\w+)\\s+\\1\\b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        Set<String> repeatingWords = new HashSet<>();

        // Find and collect all repeating words
        while (matcher.find()) {
            repeatingWords.add(matcher.group(1));  // Group 1 is the repeating word
        }

        // Print repeating words
        System.out.println("Repeating words: " + String.join(", ", repeatingWords));
    }
}
