package com.eight;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
 
import static java.time.LocalDateTime.of;
 
public class DurationAndPeriod {
 
    public static void main(String[] args) {
        durationExample();
        periodExample();
    }
 
    private static void durationExample() {
        Duration oneHours = Duration.ofHours(1);
        System.out.println(oneHours.getSeconds() + " seconds");
 
        // Test Duration.between
        System.out.println("### Duration.between ###");
 
        LocalDateTime oldDate = of(2018, Month.AUGUST, 31, 10, 20, 55);
        LocalDateTime newDate = of(2018, Month.NOVEMBER, 9, 10, 21, 56);
 
        System.out.println(oldDate);
        System.out.println(newDate);
 
        //count seconds between dates
        Duration duration = Duration.between(oldDate, newDate);
 
        System.out.println(duration.getSeconds() + " seconds");
    }
 
    public static void periodExample() {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1988, Month.APRIL, 22);
        Period p = Period.between(birthday, today);
        System.out.println("### Period Example ###");
        System.out.println("You are " + p.getYears() + " years, " + p.getMonths() +
                " months, and " + p.getDays() +
                " days old.");
    }
}
