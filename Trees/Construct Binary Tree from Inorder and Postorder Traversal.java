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
        Binary Tree construct from inorder and postorder Iterative Approach
       */
       public Node constructTree(int[] inorder,int[] postorder)
       {
           int n1=inorder.length;
           int n2=postorder.length;
           
           if(n1==0|| n2==0)
           return null;
           int pIndex=n2-1;
           int iIndex=n1-1;
           Stack<Node> s=new Stack<>();
           Node root=new Node(postorder[pIndex]);
           Node prev=null;
           s.push(root);
           pIndex--;
           while(pIndex>=0)
           {
               while(!s.isEmpty() && s.peek().data==inorder[iIndex])
               {
                   prev=s.pop();
                   iIndex--;
               }
               Node temp=new Node(postorder[pIndex]);
               if(prev!=null)
               {
                  prev.left= temp;
               }else if(!s.isEmpty())
               {
                   Node curr=s.peek();
                   curr.right=temp;
               }
               s.push(temp);
               prev=null;
               pIndex--;
               
               
           }
           return root;
       }
       /*
        Construct Binary Tree using Recusrion
       */
       public Node constructTreeRecursion(int[] inorder,int[] postorder)
       {
           int n=postorder.length;
           if(n==0)
           return null;
            if(n==1)
            {
                return new Node(postorder[n-1]);
            }
            
            rootindex=n-1;
            return buildTreeUtil(inorder,postorder,0,n-1);
        
       }
       
       public Node buildTreeUtil(int[] inorder, int[] postorder, int l,int end)
       {
           if(l>end)
           return null;
           
           Node root=new Node(postorder[rootindex--]);
           int pivot=searchInorder(inorder,root.data);
           
           root.right=buildTreeUtil(inorder,postorder,pivot+1,end);
           root.left=buildTreeUtil(inorder, postorder,l,pivot-1);
           
           return root;
       }
       
       public int searchInorder(int[] inorder, int data)
       {
           for(int i=0;i<inorder.length;i++)
           {
               if(inorder[i]==data)
               return i;
           }
           return -1;
       }
    }
    public static void main(String args[])
    {
       int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
       int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
       BinaryTree tree=new BinaryTree();
      //tree.root = tree.constructTree(in, post);
 
       System.out.print(
        "Preorder of the constructed tree : \n");
        tree.root=tree.constructTreeRecursion(in,post);
    // Function Call for preOrder
       tree.traversePreOrderRecursion(tree.root);
       
      
       
       
    }
    
}