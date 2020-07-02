/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Madero Padero
 */
public class STD {
    public static void main(String[] args){
      DecimalFormat df = new DecimalFormat(".#");
      Scanner sc = new Scanner(System.in);
      double num = Double.parseDouble(sc.nextLine());
      List<Double> numsRaw = Arrays.asList(sc.nextLine().split(" ")).stream()
              .map(Double::parseDouble)
              .collect(Collectors.toList());
      
      Double mean = numsRaw.stream()
              .collect(Collectors.summingDouble(Double::new))/num;
      
      Double variance = numsRaw.stream()
      .map(d->d-mean)
      .map(d->Math.pow(d, 2))
      .collect(Collectors.summingDouble(Double::new))/num;
      
      Double std = Math.sqrt(variance);
      System.out.println(df.format(std));

    }
}
