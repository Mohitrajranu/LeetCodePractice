package com.leetcode.practice;


    /**
     * Definition for a binary tree node.
     * */
      class TreeNode {
         int val;
          TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
            this.left = left;
             this.right = right;
         }
      }

public class MaxDepthBinaryTree {
        public int maxDepth(TreeNode root) {
            return result(root,0);
        }
        public int result(TreeNode node,int currDepth){
            if(node==null){
                return currDepth;
            }
            currDepth++;
            return Math.max(result(node.left,currDepth),result(node.right,currDepth));
        }
    }

