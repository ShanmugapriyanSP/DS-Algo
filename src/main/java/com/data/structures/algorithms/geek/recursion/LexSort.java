package com.data.structures.algorithms.geek.recursion;

import java.util.ArrayList;
import java.util.List;

public class LexSort {


        public static void subset(String s, String curr, int i, ArrayList<String> results) {
            if (i == s.length()) {
                results.add(curr);
                return;
            }
            subset(s, curr, i + 1, results);
            subset(s, curr + s.charAt(i), i + 1, results);
        }
        //Function to return the lexicographically sorted power-set of the string.
        static ArrayList<String> powerSet(String s)
        {
            ArrayList<String> results = new ArrayList<String>();
            subset(s, "", 0, results);
            return results;
        }

    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }

}
