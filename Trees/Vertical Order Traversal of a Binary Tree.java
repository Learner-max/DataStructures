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
    
    static class Pair
    {
        int hd;
        Node node;
        
        Pair(int hd,Node node)
        {
            this.hd=hd;
            this.node=node;
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
  Binary Tree Vertical Order
*/
public void printVerticalOrder(Node root)
{
    if(root==null)
     return ;
     
     Queue<Pair> q=new LinkedList<>();
     Map<Integer,List<Integer>> map=new HashMap<>();
     int min=0;
     int max=0;
     q.add(new Pair(0,root));
     
     while(!q.isEmpty())
     {
         Pair temp=q.remove();
         
         List<Integer> verticalLine=map.get(temp.hd);
         if(verticalLine==null)
         {
             verticalLine=new ArrayList<>();
             verticalLine.add(temp.node.data);
             
         }
        else
        {
            verticalLine=map.get(temp.hd);
            verticalLine.add(temp.node.data);
        }
        map.put(temp.hd,verticalLine);
        if(temp.node.left!=null)
        {
            
            q.add(new Pair(temp.hd-1,temp.node.left));
            
        }
         if(temp.node.right!=null)
        {
             q.add(new Pair(temp.hd+1,temp.node.right));
        }
        min=temp.hd<min?temp.hd:min;
        max=temp.hd>max?temp.hd:max;
     }
   
     for(int i=min;i<=max;i++)
     {
         for(int lineNodes:map.get(i))
          System.out.print(lineNodes+" ");
          
        System.out.println();
     }
}

}
public static void main(String[] args)
{
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.left.right = new Node(11);
        tree.root.right.right.left.right.right = new Node(12);

     //tree.diagonalPrintOfTree(tree.root);
     tree.printVerticalOrder(tree.root);

}
}

