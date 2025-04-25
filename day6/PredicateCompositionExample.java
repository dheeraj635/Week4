
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateCompositionExample {
    public static void main(String[] args) {
        List<String> technologies = Arrays.asList(
            "JavaScript", "Java", "Python", "NodeJS", "AdvancedJava", "GoLang", "JavaEnterprise"
        );

        Predicate<String> lengthGreaterThan5 = str -> str.length() > 5;

        Predicate<String> containsJava = str -> str.contains("Java");

        Predicate<String> combinedPredicate = lengthGreaterThan5.and(containsJava);

        List<String> filteredList = technologies.stream()
                                                .filter(combinedPredicate)
                                                .collect(Collectors.toList());

        System.out.println("Filtered List: " + filteredList);
    }
}
