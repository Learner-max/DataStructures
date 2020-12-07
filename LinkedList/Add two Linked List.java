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
            Iterative Approach
    */
    public Node addTwoNumbersCase1(Node l1, Node l2) {
        
        Node res=null;
        int sum=0;
        int carry=0;
        Node temp=null;
        Node prev=null;
        while(l1!=null || l2!=null)
        {
            sum=(l1!=null?l1.data:0)+
                (l2!=null?l2.data:0)+carry;
            carry=sum>=10?1:0;
            
            temp=new Node(sum%10);
            if(res==null)
                res=temp;
            else
            {
                prev.next=temp;
            }
            prev=temp;
            
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
        if(carry==1)
        {
            temp=new Node(1);
            prev.next=temp;
        }
        
        return res;
    }
    
    /*
        Iterative Approach -Case -2
    */
     public Node addTwoNumbersCase2(Node l1, Node l2) {
        
        Stack<Integer> s1=new Stack<>();
        
        Stack<Integer> s2=new Stack<>();
        Node t1=l1;
        Node t2=l2;
        int sum=0;
        int carry=0;
        Node temp=null;
        Node res=null;
        Node prev=null;
        while(t1!=null)
        {
            s1.push(t1.data);
            t1=t1.next;
        }
        while(t2!=null)
        {
            s2.push(t2.data);
             t2=t2.next;
        }
        
        while(s1.isEmpty()==false || s2.isEmpty()==false)
        {
            sum=(s1.isEmpty()==true?0:s1.pop()) +
                (s2.isEmpty()==true?0:s2.pop())+carry;
            
            carry=sum>=10?1:0;
            
            temp=new Node(sum%10);
            
            if(res==null)
                res=temp;
            else
            {
                temp.next=res;
                res=temp;
            }
            
            
        }
        
        if(carry==1)
        {
            temp=new Node(1);
            temp.next=res;
            res=temp;
        }
        
        return res;
        
        
    }
    
    /*
         In place Iterative Approach
    */
    public Node addTwoNumbersInPlace(Node l1, Node l2) {
        
        Node list1=reverseList(l1);
        Node head1=list1;
        Node list2=reverseList(l2);
        
        int sum=0;
        int carry=0;
        Node temp=null;
        while(list1!=null && list2!=null)
        {
            sum=list1.data+
               list2.data
                +carry;
            carry=(sum>=10?1:0);
            list1.data=sum%10;
            temp=list1;
            list1=list1.next;
            list2=list2.next;
            
        
        }
        
        
        if(list1==null ||list2==null)
        {
            if(list1==null)
            {
                temp.next=list2;
            }
            list1=temp.next;
            while(list1!=null)
            {
                sum= carry+list1.data;
                carry=sum/10;
                list1.data=sum%10;
                temp=list1;
                list1=list1.next;
            }
        }
        if(carry>0)
        {
            Node node=new Node(1);
            temp.next=node;
            
        }
        
        return reverseList(head1);
        
    }
    
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
    public static void printList(Node h)
	{
		//Node head=h;
		while(h!=null)
		{
			System.out.print(h.data+ " ");
			h=h.next;
		}
		System.out.println();
	}
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		LinkedList list1=new LinkedList();
		list1.addLast(7);
		list1.addLast(2);
		list1.addLast(4);
		list1.addLast(3);
		//list.addLast(5);
		LinkedList list2=new LinkedList();
		list2.addLast(5);
		list2.addLast(6);
		 list2.addLast(4);
		Node headNew=list1.addTwoNumbersInPlace(list1.head, list2.head);
		list1.printList(headNew);
	}
	
	
}
