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
    
   
    
    
    static class Result
    {
      int res;
     
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
   Maximum difference between node and its ancestor in Binary Tree

*/
public int maxDifferenceWithAncestor(Node root)
{
    if(root==null)
       return -1;
       
    Result  result=new Result();
    maxDifferenceWithAncestorUtil(root,result);
    return result.res;
}

public int maxDifferenceWithAncestorUtil(Node root, Result result)
{
    if(root==null)
      return Integer.MAX_VALUE;
      
    if(root.left==null && root.right==null)
    {
        return root.data;
    }
    
    int leftMin=maxDifferenceWithAncestorUtil(root.left,result);
    int rightMin=maxDifferenceWithAncestorUtil(root.right,result);
    
    int min=Math.min(leftMin,rightMin);
    result.res=Math.max(result.res,root.data-min);
    
    return Math.min(min,root.data);
}
}
public static void main(String[] args)
{
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(8); 
        tree.root.left = new Node(3); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(6); 
        tree.root.left.right.left = new Node(4); 
        tree.root.left.right.right = new Node(7); 
   
        tree.root.right = new Node(10); 
        tree.root.right.right = new Node(14); 
        tree.root.right.right.left = new Node(13); 
        
        System.out.println(tree.maxDifferenceWithAncestor(tree.root));
      
      
            
        
       
        

}
}

