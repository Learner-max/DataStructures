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
    
   // Clonning a Linked List with random and next pointer
   
   public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        
        Node curr=head;
        Node temp=null;
        Node node=null;
        Node result=null;
        //1.Create new nodes and insert them in-between the given LL nodes.
        while(curr!=null)
        {
            temp=new Node(curr.data);
            temp.next=curr.next;
            //node=curr.next;
            curr.next=temp;
            curr=temp.next;
            
        }
        
        //2.reintailize new head
        result=head.next;
        //3.Assigning random pointer to newly created nodes
        curr=head;
        while(curr!=null && curr.next!=null)
        {
            if(curr.random!=null)
            curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        //4.Seperating the two LL
        curr=head;
        temp=head.next;
        while(curr!=null && temp!=null )
        {
            curr.next=temp.next;
            if(temp.next!=null)
            temp.next=temp.next.next;
            curr=curr.next;
            temp=temp.next;
        }
        
        return result;
        
    }
    
    public void printList(Node node)
    {
      Node ptr=node;
      while(ptr!=null)
      {
          System.out.println("Data "+ptr.data+" "+"Random "+(ptr.random!=null?ptr.random.data:-1));
          ptr=ptr.next;
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
  
        // Setting up random references. 
        list.head.random = list.head.next.next; 
        list.head.next.random = 
            list.head.next.next.next; 
        list.head.next.next.random = 
            list.head.next.next.next.next; 
        list.head.next.next.next.random = 
            list.head.next.next.next.next.next; 
        list.head.next.next.next.next.random = 
            list.head.next; 
      
       
        LinkedList clone=new LinkedList();
      
        clone.head=clone.copyRandomList(list.head);
        System.out.println("Cloned List");
        clone.display();
        System.out.println();
        clone.printList(clone.head);
        System.out.println();
        System.out.println("original List");
        
        list.display();
        System.out.println();
        list.printList(list.head);
      
	}
}
