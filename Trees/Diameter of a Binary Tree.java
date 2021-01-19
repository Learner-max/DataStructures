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
            Approach#2:Improvement in above method to reduce TC to O(n)
       */
        public int diameterApproach2(Node root)
        {
            Diameter d=new Diameter();
            diameterOfBinaryTreeImproved(root,d);
           return d.dia;
        }
        public int diameterOfBinaryTreeImproved(Node root,Diameter d)
        {
            if(root==null)
            {
                
                return 0;
            }
            
            int lh=diameterOfBinaryTreeImproved(root.left,d);
            int rh=diameterOfBinaryTreeImproved(root.right,d);
            
            int temp=Math.max(lh,rh)+1;
            
            int ans=Math.max(temp,1+lh+rh);
            
            d.dia=Math.max(d.dia,ans);
            
            return temp;
            
            
        }
        
        /*
          Approach#3 Improvement of Approach 2 Recursive Apporach o(n)
        */
        public int diaUtil(Node root)
        {
            //int ans=0;
            diameterRecursive(root);
            return ans;
        }
        
        public int diameterRecursive(Node root)
        {
            if(root==null)
            return 0;
            
            int lh=diameterRecursive(root.left);
            int rh=diameterRecursive(root.right);
            
            ans=Math.max(ans,1+lh+rh);
            
            return 1+Math.max(lh,rh);
        }
        
        /*
            Diameter of a Binary Tree Iterative Approach o(n)
        */
        public int diameterBinaryTreeIterative(Node root)
        {
            if(root==null)
            return 0;
            int resultDiameter=0;
            Stack<Node> s=new Stack<>();
            Map<Node,Integer> map=new HashMap<>();
            
            s.push(root);
            
            while(!s.isEmpty())
            {
                Node temp=s.peek();
                if(temp.left!=null && !map.containsKey(temp.left))
                {
                    s.push(temp.left);
                }
                else if(temp.right!=null && !map.containsKey(temp.right))
                {
                    s.push(temp.right);
                }
                else
                {
                    Node node=s.pop();
                    int leftMax=node.left==null?0:map.get(node.left);
                    int rightMax=node.right==null?0:map.get(node.right);
                    map.put(node,Math.max(leftMax,rightMax)+1);
                    //System.out.println(map);
                    resultDiameter=Math.max(resultDiameter,leftMax+rightMax+1);
                    
                    
                }
            }
            
            return resultDiameter;
        }
    }
    public static void main(String args[])
    {
        BinaryTree tree=new BinaryTree();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4);
        tree.root.left.left.right = new Node(5); 
       // tree.root.right.left = new Node(6);
        //tree.root.right.right = new Node(7);
       
        
      
      
      // tree.printTreeSpiral(tree.root);
       //System.out.println(tree.diameterBruteForce(tree.root));
       //System.out.println(tree.diameterApproach2(tree.root));
      // System.out.println(tree.diaUtil(tree.root));
       
       System.out.println(tree.diameterBinaryTreeIterative(tree.root));
       
       
    }
    
}