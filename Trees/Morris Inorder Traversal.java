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
    
    //Pair class created for Iterative Tree Traversals
    static class Pair
    {
        Node node;
        int state;
        
        Pair(Node node, int state)
        {
            this.node=node;
            this.state=state;
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
           Tree Traversals Iterative Approach #1 Using State Concept
        */
        public void traverseInOrderIterative(Node node)
        {
            Stack<Pair> s=new Stack<>();
            Pair rt=new Pair(node,1);
            s.push(rt);
            
            while(s.isEmpty()!=true)
            {
                Pair top=s.peek();
                
                if(top.state==1)
                {
                    top.state++;
                    if(top.node.left!=null)
                    {
                        Pair lp=new Pair(top.node.left,1);
                        s.push(lp);
                    }
                }else if(top.state==2)
                {
                    System.out.print(top.node.data+" ");
                    top.state++;
                    if(top.node.right!=null)
                    {
                        Pair rp=new Pair(top.node.right,1);
                        s.push(rp);
                    }
                }else
                {
                    s.pop();
                }
                
            }
        }
        
        public void traversePreOrderIterative(Node node)
        {
            Stack<Pair> s=new Stack<>();
            Pair rt=new Pair(node,1);
            s.push(rt);
            
            while(s.isEmpty()!=true)
            {
                Pair top=s.peek();
                
                if(top.state==1)
                {
                    System.out.print(top.node.data+" ");
                    top.state++;
                    if(top.node.left!=null)
                    {
                        Pair lp=new Pair(top.node.left,1);
                        s.push(lp);
                    }
                }else if(top.state==2)
                {
                    
                    top.state++;
                    if(top.node.right!=null)
                    {
                        Pair rp=new Pair(top.node.right,1);
                        s.push(rp);
                    }
                }else
                {
                    s.pop();
                }
                
            }
        }
        
        public void traversePostOrderIterative(Node node)
        {
            Stack<Pair> s=new Stack<>();
            Pair rt=new Pair(node,1);
            s.push(rt);
            
            while(s.isEmpty()!=true)
            {
                Pair top=s.peek();
                
                if(top.state==1)
                {
                    
                    top.state++;
                    if(top.node.left!=null)
                    {
                        Pair lp=new Pair(top.node.left,1);
                        s.push(lp);
                    }
                }else if(top.state==2)
                {
                    
                    top.state++;
                    if(top.node.right!=null)
                    {
                        Pair rp=new Pair(top.node.right,1);
                        s.push(rp);
                    }
                }else
                {
                    System.out.print(top.node.data+" ");
                    s.pop();
                }
                
            }
        }
        
        /*
            Iterative Tree Traversals Approach#2
        */
        public void traverseInOrderApproach2(Node root)
        {
            if(root==null)
            {
                return ;
            }
            Node curr=root;
            Stack<Node> s=new Stack<>();
            //s.push(curr);
            
            while(curr!=null ||!s.isEmpty())
            {
                while(curr!=null )
                {
                    s.push(curr);
                    curr=curr.left;
                }
                
                curr=s.pop();
                System.out.print(curr.data+" ");
                curr=curr.right;
            }
            
        }
        
        public void traversePreOrderApproach2(Node root)
        {
            if(root==null)
            {
                return ;
            }
            Node curr=root;
            Stack<Node> s=new Stack<>();
            s.push(curr);
            
            while(!s.isEmpty())
            {
                Node node=s.peek();
                System.out.print(node.data+" ");
                s.pop();
                
                if(node.right!=null)
                {
                    s.push(node.right);
                    //curr=curr.left;
                }
                if(node.left!=null)
                {
                     s.push(node.left);
                }
                
            }
        }
            
           
        
        public void traversePostOrderApproach2(Node root)
        {
            if(root==null)
            {
                return ;
            }
            Stack<Node> s1=new Stack<>();
                Stack<Node> s2=new Stack<>();
                s1.push(root);
                
                while(!s1.isEmpty())
                {
                    Node node=s1.pop();
                    s2.push(node);
                    if(node.left!=null)
                    {
                        s1.push(node.left);
                    }
                    if(node.right!=null)
                    {
                        s1.push(node.right);
                    }
                }
                
                while(!s2.isEmpty())
                {
                    Node temp=s2.peek();
                    System.out.print(temp.data+" ");
                    s2.pop();
                }
        }
        
        /*
            Morris InOrder Traversal
        */
        
        public void morrisInorderTraversal(Node root)
        {
            Node curr=root;
            Node prev=null;
            
            if(root ==null)
            return;
            
            while(curr!=null)
            {
                if(curr.left==null)// No Left Sub tree
                {
                    System.out.print(curr.data+" ");
                    curr=curr.right;  // Move the curr poinyter to right subtree
                }
                else  //There is a Left Subtree.
                {
                 // 1. Find the predecessor of this curr node 
                 prev=findPredecessor(curr);
                 
                 if(prev.right==null) // First time traversal, use this to hold the link to curr node
                 {
                     prev.right=curr;
                     curr=curr.left;
                 }
                 else // Visiting it second time then we have to remove the above link
                 {
                     prev.right=null;
                     System.out.print(curr.data+" ");
                     curr=curr.right;
                 }
                }
            }
        }
        
        public Node findPredecessor(Node node)
        {
            //Predecessor is rightmost node in leftsubtree
            
            Node temp=node.left;
            while(temp.right!=null && temp.right!=node)
            {
                temp=temp.right;
            }
            
            return temp;
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
        tree.traverseInOrderIterative(tree.root);
        //tree.traversePreOrderIterative(tree.root);
       // tree.traversePostOrderIterative(tree.root);
        System.out.println();
        //tree.traverseInOrderApproach2(tree.root);
        //tree.traversePreOrderApproach2(tree.root);
        //tree.traversePostOrderApproach2(tree.root);
        tree.morrisInorderTraversal(tree.root);
    }
}
