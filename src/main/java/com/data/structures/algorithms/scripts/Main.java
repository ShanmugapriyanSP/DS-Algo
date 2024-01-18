package com.data.structures.algorithms.scripts;

import com.data.structures.algorithms.leetcode.LongestCommonPrefix;

public class Main {

    public static void main(String[] args) {
        String prefix = new LongestCommonPrefix().horizontalScanning(new String[]{"flower","flow","flight"});
        System.out.println(prefix);
    }
}
