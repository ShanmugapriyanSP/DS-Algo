package com.data.structures.algorithms.leetcode;


import java.util.Collections;
import java.util.Stack;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class LinkedLists {

    public static void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while(second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        second = prev;
        while(first != null && second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode prev = merged;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        if (list1 != null) prev.next = list1;
        if (list2 != null) prev.next = list2;
        return merged.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length <= 1) return new ListNode();

        while (lists.length > 1) {
            int size = lists.length % 2 == 0 ? lists.length/2 : lists.length / 2 + 1;
            ListNode[] mergeLists = new ListNode[size];
            int counter = 0;
            for (int i = 0; i < lists.length; i=i+2) {
                System.out.println(i);
                ListNode list1 = lists[i];
                ListNode list2 = i + 1 < lists.length ? lists[i+1] : null;
                mergeLists[counter++] = mergeTwoLists(list1, list2);
            }
            lists = mergeLists;
        }

        return lists[0];
    }

    public static void reorderList2(ListNode head) {

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reversed = slow.next;
        slow.next = null;
        ListNode prev = null;

        while (reversed != null) {
            ListNode temp = reversed.next;
            reversed.next = prev;
            prev = reversed;
            reversed = temp;
        }

        ListNode first = head;
        ListNode second = prev;

        while(first != null && second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

   }

    public static void main(String[] args) {
//        ListNode head = new ListNode(
//                1, new ListNode(2, new ListNode(3, new ListNode(4)))
//        );
//        try {
//            reorderList(head);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
//        Runtime.getRuntime();
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5, new ListNode(8))));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
//        lists[0] = new ListNode(2, new ListNode(6));
        reorderList2(lists[0]);


        ListNode merged = mergeKLists(lists);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
