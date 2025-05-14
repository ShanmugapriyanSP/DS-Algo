package com.data.structures.algorithms.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval {

    public static void main(String[] args) {
        int[][] intervals = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int counter = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                counter++;
                prev = intervals[i - 1];
            }
        }
        return counter;
    }
}
