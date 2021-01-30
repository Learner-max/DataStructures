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
  Boundary Order traversal of a Binary tree
*/
public void printBoundaryMain(Node root)
{
  if(root==null)
    return;

System.out.print(root.data+" ");
if(root.left!=null)
printBoundaryLeftBoundary(root.left);

printBoundaryLeaf(root);

if(root.right!=null)
printBoundaryRightBoundary(root.right);

}

//Print Left Boundary of a Binary Tree
public void printBoundaryLeftBoundary(Node root)
{
  if(root==null)
     return;
while(root.left!=null || root.right!=null)
{
   System.out.print(root.data+" ");
   if(root.left!=null)
   root=root.left;
   else
   root=root.right;
}
}

//Print Leaf Nodes of a Binary Tree
public void printBoundaryLeaf(Node root)
{
  if(root==null)
    return;
  if(root.left==null && root.right==null)
  {
    System.out.print(root.data+" ");
  }else
  {
    printBoundaryLeaf(root.left);
    printBoundaryLeaf(root.right);
  }
}

//Print right Boundary of a Binary tree
public void printBoundaryRightBoundary(Node root)
{ 
  if(root==null)
  return;
  if(root.left!=null || root.right!=null)
   {
      if(root.right!=null)
      {
    
        printBoundaryRightBoundary(root.right);
        

      }
	 else
      {
        printBoundaryRightBoundary(root.left);
       
      }
    System.out.print(root.data+" ");

   }  
}
/*
  Boundary Tree traversal Approach#3 Single tree traversal
*/
public void printTreeBoundary(Node root)
{
    if(root==null)
     return;
    
    if(root.left==null && root.right==null)
     {
         System.out.print(root.data+" ");
         return;
     }
    LeftFlag Lflag=new LeftFlag();
    Lflag.flagL=true;
    printTreeBoundaryUtil(root,true,true,Lflag);
}

public void printTreeBoundaryUtil(Node root,boolean flagr,boolean rootFlag, LeftFlag Lflag)
{
    if(root==null)
      return;
      
    //for printing leaf nodes
    if(root.left==null && root.right==null)
    {
        System.out.print(root.data+" ");
        Lflag.flagL=false;//end of left boundary 
        return;
    }
    
    if(Lflag.flagL==true)
    {
        System.out.print(root.data+" ");//printing left boundary from top to bottom
    }
    
    printTreeBoundaryUtil(root.left,false,false,Lflag);
    
    if(flagr==true)
    {
        printTreeBoundaryUtil(root.right,true,false,Lflag);
    }else
    {
        printTreeBoundaryUtil(root.right,false,false,Lflag);
    }
    
    if(flagr==true && rootFlag==false)
    {
        System.out.print(root.data+" ");//print right boundary from bottom to up
    }
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
        tree.root.left = new Node(2);
	tree.root.left.left = new Node(20);
	tree.root.left.right = new Node(3);
	tree.root.left.right.right = new Node(4);
	tree.root.left.right.right.left = new Node(5);
	tree.root.left.right.right.right = new Node(6);
	tree.root.right = new Node(14);
	tree.root.right.right = new Node(13);
	tree.root.right.right.right = new Node(21);
	tree.root.right.left = new Node(10);
	tree.root.right.left.left = new Node(9);
	tree.root.right.left.left.left = new Node(7);
	tree.root.right.left.left.right = new Node(8);
	tree.root.right.right.left = new Node(12);
	tree.root.right.right.left.right = new Node(11);

     
        tree.printBoundaryMain(tree.root);
        System.out.println();
        tree.printTreeBoundary(tree.root);
        

}
}

