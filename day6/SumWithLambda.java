
@FunctionalInterface
interface SumInterface {
 int add(int a, int b);
}

public class SumWithLambda {
 public static void main(String[] args) {

     SumInterface sum = (a, b) -> a + b;

     int result = sum.add(10, 25);

     System.out.println("The sum is: " + result);
 }
}
