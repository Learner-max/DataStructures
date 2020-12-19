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
          Size of a Binary tree -Recursive
       */
       public int sizeOfTree(Node root)
       {
           if(root==null)
           return 0;
           
           int ls=sizeOfTree(root.left);
           int rs=sizeOfTree(root.right);
           int res=ls+rs+1;
           return res;
       }
       
       /*
            size of Binary Tree-Iterative
       */
       public int sizeOfTreeIterative(Node node)
       {
           Queue<Node> q=new LinkedList<>();
           
           q.add(node);
           int size=0;
           while(!q.isEmpty())
           {
               Node temp=q.remove();
               size++;
               if(temp.left!=null)
               q.add(temp.left);
               if(temp.right!=null)
               q.add(temp.right);
           }
           return size;
       }
       
       /*
            Sum of all nodes of a Binary sub tree
       */
       public int sumOfTree(Node root)
       {
           if(root==null)
           return 0;
           
           int lsum=sumOfTree(root.left);
           int rsum=sumOfTree(root.right);
           int sum=lsum+rsum+root.data;
           
           return sum;
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
        
       
        //System.out.println(tree.sizeOfTree(tree.root));
        //System.out.println(tree.sizeOfTreeIterative(tree.root));
        System.out.println(tree.sumOfTree(tree.root));
    }
}