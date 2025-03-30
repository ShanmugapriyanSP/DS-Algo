package com.data.structures.algorithms.leetcode;


import java.util.*;

public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int res = 0;
        int windowLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            windowLength = (right - left) + 1;
            if (windowLength - getMax(map) <= k) {
                res = Math.max(res, windowLength);
            } else {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            right++;
        }

        return res;
    }

    public static int getMax(HashMap<Character, Integer> map) {
        int largest = 0;
        for (int v: map.values()) {
            largest = Math.max(v, largest);
        }
        return largest;
    }


    public static int characterReplacement1(String s, int k) {
        if (s.length() <=1) return s.length();
        int longest = 1;
        int[] frequency = new int[26];

        int l = 0, r = 0;
        while(r < s.length()) {
            frequency[s.charAt(r) - 'A'] += 1;
            int windowLength = r - l + 1;
            int maxValue = getMaxFrequency(frequency);
            if (windowLength - maxValue <= k) {
                longest = Math.max(longest, windowLength);
            } else {
                frequency[s.charAt(l) - 'A'] -= 1;
                l++;
            }
            r++;
        }
        return longest;
    }

    public static int getMaxFrequency(int[] arr) {
        int max = 0;
        for (int a : arr)
            max = Math.max(a, max);
        return max;
    }
    public static void main(String[] args) {
        System.out.println(characterReplacement1("AABABBA", 1));
    }
}
