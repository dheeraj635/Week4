

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenateWithSpace = (str1, str2) -> str1 + " " + str2;

        String first = "Hello";
        String second = "World";

        String result = concatenateWithSpace.apply(first, second);

        System.out.println("Concatenated String: " + result);
    }
}
