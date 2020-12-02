/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    static class Node
    {
        int data=0;
        
        int next=0;
        
        Node(int data)
        {
            this.data=data;
            
        }
    }
    
    static class LinkedList
    {
        Node head;
        Node tail;
        Map<Integer,Node> map=new HashMap<>();
      
        public void insert(int data)
        {
            Node node=new Node(data);
           
            Node currNode=head;
            int prev=0;
            
            if(head==null)
            {
                head=node;
                map.put(node.hashCode(),node);
                return;
            }
            
            while(currNode.next!=0)
            {
                int current=currNode.hashCode();
                currNode=map.get(prev^ currNode.next);
                prev=current;
            }
            currNode.next=prev^node.hashCode();
            map.put(node.hashCode(),node);
            //System.out.println(map);
            
            
        }
        
        public void printList(Node head)
        {
            int next=head.hashCode();
            int previous=0;
            while(next!=0)
            {
                System.out.print(map.get(next).data+" ");
                if(map.get(next).next==0)
                break;
                int pre=map.get(next).hashCode();
                next=map.get(next).next^previous;
               // System.out.println(next);
                previous=pre;
                
            }
        }
        
    }
        
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		LinkedList list=new LinkedList();
		list.insert(10);
		list.insert(20);
		list.insert(30);
		list.insert(40);
		
		list.printList(list.head);
		
	}
}
