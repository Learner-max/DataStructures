/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	static class Node
    {
        int data;
        Node left;
        Node right;
        
        Node(int data)
        {
            this.data=data;
        }
    }
    
    
    static class BinaryTree
    {
        Node root;
        
        public void traversePreOrderRecursion(Node root)
        {
            if(root==null)
                return;
            
            System.out.print(root.data+" ");
            traversePreOrderRecursion(root.left);
            traversePreOrderRecursion(root.right);
               
        }
        
        
        public void traverseInOrderRecursion(Node root)
        {
            if(root==null)
                return;
            
            
            traverseInOrderRecursion(root.left);
            System.out.print(root.data+" ");
            traverseInOrderRecursion(root.right);
               
        }
        
        public void traversePostOrderRecursion(Node root)
        {
            if(root==null)
                return;
            
            
            traversePostOrderRecursion(root.left);
            
            traversePostOrderRecursion(root.right);
            System.out.print(root.data+" ");
               
        }
        
        
        /*
            Iterative Tree Traversals Approach#2
        */
        
        public void traversePreOrderApproach2(Node root)
        {
            if(root==null)
            {
                return ;
            }
            Node curr=root;
            Stack<Node> s=new Stack<>();
            s.push(curr);
            
            while(!s.isEmpty())
            {
                Node node=s.peek();
                System.out.print(node.data+" ");
                s.pop();
                
                if(node.right!=null)
                {
                    s.push(node.right);
                    //curr=curr.left;
                }
                if(node.left!=null)
                {
                     s.push(node.left);
                }
                
            }
        }
            
        /*
            Morris PreOrder Traversal
        */
        
        public void morrisPreorderTraversal(Node root)
        {
            Node curr=root;
            Node prev=null;
            
            if(root ==null)
            return;
            
            while(curr!=null)
            {
                if(curr.left==null)// No Left Sub tree
                {
                    System.out.print(curr.data+" ");
                    curr=curr.right;  // Move the curr poinyter to right subtree
                }
                else  //There is a Left Subtree.
                {
                 // 1. Find the predecessor of this curr node 
                 prev=findPredecessor(curr);
                 
                 if(prev.right==null) // First time traversal, use this to hold the link to curr node
                 {
                     System.out.print(curr.data+" ");
                     prev.right=curr;
                     curr=curr.left;
                 }
                 else // Visiting it second time then we have to remove the above link
                 {
                     prev.right=null;
                     
                     curr=curr.right;
                 }
                }
            }
        }
        
        public Node findPredecessor(Node node)
        {
            //Predecessor is rightmost node in leftsubtree
            
            Node temp=node.left;
            while(temp.right!=null && temp.right!=node)
            {
                temp=temp.right;
            }
            
            return temp;
        }
    }
    public static void main(String args[])
    {
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        
       /* tree.traverseInOrderRecursion(tree.root);
        System.out.println();
        tree.traversePreOrderRecursion(tree.root);
        System.out.println();
        tree.traversePostOrderRecursion(tree.root);*/
        
        //
        //tree.traverseInOrderIterative(tree.root);
        tree.traversePreOrderApproach2(tree.root);
       // tree.traversePostOrderIterative(tree.root);
        System.out.println();
        //tree.traverseInOrderApproach2(tree.root);
        //tree.traversePreOrderApproach2(tree.root);
        //tree.traversePostOrderApproach2(tree.root);
        tree.morrisPreorderTraversal(tree.root);
    }
}
