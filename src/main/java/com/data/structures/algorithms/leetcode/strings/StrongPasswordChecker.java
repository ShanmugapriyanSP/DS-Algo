package com.data.structures.algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class StrongPasswordChecker {

    public static void main(String[] args) {
//        System.out.println(strongPasswordChecker("a"));
//        System.out.println(strongPasswordChecker("aA1"));
//        System.out.println(strongPasswordChecker("aaa111"));
//        System.out.println(strongPasswordChecker("b1111"));
//        System.out.println(strongPasswordChecker("11112222"));
//        System.out.println(strongPasswordChecker("ABABABABABABABABABAB1"));
        System.out.println(strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"));
    }

    public static int strongPasswordChecker(String password) {
        final int MIN_LENGTH = 6;
        final int MAX_LENGTH = 20;

        int n = password.length();
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c))
                hasDigit = true;
            if (Character.isUpperCase(c))
                hasUpperCase = true;
            if (Character.isLowerCase(c))
                hasLowerCase = true;
        }

        int missingTypes = 0;
        if (!hasLowerCase) missingTypes++;
        if (!hasUpperCase) missingTypes++;
        if (!hasDigit) missingTypes++;

        // Count replacements and pattern types
        int replacements = 0;
        int oneSeq = 0, twoSeq = 0;

        for (int i = 2; i < n;) {
            if (password.charAt(i) == password.charAt(i - 1) && password.charAt(i) == password.charAt(i - 2)) {
                int len = 2;
                while (i < n && password.charAt(i) == password.charAt(i - 1)) {
                    len++;
                    i++;
                }
                replacements += len / 3;
                if (len % 3 == 0) oneSeq++;
                else if (len % 3 == 1) twoSeq++;
            } else {
                i++;
            }
        }

        if (n < MIN_LENGTH) {
            return Math.max(missingTypes, MIN_LENGTH - n);
        } else if (n <= MAX_LENGTH) {
            return Math.max(missingTypes, replacements);
        } else {
            int deletions = n - MAX_LENGTH;

            int remainingDeletions = deletions;

            // Prioritize deletions to reduce replacements
            int reduce = Math.min(remainingDeletions, oneSeq);
            replacements -= reduce;
            remainingDeletions -= reduce;

            reduce = Math.min(remainingDeletions, twoSeq * 2);
            replacements -= reduce / 2;
            remainingDeletions -= reduce;

            replacements -= remainingDeletions / 3;

            return deletions + Math.max(missingTypes, replacements);
        }
    }
}