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
  Get Level of a Given node from Binary tree Recursive
*/
public int getLevel(Node root,int key)
{
   if(root==null)
   return -1;
   return getLevelUtil(root,1,key);
}
private int getLevelUtil(Node root,int level, int key)
{
  if(root==null)
   return -1;
  if(root.data==key)
   return level;
  
 int level2=getLevelUtil(root.left,level+1,key);
 if(level2!=-1)
  return level2;
return getLevelUtil(root.right,level+1,key);
}

/*
 Get level of a tree Iterative Approach
*/
public int getLevelIterative(Node root,int key)
{
if(root ==null)
return -1;

Queue<Node> q=new LinkedList<>();
q.add(root);
int Level=0;
boolean found=false;
while(!q.isEmpty())
{
int nodeCount=q.size();
int n=nodeCount;
while(n>0)
{
   Node temp=q.remove();
   
 if(temp.left!=null)
   q.add(temp.left);
 if(temp.right!=null)
   q.add(temp.right);
if(temp.data==key)
         {
          found=true;
          break;
         }
n--;
}
Level++;
if(found)
{
  return Level;
}
}
return -1;
}




/*
  Print nodes at k distance from root Recursive
*/
public void printNodesAtDistk(Node root, int k)
{
   if(root==null ||k<0)
	return;
   printNodesAtkUtil(root,k);
}
private void printNodesAtkUtil(Node root, int k)
{
  if(root==null)
   return ;
if(k==0)  
{
	System.out.print(root.data+" ");
	return;
}

printNodesAtkUtil(root.left,k-1);
printNodesAtkUtil(root.right,k-1);
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
	tree.root.right.left = new Node(8);

  tree.printNodesAtDistk(tree.root,2);

}
}

