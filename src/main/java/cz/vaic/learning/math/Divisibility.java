package cz.vaic.learning.math;

import java.util.ArrayList;

public class Divisibility {

    public static boolean isDivisibleByPositiveNumbersUnder(long number,int limit) {
        for (int i = 2; i < limit ; i++) {
            if(number % i != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(long n) {
        if (n == 2) return true;
        if (n == 3) return true;
        if (n % 2 == 0) return false;
        if (n % 3 == 0) return false;
        long i = 5;
        long w = 2;

        while (i * i <= n) {
            if (n % i == 0) return false;

            i += w;
            w = 6 - w;
        }
        return true;
    }

    public static ArrayList<Long> getPrimeFactors(long number) {
        ArrayList<Long> primeFactors = new ArrayList<>();
        long factor = 2;
        long remainder = number;
        while(remainder > 1) {
            if(remainder % factor == 0) {
                primeFactors.add(factor);
                remainder /= factor;
            } else {
                factor++;
            }
        }
        return primeFactors;
    }
}
