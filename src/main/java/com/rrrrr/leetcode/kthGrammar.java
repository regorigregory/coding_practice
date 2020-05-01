package com.rrrrr.leetcode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madero Padero
 */
public class kthGrammar {
        //it costs too much memory....
        public int kthGrammarMine(int N, int K) {
        int i =1;
        StringBuilder sb = new StringBuilder();
        String solution = "0";
        while(i<N){
            for(int s=0; s<solution.length(); s++){
                if(solution.charAt(s)=='0'){
                    sb.append("01");
                }else{
                    sb.append("10");

                }
            }
            solution = sb.toString();
            sb.setLength(0);
            i++;
        }
        return Integer.parseInt(solution, 1);
    }
        
        public static void main(String[] args){
            int a = 10;
            byte test = (byte) 0101;
            byte notTest = (byte)~test;
            System.out.println(Byte.toString(notTest));
            System.out.println(Integer.toBinaryString(a));
            System.out.println(Integer.bitCount(a));
        }
}
