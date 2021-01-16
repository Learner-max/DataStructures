/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
  
static class Node
    {
        int data;
        Node left;
        Node right;
        
        Node(int data)
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
                return;
            
            System.out.print(root.data+" ");
            traversePreOrderRecursion(root.left);
            traversePreOrderRecursion(root.right);
               
        }
        
        
        public void traverseInOrderRecursion(Node root)
        {
            if(root==null)
                return;
            
            
            traverseInOrderRecursion(root.left);
            System.out.print(root.data+" ");
            traverseInOrderRecursion(root.right);
               
        }
        
        public void traversePostOrderRecursion(Node root)
        {
            if(root==null)
                return;
            
            
            traversePostOrderRecursion(root.left);
            
            traversePostOrderRecursion(root.right);
            System.out.print(root.data+" ");
               
        }
        
       /*
          Size of a Binary tree -Recursive
       */
       public int sizeOfTree(Node root)
       {
           if(root==null)
           return 0;
           
           int ls=sizeOfTree(root.left);
           int rs=sizeOfTree(root.right);
           int res=ls+rs+1;
           return res;
       }
       
       
       /*
            Height of a Binary tree Recursive
       */
       public int height(Node root)
       {
           if(root==null)
           return -1;;
           
           int lh=height(root.left);
           int rh=height(root.right);
           int th=Math.max(lh,rh)+1;
           
           return th;
       }
       /*
            Level Order traversal
       */
        public void traverseLevelOrder(Node root)
       {
           Queue<Node> q=new LinkedList<>();
           
           q.add(root);
           
           while(!q.isEmpty())
           {
               Node temp=q.remove();
               if(temp.left!=null)
               q.add(temp.left);
               if(temp.right!=null)
               q.add(temp.right);
               
               System.out.print(temp.data+" ");
           }
       }
       
       /*
            Lowest Common Ancestor in a Binary Tree using Storing Paths Approach
       */
       public Node LCAUtil(Node root,int x,int y)
       {
           Stack<Node> pathtoX= findPathToNode(root,x);
           Stack<Node> pathtoY=findPathToNode(root,y);
           if(pathtoX==null || pathtoY==null)
           return null;
           Node prev=null;
           while(!pathtoX.isEmpty() && !pathtoY.isEmpty())
           {
               Node s=pathtoX.pop();
               Node q=pathtoY.pop();
               if(s.data==q.data)
               prev=s;
               else
               break;
           }
           return prev;
       }
       public Stack<Node> findPathToNode(Node root, int x)
       {
           if(root==null)
           return null;
           
           if(root.data==x)
           {
               Stack<Node> s1=new Stack<Node>();
               s1.push(root);
               return s1;
           }
           
           Stack<Node> leftS=findPathToNode(root.left,x);
           Stack<Node> rightS=findPathToNode(root.right,x);
           
           if(leftS!=null)
           {
               leftS.push(root);
               return leftS;
           }
           
           if(rightS!=null)
           {
               rightS.push(root);
               return rightS;
           }
           
           return null;
       }
       private void printList(LinkedList<Integer> paths)
       {
           System.out.print(paths);
           System.out.println();
       }
       
       
    
    }
    public static void main(String args[])
    {
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
       
        
       //tree.printpathsLeafToRoot(tree.root);
       System.out.println(tree.LCAUtil(tree.root,4,5)!=null?tree.LCAUtil(tree.root,4,5).data:"Keys not present");
       System.out.println(tree.LCAUtil(tree.root,4,6)!=null?tree.LCAUtil(tree.root,4,6).data:"Keys not present");
       System.out.println(tree.LCAUtil(tree.root,3,4)!=null?tree.LCAUtil(tree.root,3,4).data:"Keys not present");
       System.out.println(tree.LCAUtil(tree.root,2,4)!=null?tree.LCAUtil(tree.root,2,4).data:"Keys not present");
       System.out.println(tree.LCAUtil(tree.root,4,8)!=null?tree.LCAUtil(tree.root,4,8).data:"Keys not present");
       
    }
    
}