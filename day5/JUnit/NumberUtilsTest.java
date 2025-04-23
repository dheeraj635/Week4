
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberUtils {

    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

public class NumberUtilsTest {

    private NumberUtils numberUtils = new NumberUtils();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6}) // Test values for even numbers
    public void testIsEven_withEvenNumbers(int number) {
        assertTrue(numberUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9}) // Test values for odd numbers
    public void testIsEven_withOddNumbers(int number) {
        assertFalse(numberUtils.isEven(number), number + " should be odd");
    }
}
