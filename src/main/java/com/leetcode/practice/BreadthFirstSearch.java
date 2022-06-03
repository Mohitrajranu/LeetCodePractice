package com.leetcode.practice;
import java.util.LinkedList;
import java.util.Queue;
public class BreadthFirstSearch {
    NodeTree root;


    void printLevelOrder()
    {
        Queue<NodeTree> queue = new LinkedList<NodeTree>();
        queue.add(root);
        while (!queue.isEmpty()) {
            NodeTree tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        BreadthFirstSearch tree_level = new BreadthFirstSearch();
        tree_level.root = new NodeTree(1);
        tree_level.root.left = new NodeTree(2);
        tree_level.root.right = new NodeTree(3);
        tree_level.root.left.left = new NodeTree(4);
        tree_level.root.left.right = new NodeTree(5);

        System.out.println("Level order traversal of binary tree is - ");
                tree_level.printLevelOrder();
    }

}
/* Class to represent Tree node */
class NodeTree {
    int data;
    NodeTree left, right;

    public NodeTree(int item)
    {
        data = item;
        left = null;
        right = null;
    }
}