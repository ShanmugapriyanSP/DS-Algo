package com.data.structures.algorithms.leetcode.linkedlist;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(
            1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))
        );
        print(head);
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        print(reverseLinkedList.reverseList(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    private static void print(ListNode head) {
        if (head == null)
            return;
        System.out.println(head.val);
        print(head.next);
    }
}
