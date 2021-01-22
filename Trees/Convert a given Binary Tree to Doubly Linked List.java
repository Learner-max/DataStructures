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
    
   static class DLL
   {
       Node head;
       Node prev;
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
             Convert Binary Tree to DLL
     */
     
     public Node treeToUtil(Node root)
     {
         DLL d=new DLL();
         d.prev=null;
         d.head=null;
         
         treeToList(root,d);
         return d.head;
         
     }
     public void treeToList(Node root,DLL d)
     {
         if(root ==null)
         return  ;
     
     
        treeToList(root.left,d);
        processNode(root,d);
        treeToList(root.right,d);
        
        //return d;
      
     }
     
     public void processNode(Node root,DLL dll)
     {
         if(dll.prev==null)
         {
            // dll.prev=root;
             dll.head=root;
         }else
         {
             dll.prev.right=root;
             
         }
         root.left=dll.prev;
             dll.prev=root;
         //return dll;
     }
     
     public void printList(Node head)
     {
         Node temp=head;
         while(temp!=null)
         {
             System.out.print(temp.data+" ");
             temp=temp.right;
         }
     }
    }
    public static void main(String args[])
    {
       
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(12); 
        tree.root.right = new Node(15); 
        tree.root.left.left = new Node(25); 
        tree.root.left.right = new Node(30); 
        tree.root.right.left = new Node(36);
       
     
      Node head= tree.treeToUtil(tree.root);
      tree.printList(head);
       
      
       
       
    }
    
}