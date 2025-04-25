
@FunctionalInterface
interface SquareCalculators {
    int calculateSquare(int number);

    default void printResult(int number) {
        int result = calculateSquare(number);
        System.out.println("The square of " + number + " is: " + result);
    }
}

public class SquareCalculator {
    public static void main(String[] args) {
       
        SquareCalculators calculator = num -> num * num;

        calculator.printResult(5);
        calculator.printResult(12);
    }
}
