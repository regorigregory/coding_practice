/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.util.Scanner;

/**
 *
 * @author Madero Padero
 */
public class BotSavesPincess1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[] mCoords = new int[2];
        int[] queenCoords = new int[2];
        
        int rowCounter = 0;
        boolean foundBot = false;
        boolean foundQueen = false;
        
        
        while(sc.hasNext() && (!foundBot || !foundQueen)){
            String nextLine = sc.nextLine();
            if(!foundBot && nextLine.contains("m")){
                mCoords[0] = rowCounter;
                mCoords[1] = nextLine.indexOf("m");
                foundBot=true;
            }
             if(!foundQueen && nextLine.contains("p")){
                queenCoords[0] = rowCounter;
                queenCoords[1] = nextLine.indexOf("p");
                 foundQueen=true;
            }
            rowCounter++;   
        }
        
            Integer rowDiff = mCoords[0] - queenCoords[0];
            Integer columnDiff = mCoords[1] - queenCoords[1];
        
        String vertical = rowDiff>0 ? "UP" : "DOWN";
        String horizontal = columnDiff>0 ? "LEFT" : "RIGHT";
        for (int i =0; i<Math.abs(rowDiff); i++){
            System.out.println(vertical);
        }
        
         for (int i =0; i<Math.abs(columnDiff); i++){
            System.out.println(horizontal);
        }
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
