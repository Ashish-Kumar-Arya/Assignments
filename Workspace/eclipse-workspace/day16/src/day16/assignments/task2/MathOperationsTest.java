package day16.assignments.task2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MathOperationsTest {
	
	static ArrayList<Integer> al;
	
	@BeforeClass
	public static void listInitiate() {
		al=new ArrayList<>();
	}
	
	@Before
	public void addValues() {
		al.add(5);
		al.add(10);
	}
	
	@Test
	public void addTest() {
		assertEquals(15, MathOperations.add(al.get(0), al.get(1)));
	}
	
	@Test
	public void subTest() {
		assertEquals(-5, MathOperations.sub(al.get(0), al.get(1)));
	}
	
	@Test
	public void mulTest() {
		assertEquals(50, MathOperations.mul(al.get(0), al.get(1)));
	}
	
	@Test
	public void divTest() {
		assertEquals(0.5, MathOperations.div((double)al.get(0), (double)al.get(1)), .0001);
	}
	
	@After
	public void emptyList() {
		al.clear();
	}
	
	@AfterClass
	public static void nullList() {
		al=null;
	}
}
