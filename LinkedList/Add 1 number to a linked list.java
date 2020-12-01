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
    
    // Add 1 to a Linked List Iterative approach
    public Node add1ToList(Node head)
    {
        Node curr=head;
        Node res=reverseList(head);
        Node newHead=res;
        int carry=1;
        int sum=0;
        Node temp=null;
        
        while(res!=null)
        {
            sum=res.data+carry;
            carry=(sum>=10)?1:0;
            
            sum=sum%10;
            res.data=sum;
            temp=res;
            res=res.next;
        }
        if(carry>0)
        {
            temp.next=new Node(carry);
        }
        return reverseList(newHead);
    }
    
    //Reverse Linked List
    public Node reverseList(Node node)
    {
        Node curr=node;
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
    
    // Recursive  add 1 to linked list
    public int add1ToListRecursive(Node node)
    {
        if(node ==null)
        return 1;
        
        int sum=node.data+add1ToListRecursive(node.next);
       
        
        node.data=sum%10;
       
        return sum/10;
    }
    
    public Node addOne(Node node)
    {
         Node temp1=node;
        int carry=add1ToListRecursive(node);
        if(carry>=1)
        {
            Node temp=new Node(carry);
            temp.next=node;
            return temp;
            
        }
        
        return node;
        
    }
    
    /*
       Iterative Approach to Add 1 to LL without having to reverse LL
    */
    
    public Node add1WithoutListReverse(Node head)
    {
        Node curr=head;
        Node last=null;
        
        while(curr.next!=null)
        {
            if(curr.data!=9)
            {
                last=curr;
            }
            curr=curr.next;
        }
        
        if(curr.data!=9)
        {
            curr.data++;
            return head;
        }
        
        if(last==null)
        {
            last=new Node(0);
            last.next=head;
            head=last;
            
        }
        last.data++;
        last=last.next;
        while(last!=null)
        {
            last.data=0;
            last=last.next;
        }
        return head;
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
		
    LinkedList list=new LinkedList();
    list.addLast(9);
    list.addLast(9);
    list.addLast(9);
    list.addLast(9);
    //Node headN=list.add1ToList(list.head);
    //Node headN=list.addOne(list.head);
    Node headN=list.add1WithoutListReverse(list.head);
 
    list.printList(headN);
        
       
        
        
       
      
	}
}
