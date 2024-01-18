package com.data.structures.algorithms.scripts;

public class Sqrt {

    public int sqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            System.out.println("BEFORE -- LEFT - " + left + ", RIGHT - " + right + ", MID - " + mid);
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1))
                    return mid;
                left = mid + 1;
            }
            System.out.println("AFTER -- LEFT - " + left + ", RIGHT - " + right + ", MID - " + mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().sqrt(361));
    }
}
