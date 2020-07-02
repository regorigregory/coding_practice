/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Madero Padero
 */
public class QuickSort {
    
    
    public static void sort(int[] arr, int low, int high){
        if(low<high){
            int p = partition(arr, low, high);
            sort(arr, low, p-1);
            sort(arr, p+1, high);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int h = arr[high];
        int i = low-1;
        for(int j = low; j<high; j++){
            if(arr[j]<h){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        
        return i+1;

    }
    public static void swap(int[] arr, int swapThisIndex, int withThisOne){
        int temp = arr[swapThisIndex];
        arr[swapThisIndex] = arr[withThisOne];
        arr[withThisOne] = temp;
    }
    
    public static void main(String[] args){
        int[] unsorted = new int[]{3,4,19,80,10,22,666,1,11};
        
        sort(unsorted, 0, unsorted.length-1);
      
       for(int i : unsorted){
           System.out.println(i);
       }
       

       
 
      
       
     
    }
}
