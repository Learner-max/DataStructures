/* package codechef; // don't place package name! */

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
       Node random;
       
       
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
        if(this.head==null)
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
    
    // Alternative Split of a Linked List Iterative approach
    public Node splitLinkedListIterative(Node head)
    {
        if (head==null )
         return null;
        Node headA=head;
        Node headB=head.next;
        Node temp=headB;
        
        while(headA!=null && headB!=null)
        {
            headA.next=headB.next;
            headB.next=(headB.next!=null)?headB.next.next:null;
            headA=headA.next;
            headB=headB.next;
        }
        
        return temp;
        
    }
    
    public Node alternateSplitLinkedList(Node head)
    {
        if(head==null)
        return null;
        Node headA=head;
        Node headB=head.next;
        
        splitLinkedList(headA,headB);
        return headB;
    }
    
    public void splitLinkedList(Node headA,Node headB)
    {
        if(headA==null || headB==null)
        return ;
        
        if(headA.next!=null)
        headA.next=headA.next.next;
        
        if(headB.next!=null)
        headB.next=headB.next.next;
        
        splitLinkedList(headA.next,headB.next);
        
    }
    public void printList(Node node)
    {
        while(node!=null)
        {
            System.out.print(node.data+" ");
            node=node.next;
        }
    }
    
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		
		// Pushing data in the linked list. 
        LinkedList list = new LinkedList(); 
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        
      
        Node headB=null;
        //headB=list.splitLinkedList(list.head);
        headB=list.alternateSplitLinkedList(list.head);
        list.printList(list.head);
        System.out.println();
        list.printList(headB);
        
       
        
        
       
      
	}
}
