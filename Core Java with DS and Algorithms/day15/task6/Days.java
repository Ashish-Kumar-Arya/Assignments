package assignments.day15.task6;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Days {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Enter 1st date int the format yyyy-MM-dd");
        String s1=sc.nextLine();
        System.out.println("Enter 2 date int the format yyyy-MM-dd");
        String s2=sc.nextLine();
        LocalDate date1=LocalDate.parse(s1,formatter);
        LocalDate date2=LocalDate.parse(s2,formatter);
        long days=Math.abs(ChronoUnit.DAYS.between(date1, date2));
        System.out.println("Number of days between dates "+date1+" and "+date2+" is "+days);
    }
}