package com.leetcode.practice;

public class BinaryTreeTraversal {

        // Root of Binary Tree
        NodeTree root;

    BinaryTreeTraversal() { root = null; }

        /* Given a binary tree, print its nodes according to the
          "bottom-up" postorder traversal. */
        void printPostorder(NodeTree node)
        {
            if (node == null)
                return;

            // first recur on left subtree
            printPostorder(node.left);

            // then recur on right subtree
            printPostorder(node.right);

            // now deal with the node
            System.out.print(node.data + " ");
        }

        /* Given a binary tree, print its nodes in inorder*/
        void printInorder(NodeTree node)
        {
            if (node == null)
                return;

            /* first recur on left child */
            printInorder(node.left);

            /* then print the data of node */
            System.out.print(node.data + " ");

            /* now recur on right child */
            printInorder(node.right);
        }

        /* Given a binary tree, print its nodes in preorder*/
        void printPreorder(NodeTree node)
        {
            if (node == null)
                return;

            /* first print data of node */
            System.out.print(node.data + " ");

            /* then recur on left subtree */
            printPreorder(node.left);

            /* now recur on right subtree */
            printPreorder(node.right);
        }

        // Wrappers over above recursive functions
        void printPostorder() { printPostorder(root); }
        void printInorder() { printInorder(root); }
        void printPreorder() { printPreorder(root); }

        // Driver method
        public static void main(String[] args)
        {
            BinaryTreeTraversal tree = new BinaryTreeTraversal();
            tree.root = new NodeTree(1);
            tree.root.left = new NodeTree(2);
            tree.root.right = new NodeTree(3);
            tree.root.left.left = new NodeTree(4);
            tree.root.left.right = new NodeTree(5);

            System.out.println(
                    "Preorder traversal of binary tree is ");
            tree.printPreorder();

            System.out.println(
                    "\nInorder traversal of binary tree is ");
            tree.printInorder();

            System.out.println(
                    "\nPostorder traversal of binary tree is ");
            tree.printPostorder();
        }

}
