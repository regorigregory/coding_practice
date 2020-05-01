package com.rrrrr.leetcode;


import com.rrrrr.leetcode.JavaReflection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madero Padero
 */
public class JavaReflectOutside {
    public static void main(String... args) throws Exception{
        JavaReflection instance = new JavaReflection();
        Class instanceClass = instance.getClass();
        Method method = instanceClass.getDeclaredMethod("testMethod1");
       
        method.invoke(instance); 
        Class[] strClass = new Class[]{String.class};
        var method2 = instanceClass.getDeclaredMethod("testMethod2",  strClass);
        method2.invoke(instance, "This is a passed parameter.");
        var field = instanceClass.getField("oneAttr");
        String fieldName = field.getName();
        String value = (String) field.get(instance);
        
        System.out.println(fieldName+": "+value);
        
        Field privateField = instanceClass.getDeclaredField("privateAttr");
        
        System.out.println(((String) privateField.get(instance)));
        //privateField.set(instance, "This should fail outside of the class.");
        //System.out.println(((String) privateField.get(instance)));
    }
}
