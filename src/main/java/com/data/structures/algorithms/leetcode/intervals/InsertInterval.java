package com.data.structures.algorithms.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] interval = {4,8};
//        int[][] intervals = {{1, 5}};
//        int[] interval = {2,7};
        int[][] inserted = insert(intervals, interval);
        print(inserted);
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        boolean inserted = false;
        for (int i = 1; i < intervals.length; i++) {
            if (!inserted && (Math.max(res.getLast()[1], res.getLast()[0]) > newInterval[0])) {
                int[] last = res.getLast();
                if (last[0] <= newInterval[1]) {
                    newInterval[1] = Math.max(newInterval[1], last[1]);
                    newInterval[0] = Math.min(newInterval[0], last[0]);
                    res.set(res.size() - 1, newInterval);
                } else {
                    res.set(res.size() - 1, newInterval);
                    res.add(last);
                }
                inserted = true;
            }

            if (Math.max(intervals[i][0], intervals[i][1]) < res.getLast()[1]) {
                continue;
            }

            if (intervals[i][0] <= res.getLast()[1]) {
                int[] interval = res.getLast();
                interval[1] = intervals[i][1];
                res.set(res.size() - 1, interval);
            } else {
                res.add(intervals[i]);
            }

        }
        if (!inserted) {
            if (Math.max(res.getLast()[1], res.getLast()[0]) > newInterval[0]) {
                int[] last = res.getLast();
                if (last[0] <= newInterval[1]) {
                    newInterval[1] = Math.max(newInterval[1], last[1]);
                    newInterval[0] = Math.min(newInterval[0], last[0]);
                    res.set(res.size() - 1, newInterval);
                } else {
                    res.set(res.size() - 1, newInterval);
                    res.add(last);
                }
            }
        }

        int[][] result = new int[res.size()][2];
        int i = 0;
        for (int[] intervalMerged: res) {
            result[i++] = intervalMerged;
        }

        print(result);
        return result;
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

