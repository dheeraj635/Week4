
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemperatureConverter {
    
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class TemperatureConverterTest {
    private TemperatureConverter converter;

    @BeforeEach
    public void setup() {
        converter = new TemperatureConverter();
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0), 0.001, "0°C should be 32°F");
        assertEquals(212.0, converter.celsiusToFahrenheit(100), 0.001, "100°C should be 212°F");
        assertEquals(98.6, converter.celsiusToFahrenheit(37), 0.001, "37°C should be 98.6°F");
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32), 0.001, "32°F should be 0°C");
        assertEquals(100.0, converter.fahrenheitToCelsius(212), 0.001, "212°F should be 100°C");
        assertEquals(37.0, converter.fahrenheitToCelsius(98.6), 0.001, "98.6°F should be 37°C");
    }
}
