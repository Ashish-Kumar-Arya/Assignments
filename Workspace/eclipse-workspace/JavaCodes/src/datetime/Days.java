package datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Days{
	public static void main(String[] args) {
		LocalDate firstDate=LocalDate.now();
		LocalDate secondDate=LocalDate.of(2027, 11, 2);
		long d= ChronoUnit.DAYS.between(firstDate, secondDate);
		System.out.println("Fitst Date: "+firstDate+" Second Date: "+secondDate);
		System.out.println("Days Between: "+d);
	}
}
