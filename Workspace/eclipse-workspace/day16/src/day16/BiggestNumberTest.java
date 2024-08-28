package day16;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BiggestNumberTest {
	
	@Test
	public void testBiggest() {
		int arr[]= {12,3,7,8,15,12,11};
		assertEquals(15,BiggestNumber.biggest(arr));
	}
}