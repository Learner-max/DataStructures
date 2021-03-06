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
    
   
    
    
    static class LeftFlag
    {
        boolean flagL;
  

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
    reverse alternate levels in a Binary tree using one tree traversal
*/
public void reverseAlternateTreeLevelNodes(Node root)
{
  if(root==null)
   return;
  reverseAlternateTreeLevelNodesUtil(root.left,root.right,0);
  
}
public void reverseAlternateTreeLevelNodesUtil(Node rootL,Node rootR,int level)
{
   if(rootL==null && rootR==null)
    return;
  
  if(level%2==0)
  {
    
   int temp=rootL.data;
   rootL.data=rootR.data;
   rootR.data=temp;
  }
reverseAlternateTreeLevelNodesUtil(rootL.left,rootR.right,level+1);
reverseAlternateTreeLevelNodesUtil(rootL.right,rootR.left,level+1);


}


}
public static void main(String[] args)
{
        BinaryTree tree=new BinaryTree();
        /*tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(5); 
        tree.root.left.right = new Node(3); 
        tree.root.right.left = new Node(4); 
        tree.root.right.right = new Node(25); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); */
        tree.root=new Node(1);
        tree.root.left=new Node(2);
        tree.root.right=new Node(3);
        tree.root.left.left=new Node(4);
        tree.root.left.right=new Node(5);
        tree.root.right.left=new Node(6);
        tree.root.right.right=new Node(7);
        tree.root.left.left.left=new Node(8);
        tree.root.left.left.right=new Node(9);
        tree.root.left.right.left=new Node(10);
        tree.root.left.right.right=new Node(11);
        tree.root.right.left.left=new Node(12);
        tree.root.right.left.right=new Node(13);
        tree.root.right.right.left=new Node(14);
        tree.root.right.right.right=new Node(15);
        
        tree.traverseInOrderRecursion(tree.root);
        System.out.println();
        System.out.println("After Reverse Nodes at alternate level");
        tree.reverseAlternateTreeLevelNodes(tree.root);
        System.out.println();
        tree.traverseInOrderRecursion(tree.root);
        

}
}

