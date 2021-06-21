/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
     static class Node
	    {
	        Node next;
	        int data;
	        Node(int data)
	        {
	            this.data=data;
	        }
	    }
	    static class LinkedList
	    {
	        Node head;
	        Node tail;
	        public void addNode(int data)
	        {
	            Node n=new Node(data);
	            if(head==null && tail==null)
	            {
	                head=n;
	                tail=n;
	            }else
	            {
	                tail.next=n;
	                tail=n;
	            }
	        }
	        
	        public void printList(Node head)
	        {
	            Node temp=head;
	            while(temp!=null)
	            {
	                System.out.print(temp.data+" -> ");
	                temp=temp.next;
	            }
	        }
	        
	    public Node reverseListInGroup(Node node,int k)
	    {
	        if(node==null)
	         return null;
	         
	       Node curr=node;
	       Node prev=null;
	       Node nextN=null;
	       int count=1;
	       
	       while(count<=k && curr!=null)
	       {
	           nextN=curr.next;
	           curr.next=prev;
	           prev=curr;
	           curr=nextN;
	           count++;
	       }
	       
           node.next=reverseListInGroup(curr,k);
           return prev;
     
         
	    }
	    public Node reverseListInGroupIterative(Node node,int k)
	    {
	        if(node==null)
	        return null;
	        
	        Node curr=node;
	        Node prev=null;
	        Node nextN=null;
	        Node join=null;
	        Node tail=null;
	        Node finalHead=null;
	        while(curr!=null)
	        {
	            int count=1;
	            join =curr;
	            prev=null;
	           while(count<=k && curr!=null)
    	       {
    	           nextN=curr.next;
    	           curr.next=prev;
    	           prev=curr;
    	           curr=nextN;
    	           count++;
    	       }
        	   
        	   if(finalHead==null)
        	   finalHead=prev;
        	   
        	   if(tail!=null)
        	   tail.next=prev;
        	   
        	   tail=join;
	       
	        }
	        return finalHead;
	    }
	    
    }
		public static void main (String[] args) throws java.lang.Exception
		{
			// your code goes here
			
			LinkedList l=new LinkedList();
			
			l.addNode(1);
			l.addNode(2);
			l.addNode(3);
			l.addNode(4);
			l.addNode(5);
			l.addNode(6);
			l.addNode(7);
			l.addNode(8);
			l.addNode(9);
			l.addNode(10);
	
			
			//l.head=l.reverseListInGroup(l.head,3);
			//l.printList(l.head);
			
			l.head=l.reverseListInGroupIterative(l.head,3);
			l.printList(l.head);
		   
		}

	
	
}
