package com.data.structures.algorithms.geek.recursion;

public class RopeCutting {

    public static int maxCuts(int n, int a, int b, int c) {
        if (n == 0) {
//            System.out.println("RETURN 0: n = " + n + " a = " + a + " b = " + b + " c = " + c);
            return 0;
        }
        if (n < 0) {
//            System.out.println("RETURN -1: n = " + n + " a = " + a + " b = " + b + " c = " + c);

            return -1;
        }
//        System.out.println("BEFORE: n = " + n + " a = " + a + " b = " + b + " c = " + c);

//        int res = Math.max(
//                Math.max(
//                        maxCuts(n - a, a, b, c),
//                        maxCuts(n - b, a, b, c)
//                ),
//                maxCuts(n - c, a, b, c)
//        );
        int res1 = maxCuts(n - a, a, b, c);
        System.out.println("n = " + n + " res1 = " + res1);
        int res2 = maxCuts(n - b, a, b, c);
        System.out.println("n = " + n + " res2 = " + res2);
        int res3 = maxCuts(n - c, a, b, c);
        System.out.println("n = " + n + " res3 = " + res3);


        int res = Math.max(Math.max(res1, res2), res3);

        if (res == -1) {
//            System.out.println("AFTER RETURN -1: n = " + n + " a = " + a + " b = " + b + " c = " + c + " res = " + res);

            return -1;
        }
        System.out.println("Final res = " + (res+1));
        return res + 1;
    }

    public static void main(String[] args) {
        System.out.println(maxCuts(5, 2, 5, 1));
    }
}
