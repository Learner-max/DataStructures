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
            Check if given binary tree is a sum tree Recursive
       */
        public boolean isSameTree(Node p, Node q) {
        
        if(p==null && q==null)
            return true;
        
        if(p!=null && q!=null && p.data==q.data)
        {
            boolean ileft=isSameTree(p.left,q.left);
            if(ileft==false)
                return false;
            boolean iright=isSameTree(p.right,q.right);
            if(iright==false)
                return false;
            
            return true;
        }
        return false;
        
    }
    /*
            Check if given binary tree is a sum tree Iterative
    */
     public boolean isSameTreeIterative(Node p, Node q) {
         
         
         
    }
    }
    public static void main(String args[])
    {
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(50); 
        tree.root.left = new Node(15); 
        tree.root.right = new Node(10); 
        tree.root.left.left = new Node(10); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(7); 
        tree.root.right.right = new Node(3);
        
        BinaryTree treeq=new BinaryTree();
        treeq.root = new Node(50); 
        treeq.root.left = new Node(15); 
        treeq.root.right = new Node(10); 
        treeq.root.left.left = new Node(10); 
        treeq.root.left.right = new Node(5); 
        treeq.root.right.left = new Node(7); 
        //treeq.root.right.right = new Node(3);
       // tree.traverseLevelOrder(tree.root);
        //System.out.println();
        //System.out.println("Sum Tree");
        //System.out.println(tree.sizeOfTree(tree.root));
        //System.out.println(tree.sizeOfTreeIterative(tree.root));
       // Node r=tree.getMirrorTree(tree.root);
        //tree.traverseLevelOrder(r);
        //tree.traverseLevelOrder(tree.root);
         
        if(tree.isSameTree(tree.root,treeq.root))
        System.out.println("Are Identical Trees");
        else
        System.out.println("Not Identical Trees");
         //tree.traverseLevelOrder(tree.root);
    }
    
}
