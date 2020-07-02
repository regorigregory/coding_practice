/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Madero Padero
 */
public class IQR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.nextLine());

        List<Integer> rawList = Arrays.asList(sc.nextLine().split(" ")).stream()
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        List<Integer> multipliers = Arrays.asList(sc.nextLine().split(" ")).stream()
        .map(Integer::parseInt)
        .collect(Collectors.toList());

        int realSize = 0;
        List<Integer> realList = new LinkedList();
            for(int i=0; i<multipliers.size(); i++){
                int occurences = multipliers.get(i);
                realSize+=occurences;
                    for(int k=0; k<occurences; k++){
                    realList.add(rawList.get(i));
                }

            }
        Collections.sort(realList);

        double q1 = findMedian(realList, 0, realList.size() / 2 - 1);
        double q3 = findMedian(realList, (realList.size() + 1) / 2, realList.size() - 1);
        System.out.println(q3-q1);
    }

    public static double findMedian(List<Integer> arr, int start, int end){
        boolean isEven = (end-start) %2==0;
        
        if(isEven){
            return arr.get((start+end)/2);
        } else 
        {
            int value1 = arr.get((end + start) / 2);
            int value2 = arr.get((end + start) / 2 + 1);

            return (arr.get((start+end)/2) +  arr.get((start+end)/2+1))/2.0;


        }
    }
}
