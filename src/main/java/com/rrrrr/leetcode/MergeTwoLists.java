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
public class MergeTwoLists {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void printList(ListNode root) {
        StringBuilder out = new StringBuilder();
        out.append("[ ");
        while(root!=null){
            out.append(root.val);
            out.append(" ");
            root = root.next;
        }
        out.append("] ");
        System.out.println(out.toString());
                
    }

    public static ListNode mergeTwoLists(ListNode l, ListNode r) {
        if(l==null) return r;
        if(r==null) return l;
        
        ListNode result=null;
        if(r.val<=l.val){
            result = r;
            result.next = mergeTwoLists(l, r.next);
            return result;
            
        } else {
            result = l;
            result.next = mergeTwoLists(l.next, r);
            return result;
        }
    }
    public static void main(String[] args){
        String test = "t0est";
        StringBuilder sb = new StringBuilder();
        char x = test.charAt(0);
        System.out.println(Integer.bitCount(4));
        //System.out.println(Integer.(test, 1));
    }
}
