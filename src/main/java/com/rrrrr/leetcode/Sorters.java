/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Madero Padero
 */
public class Sorters {

    public static Integer[] mergeSort(Integer[] unsorted) {
        if (unsorted.length == 1) {
            return unsorted;
        }
        int pivot = unsorted.length / 2;
        Integer[] left = mergeSort(Arrays.copyOfRange(unsorted, 0, pivot));
        Integer[] right = mergeSort(Arrays.copyOfRange(unsorted, pivot, unsorted.length));

        Integer[] sorted = mergeSortHelper(left, right);
        return sorted;
    }

    public static Integer[] mergeSortHelper(Integer[] left, Integer[] right) {
        int lsize = left.length;
        int rsize = right.length;

        Integer[] sorted = new Integer[lsize + rsize];

        int l = 0;
        int r = 0;
        int loopCounter = 0;
        boolean rightEmpty = false;
        
        while (l < lsize && r < rsize) {
            int leftCandidate = left[l];
            int rightCandidate = right[r];
            int newValue = 0;
            
            if (leftCandidate < rightCandidate) {
                newValue = leftCandidate;
                l++;
                rightEmpty = false;
            } else {
                newValue = rightCandidate;
                r++;
                rightEmpty = true;

            }
            sorted[loopCounter] = newValue;
            loopCounter++;

        }
        Integer[] nonEmptyArray = (rightEmpty) ? left : right;
        Integer nonchalantCounter = (rightEmpty) ? l : r;
        while (loopCounter < lsize + rsize) {

            sorted[loopCounter] = nonEmptyArray[nonchalantCounter];
            loopCounter++;
            nonchalantCounter++;
        }

        return sorted;

    }

    public static void printArray(Integer[] printArray) {
        String concatenated = Arrays.asList(printArray).stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println(concatenated);

    }
//       public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null && l2 == null) return null;
//        if (l1 == null || l2 == null) {
//            if (l1 != null) {
//                ListNode l = new ListNode(l1.val);
//                l.next = mergeTwoLists(l1.next, l2);
//                return l;
//            } else {
//                ListNode l = new ListNode(l2.val);
//                l.next = mergeTwoLists(l1, l2.next);
//                return l;
//            } 
//        }
//        if (l1.val < l2.val) {
//            ListNode l = new ListNode(l1.val);
//            l.next = mergeTwoLists(l1.next, l2);
//            return l;
//        } else {
//            ListNode l = new ListNode(l2.val);
//            l.next = mergeTwoLists(l1, l2.next);
//            return l;
//        }
//    }
    public static void main(String[] args) {
        Integer[] unsorted = new Integer[]{22, 11, 44, 1, 2, 6, 8, 10, 99};
        Integer[] sorted = mergeSort(unsorted);
        printArray(sorted);
        System.out.println(2>0);
        boolean test = false;
    }

}
