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
        Is Palindrome Linked List Iterative Approach
    */
    public boolean isPalindromeIterative(Node head)
{
   if(head==null || head.next==null)
	return true;
        

    Node slow=head;
   
    Node fast=head;

	    Node firstHalf=head;
	    Node prev=null;
        //Find middle element in LL

    while(fast!=null && fast.next!=null)
      {
         prev=slow;
         slow=slow.next;
         fast=fast.next.next;
      }


    Node middle=null;
    
    if(fast!=null)
    {
        middle=slow;
        slow=slow.next;
    }
    Node secondH=slow;
    prev.next=null;
    secondH=reverse(secondH);
    
    boolean flag=compare(firstHalf,secondH);
    
    secondH=reverse(secondH);
    
    if(middle!=null)
    {
       prev.next=middle;
       middle.next=secondH;
    }else{
    prev.next=secondH;
    }
    return  flag;
    }
    
    public Node reverse(Node n)
    {
     	Node prev=null;
    	Node curr=n;
    	Node nextNode=null;
    
    	while(curr!=null)
    	{
    		
               		nextNode=curr.next;
    		curr.next=prev;
    		prev=curr;
    		curr=nextNode;
    	}
    	return  prev;
}

    public  boolean compare(Node first,Node second)
    {
    	while(second!=null)
    	{ 
    		if(second.data!=first.data)
    		return  false;
    		second=second.next;
    		first=first.next;
    	}
    	return true;
    }

    Node left;
    public  boolean isPalindromeRecursive(Node node)
    {
        left=node;
        boolean result=isPalindromeHelper(node);
        return result;
    }
    
    public boolean isPalindromeHelper(Node right)
    {
        if(right==null)
        return true;
        
        boolean res=isPalindromeHelper(right.next);
        if(res==false)
        return false;
        
        boolean rs=(right.data)==(left.data);
        left=left.next;
        return rs;
        
    }
    
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		
		LinkedList list=new LinkedList();
	    //list.addLast(1); 
        //list.addLast(0); 
       // list.addLast(1);
        list.addLast(1); 
        list.addLast(2);
        list.addLast(2);
        list.addLast(1);
  
      
        System.out.println(list.isPalindromeIterative(list.head));
        System.out.println(list.isPalindromeRecursive(list.head));
	
	   
	}
}