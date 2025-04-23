
import java.util.regex.*;

public class ExtractCurrency {
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";

        String regex = "(\\$?\\d+(?:\\.\\d{2})?)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuilder currencies = new StringBuilder();

        // Find and extract all matches
        while (matcher.find()) {
            currencies.append(matcher.group()).append(", ");
        }

        // Remove the trailing comma and space
        if (currencies.length() > 0) {
            currencies.setLength(currencies.length() - 2);
        }

        System.out.println("Extracted currency values: " + currencies);
    }
}

