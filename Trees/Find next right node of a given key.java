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
   Find next right node of a given key
*/

public void findNextRightNodeUtil(Node root,int key)
{
    if(root==null)
      return ;
    
    Node rightNode=findNextRightNode(root, key);
    if(rightNode==null)
      System.out.println("No right Node next to given key " +key);
    else
      System.out.println("Right Node of "+ key +" "+ rightNode.data);
}
public Node findNextRightNode(Node root,int key)
{
  if(root==null)
    return null;
//Do Level order traversal
Queue<Node> q=new LinkedList<>();
q.add(root);

while(!q.isEmpty())
{
   int nodeCount=q.size();
   //int n=nodeCount;
   //int c=1;
   while(nodeCount-->0)
   {
     Node temp=q.remove();
     if(temp.data==key && nodeCount!=0)
      {
          //c<n
         Node temp_=q.peek();
         if(temp_==null)
           return null;
        else
           return temp_;
      }
    if(temp.left!=null)
      q.add(temp.left);
    if(temp.right!=null)
      q.add(temp.right);
   //nodeCount--;
  // c++;
   }

}
return null;
}
/*
   Using Pre order traversal
*/
public void findNextRightNodePreOrder(Node root,int key)
{
    if(root==null)
      return;
    NodeLevel l=new NodeLevel();
    l.level=-1;
    Node res=findNextRightNodePreOrderUtil(root,key,1,l);
    if(res==null)
      System.out.println("No right Node next to given key " +key);
    else
      System.out.println("Right Node of "+ key +" "+ res.data);
}
public Node findNextRightNodePreOrderUtil(Node root,int key, int l,NodeLevel nl)
{
    if(root==null)
      return null;
    if(root.data==key)
    {
        nl.level=l;
        return null;
    }
    if(nl.level==l)
    {
        return root;
    }
    
    Node leftN=findNextRightNodePreOrderUtil(root.left,key,l+1,nl);
    if(leftN!=null)
      return leftN;
    return findNextRightNodePreOrderUtil(root.right,key,l+1,nl);
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
        tree.root = new Node(10); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(6); 
        tree.root.right.right = new Node(5); 
        tree.root.left.left = new Node(8); 
        tree.root.left.right = new Node(4); 
   
        tree.findNextRightNodeUtil(tree.root, 10); 
        tree.findNextRightNodeUtil(tree.root, 2); 
        tree.findNextRightNodeUtil(tree.root, 6); 
        tree.findNextRightNodeUtil(tree.root, 5); 
        tree.findNextRightNodeUtil(tree.root, 8); 
        tree.findNextRightNodeUtil(tree.root, 4);
        
        System.out.println();
        
        tree.findNextRightNodePreOrder(tree.root, 10); 
        tree.findNextRightNodePreOrder(tree.root, 2); 
        tree.findNextRightNodePreOrder(tree.root, 6); 
        tree.findNextRightNodePreOrder(tree.root, 5); 
        tree.findNextRightNodePreOrder(tree.root, 8); 
        tree.findNextRightNodePreOrder(tree.root, 4);
        
        
       
        

}
}

