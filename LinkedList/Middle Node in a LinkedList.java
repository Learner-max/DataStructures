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
       Node next;
       
       
       Node(int data)
       {
           this.data=data;
       }
    }
    
    static class LinkedList
    {
        
    Node head;
    Node tail;
    public void addLast(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }else
        {
            tail.next=n;
            tail=n;
        }
    }
    
    public void addFirst(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }else
        {
            n.next=head;
            head=n;
        }
    }
    public void display()
    {
        if(head==null)
        {
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    
    public void removeFirst()
    {
        if(head==null)
        return;
        if(head==tail)
        {
            head=null;
            tail=null;
        }
        else
        {
            head=head.next;
        }
    }
    
    public void removeLast()
    {
        if(head==null)
        {
            return;
        }else 
        {
            Node temp=head;
            while(temp.next.next!=null)
            temp=temp.next;
            temp.next=null;
            tail=temp;
        }
    }
    public int peekFirst()
    {
        if(head==null)
        return -1;
        return head.data;
    }
    
    public int peekLast()
    {
        if(head==null)
        return -1;
        return tail.data;
    }
    
    /*
        Reverse Linked List By Iterative Approach
    */
    public void reverseList(Node n)
    {
        Node prev=null;
        Node nextNode=null;
        Node curr=n;
        
        while(curr!=null)
        {
            nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        tail=head;
        head=prev;
       
    }
    
    /*
       Reverse Linked List By Recursive Approach 
    */    
    public void reverseListRecursive(Node prev,Node curr)
    {
        if(curr!=null)
        {
            reverseListRecursive(curr,curr.next);
            curr.next=prev;
        }else
        {
            head=prev;
        }
    }
    
    /*
        Middle Node in a Linked List In a Single Pass- Using 2 Pointers Approach
    */
    
    public int middleNodeIterative(Node node)
    {
        Node slow =node;
        Node fast =node;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        return slow.data;
    }
    
    /*
        Middle Node in a Linked List Recursive
    */
    
    public int middleNodeRecursive(Node node,int size)
    {
        if(node==null)
        {
            return size%2==0?size/2:size/2+1;
        }
       
            int i=middleNodeRecursive(node.next,size+1)-1;
     
        if(i==0)
        System.out.println(node.data);
        
        return i;
    }
    
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		LinkedList list=new LinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		//System.out.println( "Original LinkedList");
		//list.display();
		/*
		  Reversing Linked List Iterative and Recursive By Pointer
		*/
		/*list.reverseList(list.head);
		System.out.println( "LinkedList after Reverse");
		list.display();
		
		list.reverseListRecursive(null,list.head);
		System.out.println( "LinkedList after Reverse Recursive");
		list.display();*/
		
		System.out.println(list.middleNodeIterative(list.head));
		list.middleNodeRecursive(list.head,0);
		
	   
	}
	
	
}
