/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Node
    {
        Node left;
        Node right;
        int data;
        Node(int data)
        {
            this.data=data;
        }
    }
    
    static class BinaryTree
    {
        Node root;
        public boolean checkSumProperty(Node node)
        {
            int left_data=0;
            int right_data=0;
            if(node==null || (node.left==null && node.right==null) )
            {
                return true;
            }
            // Idea is to do a POST ORDER Traversal of tree
            boolean left=checkSumProperty(node.left);
            boolean right=checkSumProperty(node.right);
            if(node.left!=null)
            left_data=node.left.data;
            if(node.right!=null)
            right_data=node.right.data;
            // here for every node 2 conditions should satisfy
            //for child sum property
            //1. node.data==(left_data+right_data)  and
            //2. Left subtree and Right Subtree forNode should also satisfy the 
            //child sum property
            if(left && right && node.data==(left_data+right_data))
            return true;
            else
            return false;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
	    BinaryTree tree = new BinaryTree();
        tree.root = new Node(11);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(2);
        
        System.out.println(tree.checkSumProperty(tree.root));
	}
}
