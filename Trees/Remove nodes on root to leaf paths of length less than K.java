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
   Remove nodes on root to leaf paths of length < K
*/

public Node removePaths(Node root,int k)
{
    if(root==null)
      return null;
      
    if(k==0)
       return root;
       
    root.left=removePaths(root.left,k-1);
    root.right=removePaths(root.right,k-1);
    
    if(root.left==null && root.right==null)
    {
        return null;
    }
    
    return root;
}
}
public static void main(String[] args)
{
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		//tree.root.left.right = new Node(5); 
		tree.root.left.left.left = new Node(7); 
		tree.root.right.right = new Node(6); 
        tree.traverseInOrderRecursion(tree.root);
        tree.removePaths(tree.root,3);
        System.out.println("\n ++++++++++++++++");
        tree.traverseInOrderRecursion(tree.root);
        
      
      
            
        
       
        

}
}

