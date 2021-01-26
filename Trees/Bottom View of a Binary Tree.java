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
        Pair(int hd, Node node)
        {
            this.hd=hd;
            this.node=node;
        }
    }
    
    static class PairNew
    {
        int data;// Node Data
        int  level;//Vertical Distance or Level of a Tree
       
        PairNew(int data,int level)
        {
            this.data=data;
            this.level=level;
        }
    }
    static class Range
    {
        int min;
        
        int max;

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
   Bottom view of a Binary tree Iterative Approach Using Queue
*/
    public static void BottomViewIterative(Node root) {
      
      if(root==null)
      return;
      Queue<Pair> q=new LinkedList<>();
      q.add(new Pair(0,root));
      Map<Integer,Integer> map=new HashMap<>();
      int min=0;
      int max=0;
      while(!q.isEmpty())
      {
          Pair p=q.remove();
          
          map.put(p.hd,p.node.data);
          
          if(p.node.left!=null)
          {
              q.add(new Pair(p.hd-1,p.node.left));
          }
          if(p.node.right!=null)
          {
              q.add(new Pair(p.hd+1,p.node.right));
          }
          min=p.hd<min?p.hd:min;
          max=p.hd>max?p.hd:max;
      }
      
      for(int i=min;i<=max;i++)
      {
          System.out.print(map.get(i)+" ");
      }
    }
    
/*
  Bottom View of a Binart Tree Recursive
*/
    public void printBottomViewOfTree(Node root)
{
    if(root==null)
      return ;
      
     Map<Integer,PairNew> map=new HashMap<>();
     Range limit=new Range();
     limit.min=0;
     limit.max=0;
     printBottomViewOfTreeUtil(root,map,0,0,limit);
     
     for(int i=limit.min;i<=limit.max;i++)
     {
         System.out.print(map.get(i).data+" ");
     }
}
public void printBottomViewOfTreeUtil(Node root,Map<Integer,PairNew> map,int hdist, int l, Range r)
{
    if(root==null)
     return ;
     
     if(!map.containsKey(hdist))
     {
         map.put(hdist,new PairNew(root.data,l));
     }else if(map.get(hdist).level<=l)
     {
         map.put(hdist,new PairNew(root.data,l));
         
     }
    
    if(hdist<r.min)
    {
        r.min=hdist;
    }
    else if(hdist>r.max)
    {
        r.max=hdist;
    }
    printBottomViewOfTreeUtil(root.left,map,hdist-1,l+1,r);
    printBottomViewOfTreeUtil(root.right,map,hdist+1,l+1,r);
}
}
public static void main(String[] args)
{
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(5); 
        tree.root.left.right = new Node(3); 
        tree.root.right.left = new Node(4); 
        tree.root.right.right = new Node(25); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 

     //tree.diagonalPrintOfTree(tree.root);
        //tree.printLeftViewOfTree(tree.root);
        tree.BottomViewIterative(tree.root);
        
        System.out.println();
        tree.printBottomViewOfTree(tree.root);
        

}
}

