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
    
    static class Diameter
    {
        int dia;
    }
    static class BinaryTree
    {
        Node root;
        int ans=0;
        int rootindex=0; // Used to Construct Binary Tree in recursive approach
        
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
            Diameter of a Binary Tree
       */
       public int diameterBruteForce(Node root)
       {
           if(root==null)
           return 0;
           
           int lh=heightOfBinaryTree(root.left);
           int rh=heightOfBinaryTree(root.right);
           
           ans=Math.max(ans,1+lh+rh);
           
           diameterBruteForce(root.left);
           diameterBruteForce(root.right);
           
           return ans;
       }
       
       
       public int heightOfBinaryTree(Node root)
       {
           if(root ==null)
           return 0;
           
           int l=heightOfBinaryTree(root.left);
           int r=heightOfBinaryTree(root.right);
           
           int h=Math.max(l,r)+1;
           return h;
       }
       
       /*
        Binary Tree construct from inorder and preorder Iterative Approach
       */
       public Node constructTree(int[] inorder,int[] preorder)
       {
           int n1=inorder.length;
           int n2=preorder.length;
           
           if(n1==0|| n2==0)
           return null;
           int pIndex=0;
           int iIndex=0;
           Stack<Node> s=new Stack<>();
           Node root=new Node(preorder[pIndex]);
           Node prev=null;
           s.push(root);
           pIndex++;
           while(pIndex<preorder.length)
           {
               while(!s.isEmpty() && s.peek().data==inorder[iIndex])
               {
                   prev=s.pop();
                   iIndex++;
               }
               Node temp=new Node(preorder[pIndex]);
               if(prev!=null)
               {
                  prev.right= temp;
               }else if(!s.isEmpty())
               {
                   Node curr=s.peek();
                   curr.left=temp;
               }
               s.push(temp);
               prev=null;
               pIndex++;
               
               
           }
           return root;
       }
      
    }
    public static void main(String args[])
    {
       int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
       int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
        
       BinaryTree tree=new BinaryTree();
      //tree.root = tree.constructTree(in, post);
 
       System.out.print(
        "Preorder of the constructed tree : \n");
        tree.root=tree.constructTree(in,pre);
    // Function Call for preOrder
       tree.traverseInOrderRecursion(tree.root);
       
      
       
       
    }
    
}