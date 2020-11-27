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
       Merge Sort Linked List
    */
    
    public Node mergeSort(Node head)
    {
        if(head==null || head.next==null)
        return head;
        
        Node middleNode=getMiddleNode(head);
        
        Node middleNodeNext=middleNode.next;
        middleNode.next=null;
        Node left=mergeSort(head);
        Node right=mergeSort(middleNodeNext);
        
        Node mergeSortedList=sortedMerge(left, right);
        return mergeSortedList;
    }
    
    
    //Get Middle Node of Linked List
    public Node getMiddleNode(Node head)
    {
        Node fast=head;
        Node slow=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        return slow;
    }
    
    //Sorted MergeList
    
    public Node sortedMerge(Node left, Node right)
    {
        if(left==null)
        return right;
        if(right==null)
        return left;
        
        if(left.data<right.data)
        {
            left.next=sortedMerge(left.next,right);
            return left;
        }else
        {
            right.next=sortedMerge(left,right.next);
            return right;
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
        LinkedList list = new LinkedList(); 
        list.addLast(15); 
        list.addLast(10); 
        list.addLast(5); 
        list.addLast(20); 
        list.addLast(3); 
        list.addLast(2);
      
        Node mergeHead=null;
       
       // mergeHead=list1.merge2SoretedListIterative(list1.head,list2.head);
        mergeHead=list.mergeSort(list.head);
        list.printList(mergeHead);
      //  list.printList(list.head);
        
       
        
        
       
      
	}
}
