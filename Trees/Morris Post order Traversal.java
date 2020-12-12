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
            Morris PreOrder Traversal
        */
        
        public void morrisPostorderTraversal(Node root)
        {
            Node curr=root;
            Node temp=null;
            List<Integer> res=new ArrayList<>();
            if(root ==null)
            return;
            
            while(curr!=null)
            {
                if(curr.right!=null)
                {
                    temp=curr.right;
                    
                    //Here we will find Leftmost node
                    while(temp.left!=null && temp.left!=curr)
                    {
                        temp=temp.left;
                    }
                    
                    if(temp.left==null)
                    {
                        res.add(curr.data);
                        temp.left=curr;
                        curr=curr.right;
                    }
                    else
                    {
                        temp.left=null;
                        curr=curr.left;
                    }
                }else
                {
                    res.add(curr.data);
                    curr=curr.left;
                }
            }
            
            Collections.reverse(res);
            System.out.print(res);
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
        
       /* tree.traverseInOrderRecursion(tree.root);
        System.out.println();
        tree.traversePreOrderRecursion(tree.root);
        System.out.println();
        tree.traversePostOrderRecursion(tree.root);*/
        
        //
        //tree.traverseInOrderIterative(tree.root);
        tree.traversePostOrderRecursion(tree.root);
       // tree.traversePostOrderIterative(tree.root);
        System.out.println();
        //tree.traverseInOrderApproach2(tree.root);
        //tree.traversePreOrderApproach2(tree.root);
        //tree.traversePostOrderApproach2(tree.root);
        tree.morrisPostorderTraversal(tree.root);
    }
}
