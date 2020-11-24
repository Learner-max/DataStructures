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
    
    public Node reverseAlternateGroups(Node node,int k)
    {
        
        Node curr=node;
        Node prev=null;
        Node nextN=null;
        Node tail=null;
        Node finalHead=null;
        int count=k;
        Node join=null;
        while(curr!=null)
        {
            join=curr;
            prev=null;
            count=k;
            while(count>0&& curr!=null)
            {
                nextN=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextN;
                count--;
            }
            
            if(finalHead==null)
            finalHead=prev;
            
            if(tail!=null)
            tail.next=prev;
            
            tail=join;
            
            tail.next=curr;
            count=k;
            while(count>0&& curr!=null)
            {
                prev=curr;
                curr=curr.next;
                count--;
            }
            tail=prev;
            
        }
    
        return finalHead;
    }
    
    
    // Recursive Approach for Reverse Linked list in alternate groups of k
    
    public Node reverseAlternateGroupsRecursive(Node node, int k)
    {
        Node curr=node;
        Node prev=null;
        Node nextN=null;
        Node p1=null;
        int count=k;
        
        while(count>0 && curr!=null)
        {
            nextN=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextN;
            count--;
        }
        
        if(node!=null)
        node.next=curr;
        
        count=k;
       
        while(count>0 && curr!=null)
        {
        	p1=curr;
            curr=curr.next;
            count--;
        }
        if(curr!=null)
        p1.next=reverseAlternateGroupsRecursive(curr,k);
        
        return prev;
    }
    
    public Node kthReverseAlternateRecursive(Node node,int k,boolean flag)
    {
        if(node==null)
        return null;
        Node curr=node;
        Node prev=null;
        Node nextN=null;
        int count=k;
        while(curr!=null && count>0)
        {
            nextN=curr.next;
            if(flag==true)
            {
                curr.next=prev;
            }
            prev=curr;
            curr=nextN;
            count--;
        }
        
        if(flag==true)
        {
            node.next=kthReverseAlternateRecursive(curr,k,!flag);
            return prev;
        }else
        {
            prev.next=kthReverseAlternateRecursive(curr,k,!flag);
            return node;
        }
    }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		
		LinkedList list=new LinkedList();
	   
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4); 
        list.addLast(5); 
        list.addLast(6); 
        list.addLast(7); 
        list.addLast(8); 
        list.addLast(9); 
      //  list.addLast(10); 
       
        int k=3;
        //list.head=list.reverseAlternateGroups(list.head,3);
        list.head=list.reverseAlternateGroupsRecursive(list.head,3);
        list.display();
        System.out.println();
        list.head=list.kthReverseAlternateRecursive(list.head,3,true);
        list.display();
	
	   
	}
}
