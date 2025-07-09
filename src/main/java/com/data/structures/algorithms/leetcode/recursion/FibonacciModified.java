package com.data.structures.algorithms.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciModified {

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fibonacciModified(0, 1, 6));
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static int fib(int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n == 0 || n == 1) {
            return n;
        }
        int res = fib(n-1) + fib(n-2);
        map.put(n, res);
        return res;
    }

    public static int fibonacciModified(int t1, int t2, int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n == t1 || n == t2) {
            return n;
        }
        int value1 = fibonacciModified(t1, t2, n - 1);
        int value2 = fibonacciModified(t1, t2, n - 2);
        int res = value1 + (value2 * value2);
        map.put(n, res);
        return res;
    }
}
