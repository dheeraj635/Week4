
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Double, Double> areaOfCircle = radius -> Math.PI * radius * radius;

        double radius = 7.0;
        double area = areaOfCircle.apply(radius);

        System.out.println("Radius: " + radius);
        System.out.println("Area of the circle: " + area);
    }
}

