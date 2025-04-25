
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "java", "world", "lambda");

        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());

        words.forEach(printUpperCase);
    }
}
