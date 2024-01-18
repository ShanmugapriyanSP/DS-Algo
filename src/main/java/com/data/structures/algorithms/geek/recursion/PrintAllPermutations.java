package com.data.structures.algorithms.geek.recursion;

public class PrintAllPermutations {


    public static void permute(String s, int idx) {
        if (idx == s.length() - 1) {
            System.out.println(s);
            return;
        }

        for (int j = idx; j < s.length(); j++) {
            if (idx != j)
                s = swap(s, idx, j);
            permute(s, idx + 1);
            if (idx != j)
                s = swap(s, idx, j);
        }
        System.out.println("Final: " + s);
    }

    public static String swap(String s, int i, int j) {
        System.out.println("Before SWAP: " + s);

        char[] string = s.toCharArray();
        char temp = string[i];
        string[i] = string[j];
        string[j] = temp;
        System.out.println("After SWAP: " + String.valueOf(string));

        return String.valueOf(string);
    }

    public static void main(String[] args) {
        permute("ABC", 0);
    }
}
