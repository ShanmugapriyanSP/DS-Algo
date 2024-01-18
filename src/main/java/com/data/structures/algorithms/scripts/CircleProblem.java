package com.data.structures.algorithms.scripts;

import java.util.ArrayList;
import java.util.List;

public class CircleProblem {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            myList.add(i);
        }

        int pos = 0;
        while (myList.size() > 1) {

            pos ++;

            pos %= myList.size();


            myList.remove(pos);

            System.out.println(myList);
        }

        System.out.println(myList.get(0));
    }
}
