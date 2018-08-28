package cz.vaic.learning.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fibonnaci {
    public static double getNthTerm(int n) {
//        return Math.ceil((Math.pow((1+Math.sqrt(5))/2,n)) /Math.sqrt(5) + 1/2);
//        return Math.floor(Math.pow((1+Math.sqrt(5))/2,n) + 2 * Math.pow((1-Math.sqrt(5))/2,n));
        return 0;

    }

    public static List<Integer> getSequence(int limit) {
        HashMap<Integer,Integer> fibo = new HashMap<>();
        fibo.put(1,1);
        int term = 2;
        int i = 2;
        while (term < limit) {
            fibo.put(i++,term);
            term = fibo.get(i-2)+fibo.get(i-1);
        }
        return new ArrayList<>(fibo.values());
    }
}
