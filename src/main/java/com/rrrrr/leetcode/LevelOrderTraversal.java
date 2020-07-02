/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;

import com.rrrrr.leetcode.SolutionRecursion3.ListNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Madero Padero
 */
public class LevelOrderTraversal {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static Double customLog(double base, double num) {
        return Math.log(num) / Math.log(base);
    }
    static List<List<Integer>> solution;

    public List<List<Integer>> levelOrder(TreeNode root) {
        solution = new LinkedList<>();
        if (root != null) {
            levelOrderLoop(root);
        }
        return solution;

    }
     public void levelOrderLoop(TreeNode root) {

        Double totalCounter = 1.0;

        Double currentPower = 1.0;

        Double previousPower = 0.0;

        Deque<TreeNode> ls = new LinkedList<>();
        
        ls.addFirst(root);

   

        while (!ls.isEmpty()) {

            double currentLimit = Math.pow(2, currentPower);

            double previousLimit = Math.pow(2, previousPower);

            if((currentPower==1.0 && totalCounter>currentPower) 
                || (currentLimit <= totalCounter-previousLimit) ){
                previousPower = currentPower;
                currentPower++;
            }

            TreeNode temp = ls.removeFirst();

            if (temp != null) {
                ls.addLast(temp.left);
                ls.addLast(temp.right);
                List<Integer> tempInner = new LinkedList<>();

                if (solution.size() < previousPower + 1) {
                    solution.add(tempInner);
                } else {
                    tempInner = solution.get(previousPower.intValue());
                }

                tempInner.add(temp.val);

            }

            totalCounter++;
        }

    }
    

    public static void main(String[] args) {
        System.out.println(customLog(2, 0));
        
    }
}
