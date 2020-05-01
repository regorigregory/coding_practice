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
public class SolutionRecursion2 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
    public static void printNodes(ListNode head){
        StringBuilder sb = new StringBuilder();
        while(head!=null){
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
        a.next = b; b.next=c; c.next=d;
        printNodes(a);
        printNodes(swapPairs(a));

    }
}
