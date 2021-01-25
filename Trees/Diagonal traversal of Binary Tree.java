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
  Diagonal Print of Binary Tree Recursive Approach
*/
public void diagonalPrintOfTree(Node root)
{
  if(root==null)
  return;

  Map<Integer, List<Node>> map=new HashMap<>();

  diagonalPrintOfTreeUtil(root,map,0);

    for(int a:map.keySet())
    {
        for(Node x:map.get(a))
        {
        System.out.print(x.data+" ");
        }
    System.out.println();
    }
}
public void diagonalPrintOfTreeUtil(Node root,Map<Integer,List<Node>> map,int d)
{
      if(root==null)
       return;
       List<Node> l=map.get(d);
       if(l==null)
       {
           l=new ArrayList<>();
           l.add(root);
           
       }
        else
        {
            
            l.add(root);
           
        }
        map.put(d,l);
    diagonalPrintOfTreeUtil(root.left,map,d+1);
    diagonalPrintOfTreeUtil(root.right,map,d);
}

/*
   Diagonal  traversal of tree using Iterative approach
*/
public void diagonalTraversalIterative(Node root)
{
    if(root==null)
       return;
    
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    Node x=root;
    while(x.right!=null)
    {
        q.add(x.right);
        x=x.right;
    }
    
    while(!q.isEmpty())
    {
        int n=q.size();
        while(n>0)
        {
            Node temp=q.remove();
            if(temp.left!=null)
            {
                q.add(temp.left);
                Node node=temp.left;
                while(node.right!=null)
                {
                    q.add(node.right);
                    node=node.right;
                }
                
            }
        
            System.out.print(temp.data+" ");
            n--;
        }
        System.out.println();
        
    }
}
}
public static void main(String[] args)
{
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.right = new Node(10);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);

     //tree.diagonalPrintOfTree(tree.root);
     tree.diagonalTraversalIterative(tree.root);

}
}

