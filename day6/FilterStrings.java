
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterStrings {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Alex", "Brian");

        List<String> filteredNames = names.stream()
                                          .filter(name -> !name.startsWith("A"))
                                          .collect(Collectors.toList());

        System.out.println("Filtered List (excluding 'A'): " + filteredNames);
    }
}
