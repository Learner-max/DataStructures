/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static class Node
    {
        Node right;
        Node left;
        int data;
        Node(int data)
        {
            this.data=data;
        }
    }
    static class BinaryTree
    {
        Node root;
        
        public void levelOrderTraversalIterative(Node node)
        {
            Queue<Node> q=new LinkedList<>();
            q.add(node);
          
            while(!q.isEmpty())
            {
                int size=q.size();
                while(size>0)
                {
                    Node n=q.remove();
                    System.out.println(n.data);
                    if(n.left!=null)
                    q.add(n.left);
                    if(n.right!=null)
                    q.add(n.right);
                    size--;
                } 
            }
            
            //System.out.println(sum);
           
        }
        public int heightOfTree(Node node)
        {
            if(node==null)
              return -1;
            
            int lh=heightOfTree(node.left);  
            int rh=heightOfTree(node.right);
            int th=Math.max(lh,rh)+1;
            return th;
        }
        
        public void printLevelOrder(Node node)
        {
            int height=heightOfTree(node);
            for(int i=0;i<=height;i++)
            {
                levelOrderTraversalRecursive(node,i);
            }
        }
        public void levelOrderTraversalRecursive(Node node, int level)
        {
            
            if(level==0)
            System.out.println(node.data);
            if(node.left!=null)
            levelOrderTraversalRecursive(node.left,level-1);
            if(node.right!=null)
            levelOrderTraversalRecursive(node.right,level-1);
            
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		BinaryTree tree=new BinaryTree();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        
       //tree.levelOrderTraversal(tree.root);
	   tree.printLevelOrder(tree.root); 	
		
	}
}
