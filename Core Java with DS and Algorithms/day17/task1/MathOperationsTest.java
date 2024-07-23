package day16.assignments.task1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathOperationsTest {
	
	@Test
	public void addTest() {
		assertEquals(5, MathOperations.add(3,2));
	}
	
	@Test
	public void subTest() {
		assertEquals(5, MathOperations.sub(8,3));
	}
	
	@Test
	public void mulTest() {
		assertEquals(6, MathOperations.mul(3,2));
	}
	
	@Test
	public void divTest() {
		assertEquals(2.5, MathOperations.div(5.0,2.0),0.0001);
	}
	
}
