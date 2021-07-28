/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static class Node
    {
        Node left;
        Node right;
        int data;
        Node(int data)
        {
            this.data=data;
        }
    }
    
    static class BinaryTree
    {
        Node root;
        
        public void printAncestors(Node node, int key){
            if(node==null)
            {
                return;
            }
            List<Integer> ancestor=new ArrayList<>();
            getAncestorUtil( node,  key, ancestor);
            
            for(int a:ancestor)
            {
                System.out.println(a);
            }
        }
        
        public Node getAncestorUtil(Node node, int key, List<Integer> ancestor)
        {
            if(node==null)
              return null;
            if(node.data==key)
            {
                return node;
            }
            
            Node left=getAncestorUtil(node.left, key,ancestor);
            Node right=getAncestorUtil(node.right, key,ancestor);
            if(left!=null || right!=null)
            {
                ancestor.add(node.data);
                return node;
            }
            
            return null;
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
        tree.root.left.left.left = new Node(7);
        
        tree.printAncestors(tree.root,7);
		
		
	}
}
