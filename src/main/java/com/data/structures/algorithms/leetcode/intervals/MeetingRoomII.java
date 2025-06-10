package com.data.structures.algorithms.leetcode.intervals;

import java.util.*;

public class MeetingRoomII {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 10));
        intervals.add(new Interval(10, 20));
        intervals.add(new Interval(20, 30));
        intervals.add(new Interval(30, 40));
        intervals.add(new Interval(40, 50));
        intervals.add(new Interval(50, 60));
        intervals.add(new Interval(60, 70));
        intervals.add(new Interval(70, 80));
        intervals.add(new Interval(80, 90));
        intervals.add(new Interval(90, 100));
        intervals.add(new Interval(0, 100));
        intervals.add(new Interval(10, 90));
        intervals.add(new Interval(20, 80));
        intervals.add(new Interval(30, 70));
        intervals.add(new Interval(40, 60));

        System.out.println(minMeetingRooms(intervals));
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() < 2)
            return intervals.size();

        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

        int counter = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < intervals.size(); i++) {
            if (set.contains(i))
                continue;
            Interval prev = intervals.get(i);
            for (int j = i+1; j < intervals.size(); j++) {

                if (set.contains(j)) {
                    continue;
                }
                if (prev.end <= intervals.get(j).start) {
                    set.add(i);
                    set.add(j);
                    prev = intervals.get(j);
                }
            }
            counter++;
        }
        return counter;
    }
}

class Interval {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return start + "," + end;
    }
}
