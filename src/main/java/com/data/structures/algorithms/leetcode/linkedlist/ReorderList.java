package com.data.structures.algorithms.leetcode.linkedlist;

public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(
                1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))
        );
        reorderList(head);
        print(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null)
            return;

        ListNode midPoint = getMidPoint(head);
        ListNode l2 = reverse(midPoint);
        ListNode l1 = head;

        mergeListAlternately(l1, l2);
    }

    private static ListNode getMidPoint(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midPoint = slow.next;
        slow.next = null;

        return midPoint;
    }

    private static ListNode reverse(ListNode head) {
        ListNode reversed = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }
        return reversed;
    }

    private static void mergeListAlternately(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
            l1.next = l2;
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }


    private static void print(ListNode head) {
        if (head == null)
            return;
        System.out.println(head.val);
        print(head.next);
    }

}
