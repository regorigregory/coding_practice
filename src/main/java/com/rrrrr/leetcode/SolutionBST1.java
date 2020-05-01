/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rrrrr.leetcode;
/**
 *
 * @author Madero Padero
 */
public class SolutionBST1 {

    static class Solution {

        public class TreeNode {

            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null || root.val == val) {
                return root;
            }

            return (root.val < val) ? searchBST(root.right, val) : searchBST(root.left, val);

        }
        
            public TreeNode searchBSTLoop(TreeNode root, int val) {
     
            boolean found = false;
            TreeNode last = root;
            while(!found){
                if(last.val == val || last == null ){
                    found=true;
                }
                last = (last.val<val)? last.right:last.left;
            }
            return last;

        }
    }
}
