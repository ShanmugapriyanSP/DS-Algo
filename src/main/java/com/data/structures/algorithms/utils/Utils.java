package com.data.structures.algorithms.utils;

import java.util.Collection;

public class Utils {

    public static <T> void print(T obj) {
        System.out.println(obj);
    }

    public static <T> void printArray(T[] obj) {
        for (Object ob: obj) {
            System.out.print(ob + " ");
        }
    }

    public static <T> void printList(Collection<T> obj) {
        for (Object ob: obj) {
            System.out.print(ob + " ");
        }
    }
}
