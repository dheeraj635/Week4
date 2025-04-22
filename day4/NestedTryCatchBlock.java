import java.util.Scanner;

public class NestedTryCatchBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {10, 20, 30, 40, 50};

        System.out.print("Enter index: ");
        int index = scanner.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        try {
            try {
                int element = array[index];
                try {
                    int result = element / divisor;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Cannot divide by zero!");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } finally {
            scanner.close();
        }
    }
}
