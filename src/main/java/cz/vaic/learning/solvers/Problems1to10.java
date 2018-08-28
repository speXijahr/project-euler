package cz.vaic.learning.solvers;

import cz.vaic.learning.IO.FileHelper;
import cz.vaic.learning.helpers.StringHelper;
import cz.vaic.learning.math.Divisibility;
import cz.vaic.learning.math.Fibonnaci;
import cz.vaic.learning.math.Multiples;

import java.math.BigInteger;
import java.util.ArrayList;

public class Problems1to10 {
    public static double problem1() {
        return Multiples.getMultiplesOf(1000,3,5)
                .stream()
                .mapToInt(n -> n)
                .sum();

    }

    public static double problem2() {
        return Fibonnaci.getSequence(4000000).stream()
                .filter(n-> n % 2 == 0)
                .mapToInt(n ->n)
                .sum();
    }

    public static long problem3() {
        long x  = 600851475143L;
        ArrayList<Long> primeFactors = Divisibility.getPrimeFactors(x);
        return primeFactors.stream()
                .max(Long::compareTo)
                .get();
    }

    public static int problem4() {
        return Multiples.threeDigitMultiples()
                .stream()
                .filter(StringHelper::isPalindrome)
                .max(Integer::compareTo)
                .get();
    }

    public static long problem5() {
        for (long i = 20;; i+=20) {
            if(Divisibility.isDivisibleByPositiveNumbersUnder(i,20)) {
                return i;
            }
        }
    }

    public static double problem6() {
        long sumOfSquares = 0,squareOfSums = 0;
        for (int i = 1; i <=100 ; i++) {
            sumOfSquares += Math.pow(i,2);
            squareOfSums += i;
        }
        return Math.pow(squareOfSums,2) - sumOfSquares;
    }

    public static long problem7() {
        int counter = 0;
        for (long i = 2; ; i++) {
            if(Divisibility.isPrime(i)) {
                counter++;
                if(counter == 10001) {
                    return i;
                }
            }
        }

    }

    public static long problem8() {
        String filePath = "src/main/resources/problem8input.txt";
        String fileInput = FileHelper.readFileAsString(filePath);
        return findMaxProductInNdigitNumbers(4,fileInput);
    }

    private static long findMaxProductInNdigitNumbers(int nDigits,String fileInput) {
        long maxProduct = 0;
        int digits = nDigits;
        while(nDigits != 1000) {
            String nDigitNumber = fileInput.substring(nDigits - digits,nDigits);
            long product = getStringProduct(nDigitNumber);
            if (product > maxProduct) {
                maxProduct = product;
            }
            nDigits++;
        }
        return maxProduct;
    }

    private static long getStringProduct(String nDigitNumber) {
        long product = 0;
        for(char digit : nDigitNumber.toCharArray()) {
            if(product == 0) {
                product = Character.getNumericValue(digit);
            } else {
                product *= Character.getNumericValue(digit);
            }
        }
        return product;
    }

    public static long problem9() {
        for (int i = 0;; i++) {
            for (int j = i+1; j <1000; j++) {
                for (int k = j+1; k < 1000; k++) {
                    if(i+j+k == 1000 && Math.pow(i,2) + Math.pow(j,2) != Math.pow(k,2)) {
                        return i*j*k;
                    }
                }
            }
        }
    }

    public static BigInteger problem10() {
        BigInteger sum = new BigInteger("0");
        for (int i = 2; i < 2000000 ; i++) {
            if(Divisibility.isPrime(i)) {
                sum = sum.add(new BigInteger(Long.toString(i)));
            }
        }
        return sum;
    }

}
