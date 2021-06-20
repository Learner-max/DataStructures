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
	        
	      public Node rotateLinkedList(Node node , int k)
	      {
	          if(node==null)
	          return null;
	          
	          if(k==0)
	          return node;
	          int count=1;
	          Node curr=node;
	          while(count<k)
	          {
	             curr=curr.next;
	             count++;
	          }
	          Node temp=head;
	          head=curr.next;
	          tail.next=temp;
	          curr.next=null;
	          
	          return head;
	          
	      }
	    }
		public static void main (String[] args) throws java.lang.Exception
		{
			// your code goes here
			
			LinkedList l=new LinkedList();
			
			l.addNode(10);
			l.addNode(20);
			l.addNode(30);
			l.addNode(40);
			l.addNode(50);
			l.addNode(60);
	
			
			l.head=l.rotateLinkedList(l.head,4);
			l.printList(l.head);
		   
		}

	
	
}
