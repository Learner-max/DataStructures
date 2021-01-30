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
    
   
    
    
    static class NodeLevel
    {
        int level;
  

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
  
Find multiplication of sums of data of leaves at same levels
*/
public int printProduct(Node root)
{
  if(root==null)
   return -1;
  
  Queue<Node> q=new LinkedList<>();
  q.add(root);
  int prod=1;
  while(!q.isEmpty())
  {
     int nc=q.size();
     int levelsum=0;
     while(nc-->0)
     {
        Node temp=q.remove();
        if(temp.left==null && temp.right==null)
        {
           levelsum=levelsum+temp.data;
           
        }
        if(temp.left!=null)
            q.add(temp.left);
        if(temp.right!=null)
            q.add(temp.right);
       //nc--;


     }
     if(levelsum>0)
     {
     // System.out.print(levelsum+" ");
      prod=prod*levelsum;
     } 
  }
 return prod;
}

/*
  Using pre order traversal
*/
public void sumMultiplyLeafNodes(Node root)
{
   if(root==null)
     return;
   Map<Integer, Integer> map=new HashMap<>();
   sumMultiplyLeafNodesUtil(root,map,0);
  int prod=1;
  for(int a:map.keySet())
  {
       prod=prod*map.get(a);
  }
  System.out.println("The Final Product "+prod);
}
public void sumMultiplyLeafNodesUtil(Node root, Map<Integer, Integer> map, int level)
{
   if(root==null)
     return;
   if(root.left==null && root.right==null)
   {
      if(map.containsKey(level))
         {
             map.put(level,map.get(level)+root.data);
         }
      else
        {
		   map.put(level,root.data);

        }
  }
  sumMultiplyLeafNodesUtil(root.left,map,level+1);
 sumMultiplyLeafNodesUtil(root.right,map,level+1);
}


}
public static void main(String[] args)
{
        BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(2); 
        tree.root.left = new Node(7); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(8); 
        tree.root.left.right = new Node(6); 
        tree.root.left.right.left = new Node(1); 
        tree.root.left.right.right = new Node(11); 
        tree.root.right.right = new Node(9); 
        tree.root.right.right.left = new Node(4); 
        tree.root.right.right.right = new Node(10); 
        //System.out.println("The final product value : "
                          // + tree.printProduct(tree.root)); 
                           
        tree.sumMultiplyLeafNodes(tree.root);
        
        
       
        

}
}

