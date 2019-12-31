package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws ParseException {
        calculateTimeBetweenTwoDates();
//        calculateTimeBetweenDatesAndHours();
    }

    private static void calculateTimeBetweenDatesAndHours() {
        LocalDateTime d1 = LocalDateTime.now();
        LocalDateTime d2 = LocalDateTime.parse("20/01/01 00:00:00", DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss"));

        long days = d1.until(d2, ChronoUnit.DAYS);
        d1 = d1.plusDays(days);
        long hours = d1.until(d2, ChronoUnit.HOURS);
        d1 = d1.plusHours(hours);
        long minutes = d1.until(d2, ChronoUnit.MINUTES);
        d1 = d1.plusMinutes(minutes);
        long seconds = d1.until(d2, ChronoUnit.SECONDS);

        System.out.println(days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds.");
    }

    public static void calculateTimeBetweenTwoDates () {
        SimpleDateFormat sdf = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss", Locale.ENGLISH);
        Calendar calendar = new GregorianCalendar(2020, Calendar.JANUARY , 1);

        Date firstDate = calendar.getTime();
        System.out.println("New Year -> "+sdf.format(firstDate));

        Date secondDate = Calendar.getInstance().getTime();
        System.out.println("now -> " +sdf.format(secondDate));

        long days = ChronoUnit.DAYS.between(secondDate.toInstant(), firstDate.toInstant());
        long hours = ChronoUnit.HOURS.between(secondDate.toInstant(), firstDate.toInstant());
        long minutes = ChronoUnit.MINUTES.between(secondDate.toInstant(), firstDate.toInstant());
        long seconds = ChronoUnit.SECONDS.between(secondDate.toInstant(), firstDate.toInstant());

        minutes -= (hours * 60);
        seconds -= ((minutes + (hours * 60)) * 60);

        System.out.println(days + " days " + hours + " hours " + minutes + " minutes " + seconds + " seconds.");

      /*  long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
      */

    }
}
