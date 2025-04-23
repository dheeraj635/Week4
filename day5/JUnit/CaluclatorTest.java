import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class Caluclator {
	public int add(int a,int b) {
		return a+b;
	}
	public int sub(int a,int b) {
		return a-b;
	}
	public int mul(int a,int b) {
		return a*b;
	}
	public int div(int a,int b) {
		if(b==0) {
			System.out.print("Cannot divide with zero");
		}
		return a/b;
	}
}
public class CaluclatorTest{
	private Caluclator caluclator;
	@BeforeEach
	public void setup() {
		caluclator=new Caluclator();
	}
	@Test
	public void testadd() {
		assertEquals(5,caluclator.add(2, 3),"2+3 is 5");
		assertEquals(10,caluclator.add(7, 3),"7+3 is 10");
	}
	@Test
	public void testsub() {
		assertEquals(5,caluclator.sub(15, 10),"15-10 is 5");
		assertEquals(10,caluclator.sub(40, 30),"40-30 is 10");
	}
	@Test
	public void testmul() {
		assertEquals(6,caluclator.mul(2, 3),"2*3 is 6");
		assertEquals(10,caluclator.mul(5,2),"5*2 is 10");
	}
	@Test
	public void testdiv() {
		assertEquals(2,caluclator.div(6, 3),"6/3 is 2");
		assertEquals(2,caluclator.div(10,5),"10/5 is 2");
	}
}