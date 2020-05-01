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
import java.util.HashMap;
import java.util.Map;
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
    }
}