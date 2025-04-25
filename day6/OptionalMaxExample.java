
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalMaxExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 8, 21, 3);

        Optional<Integer> maxOptional = numbers.stream().max(Integer::compareTo);

        if (maxOptional.isPresent()) {
            System.out.println("Maximum value: " + maxOptional.get());
        } else {
            System.out.println("The list is empty. No maximum value.");
        }
    }
}
