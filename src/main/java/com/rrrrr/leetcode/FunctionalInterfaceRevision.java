/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;
import java.util.Optional;
import java.util.function.*;
import java.util.logging.Logger;
/**
 *
 * @author Madero Padero
 */
public class FunctionalInterfaceRevision {
    public static void swallow(Integer val){
        System.out.println("I have just swallowed "+val+".");
    }
    public static void main(String[] args){
        Consumer<String> consumerExample = (x)->System.out.println(x);

        Consumer<String> consumerShortExample = System.out::println;
        
        Supplier<String> supplierExample = ()->new String("Hello out there!");
        
        Function<Integer, String> functionExample = (x) -> x.toString();
        
        BiFunction<Integer, String, String> biFunctionExample = (x,y)-> x+y;
        
        UnaryOperator<Integer> unaryOperatorExample = (x) -> x+2;
        BinaryOperator<Integer> binaryOperatorExample = (x,y)->x+y;
        
        Optional<Integer> optionalExample = Optional.ofNullable(null);
        
        Consumer<Integer> optionalConsumer = x->FunctionalInterfaceRevision.swallow(x);
        
        optionalExample.ifPresent(optionalConsumer);
    
        
        
        
        
    }
}
