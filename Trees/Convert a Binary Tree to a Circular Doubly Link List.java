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
             Convert Binary Tree to circular DLL
     */
     
     public Node treeToCircularList(Node root)
     {
         if(root==null)
         return null;
         
         Node leftList=treeToCircularList(root.left);
         Node rightList=treeToCircularList(root.right);
         
         root.left=root;
         root.right=root;
         
         root=concatenate(leftList,root);
         root=concatenate(root,rightList);
         return root;
     }
     
     public Node concatenate(Node a,Node b)
     {
         if(a==null)
         return b;
         if(b==null)
         return a;
         
         Node aEnd=a.left;
         Node bEnd=b.left;
         
         a.left=bEnd;
         bEnd.right=a;
         aEnd.right=b;
         b.left=aEnd;
         
         return a;
     }
     
     
     public void printCircularList(Node head)
     {
         Node temp=head;
         do
         {
             System.out.print(temp.data+" ");
             temp=temp.right;
         }
         while(temp!=head);
       
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
       
     
      Node head= tree.treeToCircularList(tree.root);
      tree.printCircularList(head);
       
      
       
       
    }
    
}