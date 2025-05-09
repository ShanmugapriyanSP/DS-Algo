package com.data.structures.algorithms.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        int[][] merged = merge(intervals);
        print(merged);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.getLast();
            if (intervals[i][0] <= last[1]) {
                if (intervals[i][1] >= last[0]) {
                    last[0] = Math.min(intervals[i][0], last[0]);
                    last[1] = Math.max(intervals[i][1], last[1]);
                    res.set(res.size() - 1, last);
                } else {
                    res.set(res.size() - 1, intervals[i]);
                    res.add(last);
                }
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private static void print(int[][] interval) {
        for(int i = 0; i < interval.length; i++) {
            for (int n: interval[i]) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
