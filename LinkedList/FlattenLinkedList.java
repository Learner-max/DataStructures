/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static class Node
    {
       int  data;
       Node right;
       Node down;
       Node(int data)
       {
           this.data=data;
       }
    }
    
    static class LinkedList
    {
        
    Node head;
    public Node addNode(Node refN,int data)
    {
        Node n=new Node(data);
        n.down=refN;
        refN=n;
        return refN;
      
    }
    public void display(Node head)
    {
        if(head==null)
        {
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.down;
        }
    }
   
    public Node flattenList(Node node)
    {
        if(node==null || node.right==null)
          return node;
        
        node.right=flattenList(node.right);
        
        node=mergeList(node,node.right);
        return node;
        
    }
    
    //Merge 2 Sorted List
    public Node mergeList(Node n1,Node n2)
    {
        if(n1==null)
          return n2;
        if(n2==null)
         return n1;
        Node L1=n1;
        Node L2=n2;
        Node dummyHead=new Node(0);
        Node curr=dummyHead;
        while(L1!=null && L2!=null)
        {
            if(L1.data>L2.data)
            {
                curr.down=L2;
                curr=L2;
                L2=L2.down;
            }else
            {
                curr.down=L1;
                curr=L1;
                L1=L1.down;
            }
        }
        if(L1!=null)
        curr.down=L1;
        else
        curr.down=L2;
       // System.out.println(dummyHead.down.right.data);
        return dummyHead.down;
    }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		LinkedList l=new LinkedList();
		
		l.head=l.addNode(l.head,30);
		l.head=l.addNode(l.head,8);
		l.head=l.addNode(l.head,7);
		l.head=l.addNode(l.head,5);
		
		l.head.right=l.addNode(l.head.right,20);
		l.head.right=l.addNode(l.head.right,10);
		
		l.head.right.right=l.addNode(l.head.right.right,50);
		l.head.right.right=l.addNode(l.head.right.right,22);
	    l.head.right.right=l.addNode(l.head.right.right,19);
	    
	    l.head.right.right.right=l.addNode(l.head.right.right.right,45);
		l.head.right.right.right=l.addNode(l.head.right.right.right,40);
		l.head.right.right.right=l.addNode(l.head.right.right.right,35);
		l.head.right.right.right=l.addNode(l.head.right.right.right,28);
		
		Node flattenHead=l.flattenList(l.head);
		l.display(flattenHead);
	   
	}
	
	
}
