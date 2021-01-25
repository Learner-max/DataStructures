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
  Print cousins of a node in a Binary Tree Iterative Approach
*/
public void printCousins(Node root,Node n)
{
    if(root ==null || n== null)
    return ;
    if(root.data==n.data)
    {
        System.out.println("No Cousins Node");
        return;
    }
    //Simple Level Order Traversal
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    boolean f=false;
    while(!q.isEmpty() && f==false)
    {
        int nodeCount=q.size();
        int nc=nodeCount;
        while(nc>0)
        {
        Node temp=q.remove();
        
    	if (temp.left != null && temp.left.data == n.data)
		f=true;

		else if (temp.right != null && temp.right.data == n.data)
			f=true;
        else
        {
            if(temp.left!=null )
            q.add(temp.left);
            if(temp.right!=null)
            q.add(temp.right);
        
        }
         nc--;
        }
    
    }
    if( f== true)
    {
        int size=q.size();
        if(size==0)
        {
            System.out.println("No Cousins Node");
            return;
        }
    
        while(!q.isEmpty())
        {
        System.out.print(q.remove().data+" ");
        }
    }else
    {
        System.out.println("No Cousins Node");
    }
}

/*
  Print Cousins Recursive
*/
public void printCousinsRecursive(Node root, Node node)
{
    if(root==null || node.data==root.data)
    return;
    
    int givenLevel=getLevelOfNode(root, node,1);
    System.out.println(givenLevel);
    printCousinsRecursiveUtil(root,node,givenLevel);
}

public int getLevelOfNode(Node root, Node node, int level)
{
    if(root==null)
    return -1;
    
    if(root.data==node.data)
    return level;
    
    int nodeLevel=getLevelOfNode(root.left,node,level+1);
    if(nodeLevel!=-1)
    return nodeLevel;
    nodeLevel=getLevelOfNode(root.right,node,level+1);
    
    return nodeLevel;
    
}

public void printCousinsRecursiveUtil(Node root,Node node, int level)
{
    if(root==null || level<2)
    return;
    
    if(level==2)
    {
        if(root.left!=null && root.left.data==node.data) 
        return;
        if(root.right!=null && root.right.data==node.data)
        return;
        if(root.left!=null)
        System.out.print(root.left.data+" ");
        if(root.right!=null)
        System.out.print(root.right.data+" ");
        
    }
    else if(level>2)
    {
    printCousinsRecursiveUtil(root.left,node,level-1);
    printCousinsRecursiveUtil(root.right,node,level-1);
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
	tree.root.left.left.left = new Node(8);
		tree.root.left.left.right = new Node(9);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(11);

		tree.root.right.left.left = new Node(12);
		tree.root.right.right.left = new Node(14);
		tree.root.right.right.right = new Node(15);

  tree.printCousins(tree.root,new Node(14));
  System.out.println();
  tree.printCousinsRecursive(tree.root,new Node(14));

}
}

