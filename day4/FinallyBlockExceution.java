import java.util.Scanner;

public class FinallyBlockExceution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        } finally {
            System.out.println("Operation completed");
        }
        scanner.close();
    }
}
