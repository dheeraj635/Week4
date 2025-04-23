
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.*;
import org.junit.jupiter.api.BeforeEach;


class MathOperations{
	public int divide(int a, int b) {
		if(b==0) {
			throw new ArithmeticException("Cant divide by Zero");
		}
		return a/b;
	}
}

public class MathOperationsTest {
	
	private MathOperations mathOperations;
	
	@BeforeEach
	public void setup() {
		mathOperations=new MathOperations();
	}
	
	@Test
    public void testDivideValid() {
        assertEquals(2, mathOperations.divide(10, 5), "10 divided by 5 should be 2");
    }
	
	@Test
	public void testDivideByZeroThrowsException() {
		assertThrows(ArithmeticException.class,()-> mathOperations.divide(10,0),"should thow Exception");
	}
}
