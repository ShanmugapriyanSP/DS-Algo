package com.data.structures.algorithms.leetcode;

import java.util.*;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        int left = 0, right = 0;
        String res = "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> tempMap = new HashMap<>();
        for (char c: t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int tempRes = 0;
        while (right < s.length()) {

            tempMap.put(s.charAt(right), tempMap.getOrDefault(s.charAt(right), 0) + 1);
            if (tMap.containsKey(s.charAt(right)) && Objects.equals(tempMap.get(s.charAt(right)), tMap.get(s.charAt(right)))) {
                tempRes++;
            }


            while(tempRes == tMap.size()) {
                if (res.length() > (right-left+1) || res.isEmpty()) {
                    res = s.substring(left, right+1);
                }
                tempMap.put(s.charAt(left), tempMap.get(s.charAt(left))-1);
                if (tMap.containsKey(s.charAt(left)) && tempMap.get(s.charAt(left)) < tMap.get(s.charAt(left))) {
                    tempRes--;
                }
                left++;
            }

            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "b"));
        System.out.println(minWindow("aa", "aa"));
    }
}
