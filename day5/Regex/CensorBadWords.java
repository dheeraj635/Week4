
import java.util.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");

        // Loop through each bad word and replace it with "****"
        for (String word : badWords) {
            input = input.replaceAll("(?i)\\b" + word + "\\b", "****");  // (?i) makes the regex case-insensitive
        }

        System.out.println(input);
    }
}

