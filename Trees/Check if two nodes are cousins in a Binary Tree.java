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
  int level;
  int parent;
}

 static class PairN
{
  Node node;
  Node parent;
  
  PairN(Node node,Node parent)
  {
      this.node=node;
      this.parent=parent;
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
  Check if given two nodes are cousins
*/
public void checkCousinsNode(Node root, int a, int b)
{
   if(root==null)
    return;

Pair n1=new Pair();
Pair n2=new Pair();
checkCousinsNodeUtil(root,null,a,b,n1,n2,1);

if(n1.level==n2.level)
{
   if(n1.parent!=n2.parent)
   {
     System.out.print("Given nodes are cousins"+" "+n1.level+" "+n2.level+" "+n1.parent+" "+n2.parent);
   }
   else
   {

     System.out.print("Given nodes are not  cousins"+" "+n1.level+" "+n2.level+" "+n1.parent+" "+n2.parent);

 }
}
else
   {

     System.out.print("Given nodes are not cousins"+" "+n1.level+" "+n2.level+" "+n1.parent+" "+n2.parent);

 }

}
public void checkCousinsNodeUtil(Node root,Node parent,int aKey,int bKey,Pair a, Pair b, int l)
{
   if(root==null)
     return;
  checkCousinsNodeUtil(root.left,root,aKey,bKey,a,b, l+1);
  
  if(root.data==aKey)
  {
  a.level=l;
  a.parent=parent.data;
  }
  if(root.data==bKey)
 {
  b.level=l;
  b.parent=parent.data;

 }

 checkCousinsNodeUtil(root.right,root,aKey,bKey,a,b, l+1);


}
/*
  Using Recursion
*/
public boolean checkCousinsRecursion(Node root, int aKey, int bKey)
{
     if(root==null)
     {
         return false;
     }
     
     int nl1=getNodeLevel(root, aKey,1);
     int nl2=getNodeLevel(root,bKey,1);
     System.out.println(nl1+" "+nl2);
     if(nl1!=nl2)
       return false;
     System.out.println(areSiblings(root,aKey,bKey));
     return areSiblings(root,aKey,bKey);
     
}

public boolean areSiblings(Node root, int aKey, int bKey)
{
    if(root==null)
      return false;
   
    if(root.left!=null && root.right!=null){   
    if((root.left.data==aKey && root.right.data==bKey)||
       (root.left.data==bKey&& root.right.data==aKey))
    {
        return true;
    }
    }
    
   boolean flagl=areSiblings(root.left,aKey,bKey);
   if(flagl)
      return true;
      
    boolean flagr=areSiblings(root.right,aKey,bKey);
    
      return flagr;
      
    
    
}
public int getNodeLevel(Node root,int key, int level)
{
    if(root==null)
       return 0;
     
     if(root.data==key)
     {
         return level;
     }
    
    int leftLevel=getNodeLevel(root.left,key,level+1);
    if(leftLevel!=0)
       return leftLevel;
       
    return getNodeLevel(root.right, key,level+1);
}
/*
   Iterative Approach to check if given two nodes are cousins or not using Level order traversal
*/
public boolean checkIfCousins(Node root, int aKey, int bKey)
{
    if(root==null)
       return false;
    System.out.println(aKey+" "+bKey);
    Queue<PairN> q=new LinkedList<>();
    Node pa=null;
    Node pb=null;
    
    q.add(new PairN(root,null));
    int l=1;
    while(!q.isEmpty())
    {
        int nodeCount=q.size();
        while(nodeCount-->0)
        {
            
            PairN temp=q.remove();
            if(temp.node.data==aKey)
            {
                pa=temp.parent;
                
            }
            if(temp.node.data==bKey)
            {
                pb=temp.parent;
            }
            if(temp.node.left!=null)
              q.add(new PairN(temp.node.left,temp.node));
            if(temp.node.right!=null)
              q.add(new PairN(temp.node.right,temp.node));
              
            if(pa!=null && pb!=null)
              break;
        }
        if(pa!=null && pb!=null)
        {
            System.out.println(pa.data+" "+pb.data);
          return pa.data==pb.data;
        }
          
        if((pa!=null && pb==null)|| (pa==null && pb!=null))
            return false;
    }
    return false;
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
                           
        //tree.checkCousinsNode(tree.root,9,10);
        
        boolean sts=tree.checkIfCousins(tree.root,8,6);
        System.out.println(sts);
    if(sts==false)
      System.out.println("Given keys are cousins");
    else
      System.out.println("Given keys are not cousins");
      
      
            
        
       
        

}
}

