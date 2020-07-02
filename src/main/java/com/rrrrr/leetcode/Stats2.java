/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author Madero Padero
 */
public class Stats2 {
    static void addToSum(Double sum, Integer nextval){
        sum=sum+nextval.doubleValue();
    }
    public static void main(String[] args){
    
   Scanner scan = new Scanner(System.in);
        scan.nextLine();

        List<Integer> nums = Arrays.asList(scan.nextLine().split(" ")).stream()
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        List<Integer> weights = Arrays.asList(scan.nextLine().split(" ")).stream()
                                .map(Integer::parseInt)
                                .collect(Collectors.toList());

        double[] divisor = new double[1];
        divisor[0]=0.0;
        int result = Stream.iterate(0, i->i+1)
        .limit(nums.size())
        .map(i->{
            divisor[0]+=weights.get(i);
            return nums.get(i)*weights.get(i);
            })
            .collect(Collectors.summingInt(Integer::intValue));
    
    
        System.out.format("%.1f", result/divisor[0]);
    
    }
    
}
