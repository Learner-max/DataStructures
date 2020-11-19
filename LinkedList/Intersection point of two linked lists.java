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
      Intersection point of two linked list 2 pointer approach
    */
    
     public Node getIntersectionNode(Node headA,Node headB) {
        
        int lenA=countNodes(headA);
        
        int lenB=countNodes(headB);
        
        int diff=Math.abs(lenA-lenB);
       
        Node intersectNode=lenA>lenB?_getIntersectionNode(diff,headA,headB):_getIntersectionNode(diff,headB,headA);
        
       
        return intersectNode;
    }
    
    public int countNodes(Node node)
    {
        Node n=node;
        int size=0;
        
        while(n!=null)
        {
            size++;
            n=n.next;
        }
        
        return size;
    }
    
    public Node _getIntersectionNode(int diff,Node headA,Node headB)
    {
        Node nodeA=headA;
        for(int i=0;i<diff;i++)
        {
            nodeA=nodeA.next;
        }
       
        Node nodeB=headB;
        while(nodeA!=null && nodeB!=null)
        {
           
            if(nodeA==nodeB)
                return nodeA;
            
            nodeA=nodeA.next;
            nodeB=nodeB.next;
        }
        return null;
    }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		
		LinkedList list=new LinkedList();
		Node newNode; 
  
        // Addition of new nodes 
        Node head1 = new Node(10); 
      
      
        Node head2 = new Node(3); 
      
      
        newNode = new Node(6); 
      
        head2.next = newNode; 
      
        newNode = new Node(9); 
       
        head2.next.next = newNode; 
      
        newNode = new Node(15); 
     
        head1.next = newNode; 
        head2.next.next.next = newNode; 
      
        newNode = new Node(30); 
    
        head1.next.next = newNode; 
      
        head1.next.next.next = null; 
		
		
		System.out.println(list.getIntersectionNode(head1,head2).data);
	
	   
	}
	
	
}
