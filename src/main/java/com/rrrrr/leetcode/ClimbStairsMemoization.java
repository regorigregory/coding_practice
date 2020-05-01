/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;
import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author Madero Padero
 */

import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class ClimbStairsMemoization {

    public static Map<Integer, Integer> cache = new HashMap<>();
    
    public int climbStairs(int n) {
       if(n<3){
           return n;
       }
       if(cache.containsKey(n)){
           return cache.get(n);
       }
        
       int results =  climbStairs(n-2) + climbStairs(n-1);
       cache.put(n, results); 
       return results; 

    }
    public static void main(String[] args){
        int n = 2;
        int result = new ClimbStairsMemoization().climbStairs(n);
        System.out.println(result);
        int n2 = 3;
        int result2 = new ClimbStairsMemoization().climbStairs(n2);
        System.out.println(result2);
        
         int n3 = 5;
        int result3 = new ClimbStairsMemoization().climbStairs(n3);
        System.out.println(result3);
        int test = -2;
        System.out.println(-2%2);
        Math.pow(10, n);
        System.out.println("test.pngsdfsdf".contains(".png"));
        Set<String> containsTest = new HashSet<>();
        
        containsTest.add("whatever.png");
        containsTest.add("somethingelse.png");
        boolean res = containsTest.contains("*");
        System.out.println(res);
        String pathTest = "C:\\gdrive\\java_projects\\Worksheet9Repo\\BusinessLogic4\\..\\tmp_folders\\short_filenames\\collection-A\\file1.mp3";
        String[] comps = pathTest.split("\\.");
        System.out.println(comps.length);
    }
}
