package com.algomind.puzzle.extralongfactorials;

import java.math.BigInteger;

public class ExtraLongFactorials {
    BigInteger extraLongFactorials(int n) {
        if(n == 0) {
            return BigInteger.ZERO;
        }else {
            BigInteger factorial = BigInteger.ONE;
            while (n > 1) {
                factorial = factorial.multiply(BigInteger.valueOf(n));
                n--;
            }

            return factorial;
        }
    }
}
