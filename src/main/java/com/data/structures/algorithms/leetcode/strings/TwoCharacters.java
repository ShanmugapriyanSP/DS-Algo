package com.data.structures.algorithms.leetcode.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoCharacters {

    public static void main(String[] args) {
        System.out.println(alternate("asdcbsdcagfsdbgdfanfghbsfdab"));
    }

    public static int alternate(String s) {
        return find(s);
    }

    public static int find(String s) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c: s.toCharArray()) {
            uniqueChars.add(c);
        }
        List<Character> charList = new ArrayList<>(uniqueChars);
        int res = 0;
        for (int i = 0; i < charList.size(); i++) {
            for (int j = i + 1; j < charList.size(); j++) {

                String temp = s.replaceAll(String.format("[^%c%c]", charList.get(i), charList.get(j)), "");
                if (!hasRepeatingChars(temp)) {
                    res = Math.max(res, temp.length());
                }
            }
        }
        return res;
    }

    public static boolean hasRepeatingChars(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                return true;
            }
        }
        return false;
    }



}
