package day16.assignments.task3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilTest {
	@Test
	public void reverseTest() {
		assertEquals("hsihsa",StringUtil.reverse("ashish"));
	}
	
	@Test
	public void isPalindromeTest() {
		assertTrue(StringUtil.isPalindrome("nitin"));
	}
	
	@Test
	public void containsDigit() {
		assertFalse(StringUtil.containsDigit("Java, Python"));
	}
}
