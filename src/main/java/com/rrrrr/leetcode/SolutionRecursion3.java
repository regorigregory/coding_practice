/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

/**
 *
 * @author Madero Padero
 */
public class SolutionRecursion3 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseOrderRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastHead = reverseOrderRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return lastHead;

    }

    public static ListNode reverseOrderLoop(ListNode head) {
        ListNode currentHead = head;
        ListNode lastHead = head;

        ListNode nextReference = head.next;
        ListNode savePointer = null;
        int counter = 0;
        while (nextReference != null) {
            savePointer = nextReference.next;

            nextReference.next = lastHead;
            if (counter == 0) {
                lastHead.next = null;
            }
            counter++;
            lastHead = nextReference;

            nextReference = savePointer;

        }

        return lastHead;
    }

    public static ListNode reverseOrderLoopV2(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode nextReference = head.next;
        ListNode savePointer = null;
        while (current!=null) {
            savePointer = current.next;
            current.next = previous;
            //savePointer.next = current;
            
            previous = current;
            current = savePointer;
        }

        return previous;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode mainHead = head.next;
        helper(head);
        return mainHead;

    }

    public static void helper(ListNode head) {
        if (head.next != null) {
            ListNode second = head.next;
            ListNode third = head.next.next;
            second.next = head;
            if (third != null) {
                head.next = third.next;

                helper(third);

            }
            return;

        }

    }

    public static void printNodes(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        System.out.println(sb.toString());

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);

        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        printNodes(a);
        printNodes(reverseOrderLoopV2(a));

    }
}
