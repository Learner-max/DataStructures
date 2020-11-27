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
       Merge Two Sorted Linked List- Iterartive Approach
    */
    public Node merge2SoretedListIterative(Node list1,Node list2)
    {
        if(list1==null)
        return list2;
        if(list2==null)
        return list1;
        Node mergeList=null;
        Node temp=null;
        
        if(list1.data<list2.data)
        {
            mergeList=list1;
            list1=list1.next;
        }else
        {
            mergeList=list2;
            list2=list2.next;
        }
        
        temp=mergeList;
        
        while(list1!=null && list2!=null)
        {
            if(list1.data<list2.data)
            {
                temp.next=list1;
                temp=list1;
                list1=list1.next;
            }else
            {
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
            
            
        }
        
        if(list1==null)
        temp.next=list2;
        else
        temp.next=list1;
        
        return mergeList;
    }
    /*
        Merge Two Sorted Linked List- Recursive Approach
    */
    public Node mergeListRecursive(Node list1,Node list2)
    {
        if(list1==null)
        return list2;
        if(list2==null)
        return list1;
        
        if(list1.data<list2.data)
        {
            list1.next=mergeListRecursive(list1.next,list2);
            return list1;
        }else
        {
            list2.next=mergeListRecursive(list1,list2.next);
            return list2;
        }
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
        LinkedList list1 = new LinkedList(); 
        list1.addLast(1);
       
        list1.addLast(3);
      
        list1.addLast(5);
     
        list1.addLast(7);
        
        LinkedList list2 = new LinkedList(); 
        list2.addLast(0);
        list2.addLast(2);
        list2.addLast(4);
      
        Node mergeHead=null;
       
       // mergeHead=list1.merge2SoretedListIterative(list1.head,list2.head);
        mergeHead=list1.mergeListRecursive(list1.head,list2.head);
        list1.printList(mergeHead);
      //  list.printList(list.head);
        
       
        
        
       
      
	}
}
