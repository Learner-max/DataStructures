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
        Construct a Mirror tree from Binary tree Recursion
       */
       
       public Node getMirrorTree(Node root)
       {
           constructMirrorTree(root);
           return root;
       }
       public void constructMirrorTree(Node root)
       {
           if(root==null)
           return ;
           
           constructMirrorTree(root.left);
           constructMirrorTree(root.right);
           if(root.left!=null || root.right!=null){
           Node temp=root.left;
           root.left=root.right;
           root.right=temp;}
           
       }
       
        /*
        Construct a Mirror tree from Binary tree Iterative
       */
       public void getMirrorTreeIterative(Node root)
       {
           //Using Level Order Traversal
           Queue<Node> q=new LinkedList<>();
           
           q.add(root);
           
           while(!q.isEmpty())
           {
               Node temp=q.remove();
               Node t=temp.left;
               temp.left=temp.right;
               temp.right=t;
               if(temp.left!=null)
               q.add(temp.left);
               if(temp.right!=null)
               q.add(temp.right);
               
               System.out.print(temp.data+" ");
           }
       }
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
    }
    public static void main(String args[])
    {
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        
        tree.traverseLevelOrder(tree.root);
        System.out.println();
        System.out.println("Mirror Tree");
        //System.out.println(tree.sizeOfTree(tree.root));
        //System.out.println(tree.sizeOfTreeIterative(tree.root));
       // Node r=tree.getMirrorTree(tree.root);
        //tree.traverseLevelOrder(r);
        //tree.traverseLevelOrder(tree.root);
         
        tree.getMirrorTreeIterative(tree.root);
    }
    
}