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
    
    static class MaxLevel
    {
        int max_level;
       
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
  Print Left View of a Binary Tree Recursive Solution
*/
public void printLeftViewOfTree(Node root)
{
  if(root==null)
  return ;
  
  MaxLevel m=new MaxLevel();
  m.max_level=0;
  printLeftViewOfTreeUtil(root,1,m);
}

public void printLeftViewOfTreeUtil(Node root, int level, MaxLevel max_sofar)
{
  if(root==null)
    return;
  if(max_sofar.max_level<level)
  {
    System.out.print(root.data+" ");
    max_sofar.max_level=level;
  }

printLeftViewOfTreeUtil(root.left,level+1,max_sofar);
printLeftViewOfTreeUtil(root.right,level+1,max_sofar);
}


/*
  Print Left View Iterative usinf BFS or Level Order Traversal
*/
public void printLeftViewIterative(Node root)
{
  if(root==null)
  return;
  Queue<Node> q=new LinkedList<>();
  q.add(root);
  while(!q.isEmpty())
   {
      int nodeCount=q.size();
      for(int i=1;i<=nodeCount;i++)
       {
          Node temp=q.remove();
          if(i==1)
          {
              System.out.print(temp.data+" ");
          }
          if(temp.left!=null)
            q.add(temp.left);
          if(temp.right!=null)
            q.add(temp.right);
       
          
       }
   }
}


}
public static void main(String[] args)
{
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);

     //tree.diagonalPrintOfTree(tree.root);
        //tree.printLeftViewOfTree(tree.root);
        tree.printLeftViewIterative(tree.root);
        

}
}

