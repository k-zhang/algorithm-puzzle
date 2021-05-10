package com.algomind.puzzle.dayoftheprogrammer;

import java.util.Arrays;

public class DayOfTheProgrammer {
    private static final int[] days = new int[] {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int DAY = 256;

    public String dayOfProgrammer(int year) {
        Date dateResult;

        if(year < 1918) {
            dateResult = findJulianDate(year);
        }else if(year > 1918) {
            dateResult = findGeogianDate(year);
        }else{
            dateResult = find1918(year);
        }

        return dateResult.toString();
    }

    private static Date find1918(int year) {
        int daysInFeb = 15;
        Date date = workoutCalendarDate(year, daysInFeb);
        if(date.month == 2) date.day += 13;
        return date;
    }

    private static Date findJulianDate(int year) {
        int daysInFeb = year % 4 == 0 ? 29 : 28;
        return workoutCalendarDate(year, daysInFeb);
    }

    private static Date findGeogianDate(int year) {
        int daysInFeb = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0) ? 29 : 28;
        return workoutCalendarDate(year, daysInFeb);
    }

    private static Date workoutCalendarDate(int year, int daysInFeb) {
        int[] calendarDays = Arrays.copyOf(days, days.length);
        calendarDays[1] = daysInFeb;

        int month = 0;
        int remainDays = DAY;
        for(int i = 0 ; i < days.length ; i++) {
            if(remainDays < 0) {
                break;
            }
            remainDays -= calendarDays[i];
            month = i + 1;
        }

        return new Date(year, month, calendarDays[month - 1] + remainDays);
    }

    public static class Date {
        private int year;
        private int month;
        private int day;

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public String toString() {
            return String.format("%02d", day) + "." + String.format("%02d", month) + "." + String.format("%02d", year);
        }
    }
}
