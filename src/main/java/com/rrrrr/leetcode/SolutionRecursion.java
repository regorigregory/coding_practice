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
public class SolutionRecursion {
       public static void reverseString(char[] s) {
        int index = 1;
        helper(index, s);
    }
    public static void helper(int index, char[] s){
        int check = s.length/2;
        
        if(index>check){
            return;
        }
        
        int length = s.length;
        char a = s[index-1]; 
        char b = s[length-index];
        s[index-1] = b;
        s[length-index] = a;
        index++;
        helper(index, s);

    }
    public static void main(String[] args){
        char[] test = new char[]{'a', 'b', 'c', 'd'};
        SolutionRecursion.reverseString(test);
        System.out.println(test);
    }
}
