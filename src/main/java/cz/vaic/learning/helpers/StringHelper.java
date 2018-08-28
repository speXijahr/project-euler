package cz.vaic.learning.helpers;

public class StringHelper {
    public static boolean isPalindrome(long number) {
        String toTest = String.valueOf(number);
        for (int i = 0; i <toTest.length()/2 ; i++) {
            if(toTest.charAt(i) != toTest.charAt(toTest.length()-(i+1)) ) {
                return false;
            }
        }
        return true;
    }
}
