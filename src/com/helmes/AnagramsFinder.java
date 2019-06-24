package com.helmes;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class AnagramsFinder {

    private static final int BASE_NUMBER = 113;

    public Collection collectAnagrams(String[] dictionary, String searchAnagramsFor) {
        char[] chars = searchAnagramsFor.toLowerCase().toCharArray();
        int checkSum = countCheckSum(chars);

        return Arrays
                .stream(dictionary)
                .parallel()
                .filter(s -> s.length() == chars.length)
                .filter(s -> isAnagram(s, checkSum))
                .collect(Collectors.toList());
    }

    private boolean isAnagram(String s, int checkSum) {
        return checkSum == countCheckSum(s);
    }

    private int countCheckSum(String s) {
        return countCheckSum(s.toLowerCase().toCharArray());
    }

    private int countCheckSum(char[] chars) {
        int checkSum = 1;
        for (char c : chars) {
            checkSum *= c * BASE_NUMBER;
        }
        return checkSum;
    }
}
