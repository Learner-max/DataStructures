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
  
    static class FirstElement
    {
        int f;
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
       Print extreme nodes of each level of Binary Tree in alternate order
       from Top to Bottom - Iterative Approach
    */
     public void printExtremeNodes(Node root)
     {
         if(root==null)
         return;
         
         Queue<Node> q=new LinkedList<>();
         
         q.add(root);
         boolean flag=true;
         while(!q.isEmpty())
         {
             int qsize=q.size();
             int size=qsize;
             int nodeCount=1;
             while(size>0)
             {
                 Node temp= q.remove();
                 if(temp.left!=null)
                 q.add(temp.left);
                 if(temp.right!=null)
                 q.add(temp.right);
                 
                 if(flag==true && nodeCount==1)
                 {
                     System.out.print(temp.data+" ");
                 }
                 else if(flag==false && nodeCount==qsize)
                 {
                     System.out.print(temp.data+" ");
                 }
                
                 size--;
                 nodeCount++;
             }
             flag=!flag;
         }
     }
     /*
       Print extreme nodes of each level of Binary Tree in alternate order
       from Top to Bottom - Recursive Approach
    */
    public void printExtremeNodesRecursive(Node root)
    {
        if(root==null)
        return ;
        int h=heightOfTree(root);
        
        boolean ltr=true;
        FirstElement a=new FirstElement();
        a.f=0;
        //Height of Tree=No of Levels in tree
        for(int i=1;i<=h;i++)
        {
            a.f=0;
            printExtremeNodesUtil(root,i,ltr,a);
            ltr=!ltr;
            
        }
    }
    
    public void printExtremeNodesUtil(Node root,int level, boolean ltr, FirstElement n)
    {
        if(root==null)
        return ;
        
        if(level==1 && n.f==0)
        {
            System.out.print(root.data+" ");
            n.f=1;
            //return n;
        }
        else if(level>1)
        {
            if(ltr==false)
            {
                
               printExtremeNodesUtil(root.right,level-1,ltr,n);
               printExtremeNodesUtil(root.left,level-1,ltr,n);
            }
            else
            {
                 printExtremeNodesUtil(root.left,level-1,ltr,n);
                 printExtremeNodesUtil(root.right,level-1,ltr,n);
                 
            }
        }
    }
    
     public int heightOfTree(Node root)
       {
           if(root==null)
           return 0;
           
           int lh=heightOfTree(root.left);
           int rh=heightOfTree(root.right);
           int th=Math.max(lh,rh)+1;
           
           return th;
       }
    }
    public static void main(String args[])
    {
       
    BinaryTree tree = new BinaryTree(); 
        
    tree.root = new Node(1);  
    tree.root.left = new Node(2);  
    tree.root.right = new Node(3);  
    tree.root.left.left = new Node(4);  
    tree.root.right.left = new Node(6);  
    tree.root.left.left.left = new Node(8);  
    tree.root.left.left.right = new Node(9);  
    tree.root.right.left.left = new Node(12);  
    tree.root.right.left.right = new Node(13);  
    tree.root.right.left.left.left = new Node(14);  
    tree.root.right.left.left.right = new Node(15);  
       
     
    tree.printExtremeNodes(tree.root);
    System.out.println();
    tree.printExtremeNodesRecursive(tree.root);
      
       
      
       
       
    }
    
}