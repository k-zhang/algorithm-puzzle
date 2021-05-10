package com.algomind.puzzle.finddigits;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindDigits {
    int findDigits(int n) {
        String[] digitString = String.valueOf(n).split("");
        List<Integer> digits = Arrays.stream(digitString).map(Integer::parseInt).collect(Collectors.toList());
        return (int)digits.stream().filter(d -> d != 0).filter(d -> n % d == 0).count();
    }
}
