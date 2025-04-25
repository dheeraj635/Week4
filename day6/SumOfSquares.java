
import java.util.Arrays;
import java.util.List;

public class SumOfSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int sumOfSquares = numbers.stream()
                                  .filter(n -> n % 2 == 0)         
                                  .map(n -> n * n)                
                                  .reduce(0, (a, b) -> a + b);     

        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
