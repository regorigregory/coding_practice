/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Madero Padero
 */
public class CinemaTicket {
    //parameters needed:
        //family ticket price
        //child ticket price
        //adult ticket price
    //n_children
    //n_adult
    //family ticket: either 2-2 or 1-3 adult/children
    //return value int[]
    
    // [0]: NO of child tickets
    // [1]: NO of adult tickets
    // [2]: NO of family tickets
    
    
    // base cases:
    // only children -> children ticket
    // only adult -> adult tickets
    //2 children 2 adult || 3 children 1 adult: family ticket
    // left: 2:2, right 1:3
    
    double childPrice; double adultPrice; double familyPrice;
    Map<String, Integer[]> cache;
    public CinemaTicket(double childPrice, double adultPrice, double familyPrice){
        this.childPrice = childPrice;
        this.adultPrice = adultPrice;
        this.familyPrice = familyPrice;
    }
    public Integer[] getCheapestCombination(int childrenNO, int adultNO){
        
         if(childrenNO <0 || adultNO<0){
             throw new InvalidParameterException("The provided parameters hold negative values.");
         }
         this.cache = new HashMap<>();

        Integer[] left = helper(childrenNO, adultNO, 2,2);
        Integer[] right = helper(childrenNO, adultNO, 1,3);
        return getSum(left)<getSum(right) ? left : right;

    }
    public Integer[] helper(int childrenLeft, int adultsLeft, int childrenToInclude, int adultsToInclude){
        
        //we cannot give family ticket if:
            // A: less than 2 children as we need a minimum of 2 children to give a family ticket
            // B: there is no adult left
            //less than 2 parents covering cases:
                    // C: 3 children & no adult -> condition B covers this
                    // D: 2 children & 1 adult
            // E: 1 children & 2 adults -> condition A covers this
            
        if( childrenLeft<2
                || adultsLeft==0 
                || (childrenLeft==2 && adultsLeft<2)
                ){
            return new Integer[]{childrenLeft, adultsLeft, 0};
        }
        
        String key = String.valueOf(childrenLeft)+String.valueOf(adultsLeft);
        
        //we don't want to recalculate things over and over again...
        
        if(cache.containsKey(key)){
            return cache.get(key).clone();
        }
        // we can add a family ticket!!!
        
        childrenLeft = Math.max(0, childrenLeft-childrenToInclude);
        adultsLeft = Math.max(0, adultsLeft-adultsToInclude);


        Integer[] left = helper(childrenLeft, adultsLeft, 2,2);
        Integer[] right = helper(childrenLeft, adultsLeft, 3,1);
        
        
        
        Integer[] winner = getSum(left)<getSum(right) ? left : right;
        winner[2]+=1;

        cache.put(key, winner.clone());
        return winner;
    }
    
    public double getSum(Integer[] proposedTickets){
        return  this.childPrice *proposedTickets[0] + this.adultPrice * proposedTickets[1] + this.familyPrice * proposedTickets[2];
    }
    public static void main(String[] args){
        
        // Test cases, please?

        int childrenNO = 4;
        int  adultNO =10;
        
        double familyPrice =25;
        double childPrice =5;
        double adultPrice = 10;
        
        CinemaTicket instance = new CinemaTicket(childPrice, adultPrice, familyPrice);
        
        Integer[] best = instance.getCheapestCombination(childrenNO, adultNO);
        
        double sum = instance.getSum(best);
        
        System.out.format("The cheapest combination is: %d child, %d adult, %d family tickets totalling in £ %f.\n",
                best[0], best[1], best[2], sum);
        
    }
}
