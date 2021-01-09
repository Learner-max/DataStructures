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
            Print all paths from root to leaf in a Binary tree
       */
       
       public void printpathsLeafToRoot(Node root)
       {
           if(root==null)
           return;
           int[] paths=new int[1000];
           int level=0;
           printpaths(root,paths,level);
           return;
           
       }
       
       public void printpaths(Node root,int[] paths, int level)
       {
           if(root!=null)
           {
             paths[level]=root.data;
             level++;
           }
           if(root.left==null && root.right==null)
           {
               printArray(paths,level);
           }
           if(root.left!=null)
           printpaths(root.left,paths,level);
           
           if(root.right!=null)
           printpaths(root.right,paths,level);
       }
       
       private void printArray(int[] paths,int level)
       {
           for(int i=0;i<level;i++)
           {
               System.out.print(paths[i]+" ");
           }
           
           System.out.println();
       }
       
   /*
        Print all nodes from root to leaf -Using Inorder Traversal
   */
     public void printpathsLeafToRootInOrder(Node root)
       {
           if(root==null)
           return;
           LinkedList<Integer> paths=new LinkedList<>();
           
           printpathsInOrder(root,paths);
           return;
           
       }
       public void printpathsInOrder(Node root,LinkedList<Integer> paths)
       {
           if(root== null)
           return;
           
           paths.add(root.data);
           printpathsInOrder(root.left,paths);
           
           if(root.left==null && root.right==null)
           printList(paths);
           
           printpathsInOrder(root.right,paths);
            
           paths.removeLast();
     
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
         
        tree.root.left.right = new Node(5); 
       
        
       //tree.printpathsLeafToRoot(tree.root);
       tree.printpathsLeafToRootInOrder(tree.root);
    }
    
}
