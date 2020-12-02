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
        Node prev;
        Node next;
        
        Node(int data)
        {
            this.data=data;
            prev=null;
            next=null;
        }
    }
    
    static class LinkedList
    {
        Node head;
        Node tail;
        
        
        public void addLast(int data)
        {
            Node node=new Node(data);
            
            if(head==null)
            {
                head=node;
                tail=node;
            }else
            {
                tail.next=node;
                node.prev=tail;
                tail=node;
            }
        }
        
        public void addFirst(int data)
        {
            Node node=new Node(data);
            if(head==null)
            {
                head=node;
                tail=node;
                
            }else
            {
                node.next=head;
                head.prev=node;
                head=node;
            }
        }
        
        public Node deleteFirst()
        {
            if(head==null)
            {
              throw new RuntimeException("Doubly linked list is already empty");  
            }
                Node temp=head;
                head=head.next;
                head.prev=null;
                temp.next=null;
            
            return temp;
        }
        
        public Node deleteLast()
        {
            if(head==null)
            {
              throw new RuntimeException("Doubly linked list is already empty");  
            }
            
            Node temp=tail;
            tail=tail.prev;
            tail.next=null;
            temp.prev=null;
            
            return temp;
        }
        
        public void iterateForward(Node head)
        {
            Node temp=head;
            while(temp!=null)
            {
                System.out.print(temp.data+" "+(temp.next!=null?temp.next.data:"null")+" "+(temp.prev!=null?temp.prev.data:"null"));
                System.out.println();
                temp=temp.next;
            }
        }
        
        public void iterateBackward(Node tail)
        {
            Node temp=tail;
            
            while(temp!=null)
            {
                System.out.print(temp.data+" ");
                temp=temp.prev;
            }
        }
        
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		LinkedList list=new LinkedList();
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(9);
		
		list.iterateForward(list.head);
		System.out.println();
		list.iterateBackward(list.tail);
	}
}
