/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import java.util.stream.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.*;

/**
 *
 * @author Madero Padero
 */
public class StreamRevision {
    public static class DummyClass{
        public int val;
    DummyClass(){}
    DummyClass(int value){val = value;}
    }
    public static void main(String[] args) {
        Integer[] intArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] stringArray = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Stream.iterate(10, x -> x * 2).limit(10).forEach(System.out::println);
        Stream.iterate(0, x -> x + 2);
        Stream.generate(() -> 1);
        Integer x = 10;

        Optional valueReturned = Stream.of(stringArray).reduce((a, b) -> a + b);
        
        //Custom collector
        
        Stream.of(intArray).mapToInt(Integer::intValue).boxed().collect(
                Collector.of(LinkedList::new, (list, nextElement) -> list.add(nextElement), (listA, listB)
                        -> {
                    listA.addAll(listB);
                    return listA;
                }, finalList -> finalList.toArray())
        );
        Integer.toString(new Integer(1));
        
        //partitioning the results
        Map<Boolean, List<Integer>> partitioned = Stream.of(intArray).collect(Collectors.partitioningBy(i->i>15));
        
        //grouping the results
        Map<Integer, List<DummyClass>> grouped = Stream.of(intArray).map(i->new DummyClass(i)).collect(Collectors.groupingBy(dummy->dummy.val));
      
        //Collect to a list
        Stream.of(intArray).collect(Collectors.toList());
        
        //String concatenation
        Stream.of(intArray).map((t)->Integer.toString(t)).collect(Collectors.joining(",", "[", "]"));
        
        //Summing the results
        Stream.of(intArray).collect(Collectors.summingInt(Integer::intValue));
        DummyClass c = new DummyClass();
        System.out.println(c.val);
    }
}
