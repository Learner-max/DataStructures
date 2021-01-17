/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

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
            Height of a Binary tree Recursive
       */
       public int height(Node root)
       {
           if(root==null)
           return -1;;
           
           int lh=height(root.left);
           int rh=height(root.right);
           int th=Math.max(lh,rh)+1;
           
           return th;
       }
       /*
            Level Order traversal
       */
        public void traverseLevelOrder(Node root)
       {
           Queue<Node> q=new LinkedList<>();
           
           q.add(root);
           
           while(!q.isEmpty())
           {
               Node temp=q.remove();
               if(temp.left!=null)
               q.add(temp.left);
               if(temp.right!=null)
               q.add(temp.right);
               
               System.out.print(temp.data+" ");
           }
       }
       
       /*
          Print Binary tree in Spiral order Iterative Approach
       */
       public void printTreeSpiral(Node root)
       {
           Stack<Node> s1=new Stack<>();
           Stack<Node> s2=new Stack<>();
           
           s1.push(root);
           
           while(!s1.isEmpty() || !s2.isEmpty())
           {
               while(!s1.isEmpty())
               {
                   Node temp=s1.pop();
                   System.out.print(temp.data+" ");
                   if(temp.right!=null)
                   s2.push(temp.right);
                   
                   if(temp.left!=null)
                   s2.push(temp.left);
                   
               }
               
               while(!s2.isEmpty())
               {
                   
                   Node temp=s2.pop();
                   System.out.print(temp.data+" ");
                   if(temp.left!=null)
                   s1.push(temp.left);
                   
                   if(temp.right!=null)
                   s1.push(temp.right);
               }
           }
       }
       
       /*
          Print Binary tree in spiral form using  Recursive approach
       */
       public void printTreeSpiralRecursive(Node root)
       {
           int h=height(root);
           boolean ltr=false;
           for(int i=1;i<=(h+1);i++)
           {
               printSpiralUtil(root,i,ltr);
               ltr=!ltr;
           }
       }
       
       public void printSpiralUtil(Node root,int level,boolean ltr)
       {
           if(root==null)
           return;
           if(level==1)
           System.out.print(root.data+" ");
           else if(level>1)
           {
               if(ltr==false)
               {
                    printSpiralUtil(root.right,level-1,ltr);
                   printSpiralUtil(root.left,level-1,ltr);
               }
               else
               {
                   printSpiralUtil(root.left,level-1,ltr);
                   printSpiralUtil(root.right,level-1,ltr);
               }
           }
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
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
       
        
      
      
      // tree.printTreeSpiral(tree.root);
       tree.printTreeSpiralRecursive(tree.root);
       
       
    }
    
}