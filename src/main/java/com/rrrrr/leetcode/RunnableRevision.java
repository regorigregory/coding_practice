/**********************************************************************************************************************************
 * Coding to an interface rather than a subclass! Therefore any future implementation will be compatible with your code!
 * If you want to preserve object state across threads, you should implement Runnable and pass the same object to multiple threads!
 * 
 */
package com.rrrrr.leetcode;

/**
 *
 * @author Madero Padero
 */
public class RunnableRevision {

    public static class ExtendsRunnable implements Runnable {

        public void run() {
            System.out.println("I have implemented runnable!");
        }
    }
    
    public static class ExtendsThread extends Thread{
        public void run(){
            System.out.println("I am an instance of \"ExtendsThread\"");
        }
    }

    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello, I am a runnable lambda.");
        Thread t = new Thread(() -> System.out.println("Hello, I am a Thread lambda."));
        new Thread(r).start();
        t.start();
    }
}
