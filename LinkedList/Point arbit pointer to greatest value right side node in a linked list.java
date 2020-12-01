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
    
    /*
    Point arbit pointer to greatest value right side node in a linked list
    */
    public Node pointToGreatestNode(Node head)
    {
        //1.Reverse Linked List
        Node temp=reverseList(head);
        
        //2.Traverse the LL and maintain max node seen so far
        Node max=temp;
        Node curr=temp.next;
        
        while(curr!=null)
        {
            curr.random=max;
            if(curr.data>max.data)
            {
                max=curr;
            }
            curr=curr.next;
            
        }
        
        return reverseList(temp);
    }
    
    //Reverse Linked List
    public Node reverseList(Node head)
    {
        Node curr=head;
        Node prev=null;
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

    //By Recursion 
    public void pointRandomToGreatestNode(Node head)
    {
        if(head==null)
        return ;
       
        
        Node max=pointRandomToGreatestNode(head.next);
        head.random=max;
        if( max==null ||max.data<head.data)
        max=head;
        
        return max;
    }
    public void printList(Node node)
    {
        while(node!=null)
        {
            System.out.print(node.data+" "+(node.random!=null?node.random.data:"null"));
            System.out.println();
            node=node.next;
        }
    }
    
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		
    LinkedList list=new LinkedList();
    list.addLast(5);
    list.addLast(3);
    list.addLast(10);
    list.addLast(1);
    //Node headN=list.add1ToList(list.head);
    //Node headN=list.addOne(list.head);
    //Node headN=list.pointToGreatestNode(list.head);
    list.pointRandomToGreatestNode(list.head);
    list.printList(list.head);
        
       
        
        
       
      
	}
}
