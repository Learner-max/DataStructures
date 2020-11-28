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
    
    public Node mergekSortedList(Node[] lists)
    {
        int last=lists.length-1;
        
        while(last!=0)
        {
            int start=0;
            int end=last;
            while(start<end)
            {
                lists[start]=sortedMerge(lists[start++],lists[end--]);
                if(start>=end)
                {
                    last=end;
                }
            
            }
        }
        
        return lists[0];
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
		
	int k = 3; // Number of linked lists
    int n = 4; // Number of elements in each list
 
    // an array of pointers storing the head nodes
    // of the linked lists
    LinkedList list=new LinkedList();
    Node[] arr=new Node[3];
 
    arr[0] = new Node(1);
    arr[0].next = new Node(3);
    arr[0].next.next = new Node(5);
    arr[0].next.next.next = new Node(7);
 
    arr[1] = new Node(2);
    arr[1].next = new Node(4);
    arr[1].next.next = new Node(6);
    arr[1].next.next.next = new Node(8);
 
    arr[2] = new Node(0);
    arr[2].next = new Node(9);
    arr[2].next.next = new Node(10);
    arr[2].next.next.next = new Node(11);
 
    // Merge all lists
    Node head = list.mergekSortedList(arr);
 
    list.printList(head);
        
       
        
        
       
      
	}
}
