package com.data.structures.algorithms.leetcode;

import com.data.structures.algorithms.geek.arrays.CustomArrays;

public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        String longestSubString = String.valueOf(s.charAt(0));
        int longest = 1;
        for (int i = 1; i < s.length(); i++) {
            String character = String.valueOf(s.charAt(i));
            if (!longestSubString.contains(character)) {
                longestSubString += character;
            } else {
                longest = Math.max(longest, longestSubString.length());
                if (longestSubString.endsWith(character)) {
                    longestSubString = character;
                } else {
                    int index = longestSubString.lastIndexOf(character);
                    longestSubString = longestSubString.substring(index+1);
                    longestSubString += character;
                }
            }
            longest = Math.max(longest, longestSubString.length());
        }
        return longest;
    }


    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        int[] frequency = new int[128];
        int i=0;
        for (int j = 0; j < n; j++) {
            i = Math.max(frequency[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            frequency[s.charAt(j)] = j + 1;
            CustomArrays.printArray(frequency);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("anviaj"));
        System.out.println(lengthOfLongestSubstring1("anviaj"));
        String a = "abc";
        System.out.println(a.lastIndexOf("d"));
    }
}
