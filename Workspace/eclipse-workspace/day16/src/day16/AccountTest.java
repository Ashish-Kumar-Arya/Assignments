package day16;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AccountTest {
	private Account acc;
	@BeforeClass
	public static void setUpClass() {
		System.out.println("Before Class annotation called : Setting up the class level resources");
	}
	
	@Before
	public void setUp() {
		acc=new Account(5000.0);
		System.out.println("@Before annotation called for setting up the account for each test");
	}
	
	@Test
	@Ignore("Deposit is currently unavailable")
	public void testDeposit() {
		acc.deposit(1000.0);
		Assert.assertEquals(6000.0, acc.getBalanceAmount(), 0.0001);
	}
	
	@Test(timeout = 1)
	public void testWithdraw() {
		acc.withdraw(1000.0);
		Assert.assertEquals(4000.0, acc.getBalanceAmount(), 0.0001);
	}
	
	@Test(expected = NullPointerException.class)
	public void testExep() {
		String str=null;
		str.length();
	}
	
	@After
	public void tearDown() {
		System.out.println("Clean up process after each test");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("Releasing the class resources");
	}
}
