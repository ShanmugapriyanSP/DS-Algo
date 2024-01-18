package com.data.structures.algorithms.geek.recursion;

public class TowerOfHanoi {

    public static long towerOfHanoi(int n, Character fromRod, Character toRod, Character auxilaryRod) {
        if (n==1) {
            System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
            return 1;
        }
        long count = towerOfHanoi(n-1, fromRod, auxilaryRod, toRod);
        System.out.println("Move disk " + n + " from rod " + fromRod + " to rod " + toRod);
        count += towerOfHanoi(n-1, auxilaryRod, toRod, fromRod);
        return count + 1;

    }

    public static void main(String[] args) {
        System.out.println(towerOfHanoi(3, 'A', 'C', 'B'));
    }
}
