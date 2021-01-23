/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
  
static class Node
    {
        String data;
        Node left;
        Node right;
        
        Node(String data)
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
            Evaluate Expression Tree - Postorder recursive evaluation
     */
     
     public int evalExpression(Node root)
     {
         if(root==null)
         return 0;
         
         if(root.left==null && root.right==null)
         return Integer.parseInt(root.data);
         
         int leftEval=evalExpression(root.left);
         int rightEval=evalExpression(root.right);
         
         if(root.data=="+")
         {
             return leftEval+rightEval;
         }else if(root.data=="*")
         {
             return leftEval*rightEval;
         }
         else if(root.data=="/")
         {
             return leftEval/rightEval;
         }else 
         {
             return leftEval-rightEval;
         }
     }
     
     
    }
    public static void main(String args[])
    {
       
    BinaryTree tree = new BinaryTree(); 
        
    tree.root = new Node("+");  
    tree.root.left = new Node("*");  
    tree.root.left.left = new Node("5");  
    tree.root.left.right = new Node("4");  
    tree.root.right = new Node("-");  
    tree.root.right.left = new Node("100");  
    tree.root.right.right = new Node("/");  
    tree.root.right.right.left = new Node("20");  
    tree.root.right.right.right = new Node("2");  
       
     
      System.out.println(tree.evalExpression(tree.root));
      
       
      
       
       
    }
    
}