
import java.util.regex.*;

public class ExtractLanguages {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        
        String regex = "\\b(Java|Python|JavaScript|Go|C\\+\\+|Ruby|Swift|C#|PHP|Perl)\\b";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        StringBuilder languages = new StringBuilder();
        
        // Find and extract all matches
        while (matcher.find()) {
            languages.append(matcher.group()).append(", ");
        }

        // Remove the trailing comma and space
        if (languages.length() > 0) {
            languages.setLength(languages.length() - 2);
        }
        
        System.out.println("Extracted programming languages: " + languages);
    }
}

