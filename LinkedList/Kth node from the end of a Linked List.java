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
            Kth Node from end of Linked List
            
            Iterative - In a Single Pass
    */
    
    public int kthNodeFromEndIterative(Node node,int k)
    {
        //Use 2 pointers
        
        //Corner or Edge cases
        if(k<=0 || node==null)
        return -1;
        Node p=node;
        Node q=node;
       
        //set q pointer to point to Kth Node from begning
        while(k>0)
        {
            if(q==null)
            {
                return -1;
            }
            q=q.next;
            k--;
        }
        
        while(q!=null)
        {
            p=p.next;
            q=q.next;
        }
        
        return p.data;
    }
    
    /*
          Kth Node from end of Linked List
            
          Recursive
    */
    
    public int  kthNodeFromEndRecursive(Node node, int k)
    {
        if(node==null)
        return 0;
        if(k<=0)
        return -1;
        
        int i=kthNodeFromEndRecursive(node.next,k)+1;
        
        if(i==k)
        {
            System.out.println(node.data);
        }
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
		
		System.out.println(list.kthNodeFromEndIterative(list.head, 3));
		
	    list.kthNodeFromEndRecursive(list.head,3);
	}
	
	
}
