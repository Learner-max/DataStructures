/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static class Node
    {
        Node right;
        Node left;
        int data;
        Node(int data)
        {
            this.data=data;
        }
    }
    static class BinaryTree
    {
        Node root;
        
        public boolean sameTreeIterative(Node nodeA,Node nodeB)
        {
            if(nodeA==null && nodeB==null)
            return true;
            if(nodeA==null || nodeB==null)
            return false;
            Queue<Node> qA=new LinkedList<>();
            Queue<Node> qB=new LinkedList<>();
            
            qA.add(nodeA);
            qB.add(nodeB);
            
            while(!qA.isEmpty() && !qB.isEmpty())
            {
               Node nA=qA.remove();
               Node nB=qB.remove();
               
               if(nA.data!=nB.data)
               return false;
               
               if(nA.left!=null && nB.left!=null)
               {
                   qA.add(nA.left);
                   qB.add(nB.left);
               }else if(nA.left!=null || nB.left!=null)
               {
                   return false;
               }
               
               if(nA.right!=null && nB.right!=null)
               {
                   qA.add(nA.right);
                   qB.add(nB.right);
               }else if (nA.right!=null || nB.right!=null)
               {
                   return false;
               }
               
            }
            
            return true;
           
        }
       
        public boolean isSameTree(Node p, Node q)
        {
            
             if(p==null && q==null)
                return true;
            else if(p==null || q==null)
                return false;
            boolean fL=isSameTree(p.left,q.left);
            if(!fL)
                return false;
            boolean fR=isSameTree(p.right,q.right);
            if(!fR)
                return false;
            return fL && fR && p.data==q.data;
            
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		BinaryTree tree1 = new BinaryTree();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(7);
        tree1.root.left.right = new Node(6);
        tree1.root.right.left = new Node(5);
        tree1.root.right.right = new Node(4); 
        
        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(7);
        tree2.root.left.right = new Node(6);
        tree2.root.right.left = new Node(5);
        tree2.root.right.right = new Node(4); 
        
      
	   System.out.println(tree1.isSameTree(tree1.root,tree2.root)); 
	    System.out.println(tree1.sameTreeIterative(tree1.root,tree2.root)); 
		
	}
}
