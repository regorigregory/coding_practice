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

/**
 *
 * @author Madero Padero
 */
public class Quartiles {
    public static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        
        List<Integer> orderedElements = Arrays.asList(sc.nextLine().split(" "))
        .stream()
        .map(Integer::parseInt)
        .sorted()
        .collect(Collectors.toList());


        int size = orderedElements.size();
        int q1= 0;
        int q2= 0;
        int q3= 0;

        int halfway = size/2;
        int halfOfHalfway = halfway/2;

        if(size%2!=0){
            //System.out.println("Odd");
            q2 = orderedElements.get(halfway);

            if(halfway%2==0){
                //System.out.println("Even");

                q1=
                (orderedElements.get(halfOfHalfway)
                +orderedElements.get(halfOfHalfway-1))/2;

                q3=
                (orderedElements.get(halfway+halfOfHalfway)
                +orderedElements.get(halfway+halfOfHalfway+1))/2;


            }else {
                //System.out.println("Odd");


              
                q1=orderedElements.get(halfOfHalfway-1);

                q3=orderedElements.get(halfway+halfOfHalfway-1);
            } 

        } else {
       

            q2 = (orderedElements.get(halfway)+orderedElements.get(halfway-1))/2;

            if(halfway%2==0){

                q1 = 
                (orderedElements.get(halfOfHalfway)
                +orderedElements.get(halfOfHalfway-1))/2;
                
                q3=
                (orderedElements.get(halfway+halfOfHalfway)
                +orderedElements.get(halfway+halfOfHalfway-1))/2;

            }else {

                q1= 
                orderedElements.get(halfOfHalfway);

                q3=orderedElements.get(halfway+halfOfHalfway);

            } 

        }

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);


    }
    public static void main(String[] args){
        String input = "4 17 7 14 18 12 3 16 10 4 4 12";
       String a = new String();
       int m = Integer.parseInt("1");
     
    }
}
