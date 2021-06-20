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
	        
	        public Node removeLastOccurrenceOf(Node head,int key)
	        {
	            Node node=head;
	            Node prev=null;
	            Node res=null;
	            Node n=null;
	            while(node!=null)
	            {
	                if(node.data==key)
	                {
	                    res=node;
	                    n=prev;
	                }
	                prev=node;
	                node=node.next;
	            }
	            if(n!=null)
	            n.next=res.next;
	            else
	            head=head.next;
	            
	            res.next=null;
	            return head;
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
			l.addNode(4);
			l.addNode(4);
			
			l.head=l.removeLastOccurrenceOf(l.head,4);
			l.printList(l.head);
		   
		}

	
	
}
