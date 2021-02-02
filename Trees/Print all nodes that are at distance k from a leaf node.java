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
    
       Node right;
       Node left;
        Node (int data)
        {
           this.data=data;
        }
    }
    
   
    
    
    static class PairN
    {
      int left;
      int right;
     
    }


 
static class BinaryTree
{
    Node root;
   
public void traversePreOrderRecursion(Node root)
{
    if(root==null)
    {
    return;
    }
    System.out.print(root.data+" ");
    traversePreOrderRecursion(root.left);
    traversePreOrderRecursion(root.right);
}

public void traverseInOrderRecursion(Node root)
{
    if(root==null)
    {
    return;
    }
    traverseInOrderRecursion(root.left);
    System.out.print(root.data+" ");
    traverseInOrderRecursion(root.right);
}




public void traversePostOrderRecursion(Node root)
{
    if(root==null)
    {
    return;
    }
    traversePostOrderRecursion(root.left);
    traversePostOrderRecursion(root.right);
    System.out.print(root.data+" ");
}

/*
  Size of a Binary Tree -Total Number of Nodes in tree
*/
public int sizeOfBinaryTree(Node root)
{
      if(root==null)
       return 0;
    int lsize=sizeOfBinaryTree(root.left);
    int rsize=sizeOfBinaryTree(root.right);
    
    return lsize+rsize+1;
}

/*
  Level Order Traversal of Tree -Iterative
*/
public void levelOrderTraversalIterartive(Node root)
{
       if(root==null)
        return;
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    while(!q.isEmpty())
    {
       Node temp=q.remove();
       System.out.print(temp.data+" ");
       if(temp.left!=null)
       q.add(temp.left);
       if(temp.right!=null)
       q.add(temp.right);
    }
}

/*
   Print node as at distance k from leaf nodes 
*/

public void printNodesKDistFromLeaf(Node root, int k)
{
    if(root==null)
      return;
      
    int[] parentNodes=new int[1000];
    boolean[] visitedNodes=new boolean[1000];
    
    printNodesKDistFromLeafUtil(root,k,parentNodes,visitedNodes,0);
}
public void printNodesKDistFromLeafUtil(Node root,int k,int[] parentNodes,boolean[] visitedNodes,int level)
{
    if(root==null)
     return ;
    
    parentNodes[level]=root.data;
    visitedNodes[level]=false;
    
    if((root.left==null && root.right==null) && level-k>=0 && visitedNodes[level-k]==false)
    {
        System.out.print(parentNodes[level-k]+" ");
        visitedNodes[level-k]=true;
        return;
    }
    printNodesKDistFromLeafUtil(root.left,k,parentNodes,visitedNodes,level+1);
    printNodesKDistFromLeafUtil(root.right,k,parentNodes,visitedNodes,level+1);
}

	
}
public static void main(String[] args)
{
        BinaryTree tree = new BinaryTree(); 
       /* tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(12);
        tree.root.right.left = new Node(16);
        tree.root.right.right = new Node(25);
        tree.root.right.left.left = new Node(18);*/
        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(8);
        tree.root.left.left.right.left = new Node(9);
         
        System.out.println(" Nodes at distance 2 are :");
   
        //tree.printNodesKDistFromLeaf(tree.root,2);
        
        
        System.out.println("\n++++++++++++++++");
        System.out.println(" Nodes at distance 3 are :");
   
        tree.printNodesKDistFromLeaf(tree.root,3);
       
          System.out.println("\n++++++++++++++++");
        System.out.println(" Nodes at distance 1 are :");
   
        tree.printNodesKDistFromLeaf(tree.root,1);
        
        
          System.out.println("\n++++++++++++++++");
        System.out.println(" Nodes at distance 4 are :");
   
        tree.printNodesKDistFromLeaf(tree.root,1);
      
        
      
      
            
        
       
        

}
}

