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
        static boolean v1;
        static boolean v2;
        
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
            Lowest Common Ancestor in a Binary Tree using Single Traversal Approch
       */
       public Node LCAUtil(Node root,int x,int y)
       {
           v1=false;
           v2=false;
           
           Node lca=LCAUsingSingleTraversalExtended(root,x,y);
           if(v1&&v2)
           return lca;
           
           return null;
       }
       public Node LCAUsingSingleTraversalExtended(Node root, int x,int y)
       {
           if(root==null)
           return null;
           
           Node temp=null;
           if(root.data==x )
           {
               v1=true;
               temp=root;
               
           }
             if(root.data==y)
           {
              v2=true;
              temp=root;
            
           }
           Node leftN=LCAUsingSingleTraversalExtended(root.left,x,y);
           Node rightN=LCAUsingSingleTraversalExtended(root.right,x,y);
           
           if(temp!=null)
           return temp;
           
           if(leftN!=null && rightN!=null)
           return root;
           
           return (leftN!=null)? leftN:rightN;
           
           
       }
       private void printList(LinkedList<Integer> paths)
       {
           System.out.print(paths);
           System.out.println();
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
       
        
       //tree.printpathsLeafToRoot(tree.root);
       System.out.println(tree.LCAUtil(tree.root,4,5)!=null?tree.LCAUtil(tree.root,4,5).data:"Keys not present");
       System.out.println(tree.LCAUtil(tree.root,4,6)!=null?tree.LCAUtil(tree.root,4,6).data:"Keys not present");
       System.out.println(tree.LCAUtil(tree.root,3,4)!=null?tree.LCAUtil(tree.root,3,4).data:"Keys not present");
       System.out.println(tree.LCAUtil(tree.root,2,4)!=null?tree.LCAUtil(tree.root,2,4).data:"Keys not present");
       System.out.println(tree.LCAUtil(tree.root,4,8)!=null?tree.LCAUtil(tree.root,4,8).data:"Keys not present");
       
    }
    
}