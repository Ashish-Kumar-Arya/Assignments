package assignments.day15.task7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConverter {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the date and time (yyyy-MM-dd HH:mm): ");
        String dateTimeInput=sc.nextLine();
        System.out.println("Enter the original timezone (e.g., Asia/Kolkata):");
        String originalTimeZone=sc.nextLine();
        System.out.println("Enter the target timezone (e.g., America/New_York):");
        String targetTimeZone=sc.nextLine();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime=LocalDateTime.parse(dateTimeInput, formatter);
        ZoneId originalZoneId=ZoneId.of(originalTimeZone);
        ZonedDateTime originalZonedDateTime=localDateTime.atZone(originalZoneId);
        ZoneId targetZoneId=ZoneId.of(targetTimeZone);
        ZonedDateTime targetZonedDateTime=originalZonedDateTime.withZoneSameInstant(targetZoneId);
        System.out.println("The date and time at "+targetTimeZone+" is "+targetZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }

}