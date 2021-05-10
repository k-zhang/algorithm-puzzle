package com.algomind.puzzle.repeatedstring;

public class RepeatedString {
    public long repeatedString(String s, long n) {
        int length = s.length();
        long repeat = n / length;
        long remainder = n % length;

        long numberOfAInString = s.chars().filter(c -> c == 'a').count();

        String trailer = s.substring(0, (int)remainder);

        long numberOfAInTrailer = trailer.chars().filter(c -> c == 'a').count();

        return numberOfAInString * repeat + numberOfAInTrailer;
    }
}
