/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Madero Padero
 */
public class Stats1 {
      public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String numbers = scan.nextLine();
        List<Integer> sortedNumList = Arrays.asList(numbers.split(" "))
        .stream()
        .map(Integer::parseInt)
        .sorted().collect(Collectors.toList());

        double avg = sortedNumList.stream()
        .collect(Collectors.averagingDouble(Integer::intValue));

        double median = 0;
        if (size%2==0){
            median = 
            (sortedNumList.get(size/2-1) + sortedNumList.get(size/2))/2.0;
        } else {
            median = sortedNumList.get(size/2);
        }

        Map<Integer, Long> countedVals = sortedNumList.stream()
        .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        Comparator<Entry<Integer, Long>> myComparator = (a,b)->{
            if (a.getValue()<b.getValue()){
                return 1;
            } else if (a.getValue()>b.getValue()){
                return -1;
            } else {
                return a.getKey()<b.getKey()? -1: 1;
            }
    
       };

       List<Integer> orderedMode = countedVals.entrySet().stream()
       .sorted(myComparator).map(m ->m.getKey())
       .collect(Collectors.toList());
       Integer mode = orderedMode.get(0);
       System.out.format("%.1f%n", avg);
       System.out.format("%.1f%n", median);
       System.out.format("%d%n", mode);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
