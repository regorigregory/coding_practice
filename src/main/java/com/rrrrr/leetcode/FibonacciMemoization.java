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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
class FibonacciMemoization {
    
    static Map<Integer, Integer> cache = new HashMap<>();
    
    public int fib(int N) {
        Integer result =0;
        
        if(N<1){
            return result;
        }
          if(N==1){
            return 1;
        }
        if(cache.containsKey(N)){
            return cache.get(N);
        }
        result = fib(N-1) + fib(N-2);
        cache.put(N, result);
        return result;
        
    }
    
        public static void main(String[] args){
        int n = 11;
        int result = new FibonacciMemoization().fib(n);
        System.out.println(result);
        Integer[] test = new Integer[]{1,2,3,4,5};
        List<Integer> x = Arrays.asList(test);
        Integer a = 10;
        x.stream().map((Integer i) ->{
            return Integer.toString(i);
                    })       
        .collect(Collectors.joining(","));
        Integer[] copied = Arrays.copyOfRange(test,0, test.length-1);
        
        System.out.println(copied.length);
        }
}