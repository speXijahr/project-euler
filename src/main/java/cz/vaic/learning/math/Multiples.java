package cz.vaic.learning.math;

import java.util.*;

public class Multiples {
    public static List<Integer> getMultiplesOf(int limit, int... multiplesBase) {
        Set<Integer> multiples = new HashSet<>();
        for (int base : multiplesBase) {
            for (int i = 1; i * base < limit; i++) {
                multiples.add(i*base);
            }
        }
        return new LinkedList<>(multiples);
    }

    public static List<Integer> threeDigitMultiples() {
        HashSet<Integer> multiples = new HashSet<>();
        for(int i = 100;i<1000;i++) {
            for (int j = 100; j <1000 ; j++) {
                multiples.add(i*j);
            }
        }
        return new LinkedList<>(multiples);
    }
}
