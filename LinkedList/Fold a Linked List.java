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
        Fold a Linked list Recursive Approach
    */
    
    public Node foldList(Node node)
    {
        Node left=node;
        Node right=node;
        foldListHelper(left,right);
        return node;
        
    }
    public Node foldListHelper(Node left,Node right)
    {
        if(right==null)
        return left;
        
        left=foldListHelper(left,right.next);
        if(left!=null )
    	{
	    	if(left==right|| left.next==right)
	    	{
	    		right.next=null;
	    		return null;
	    	}
	    	else
	    	{
	    		Node temp=left.next;
	    		left.next=right;
	            right.next=temp;
	            left=left.next.next;
	            return left;
	    	}
        }else
        {
        	return null;
        }
     
        
    }
    
    /*
            Iterative Approach
    */
    public void foldLinkedList(Node node)
    {
        Node middle=getMiddleNode(node);
        Node middleNext=middle.next;
        Node reverseHalf=reverseList(middleNext);
        middle.next=null;
        mergeList(node,reverseHalf);
        
    }
    
    public Node getMiddleNode(Node node)
    {
        Node fast=node;
        Node slow=node;
        
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    
    public void mergeList(Node left, Node right)
    {
        while(left!=null && right!=null)
        {
            Node temp=left.next;
            Node rn=right.next;
            left.next=right;
            right.next=temp;
            left=left.next.next;
            right=rn;
        }
        if(left==null)
        {
            left.next=right;
        }
    }
    
    public Node reverseList(Node node)
    {
        Node prev=null;
        Node curr=node;
        Node nextN=null;
        
        while(curr!=null)
        {
            nextN=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextN;
        }
        return prev;
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
		//list.addLast(5);
		System.out.println( "Original LinkedList");
		list.display();
		System.out.println();
		/*
		  Folded Linked List Iterative and Recursive 
		*/
		/*list.foldList(list.head);
		System.out.println();
		System.out.println( "LinkedList after folding");
		list.display();*/
		
		list.foldLinkedList(list.head);
		list.display();
	//	list.reverseListRecursive(null,list.head);
	//	System.out.println( "LinkedList after Reverse Recursive");
	//	list.display();
	}
	
	
}
