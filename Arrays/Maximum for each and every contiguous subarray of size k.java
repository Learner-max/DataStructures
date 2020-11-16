/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    //static inner class Node for creating Double Linked List
    static Node head;
    static Node tail;
    static class Node
    {
        int data;
        Node left;
        Node right;
        
        Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
            
        }
    }
    
    //Add Nodes to Double Linked List
    public static void addNodeToLast(int data)
    {
        Node n=new Node(data);
        //adds node to last of Linked List
        if(head==null)
        {
            head=n;
            tail=n;
        }else
        {
            tail.right=n;
            n.left=tail;
            tail=n;
        }
    }
    
    //Add Node to First
    public static void addNodeToFirst(int data)
    {
        Node n=new Node(data);
        if(head==null)
        {
            head=n;
            tail=n;
        }else
        {
            head.left=n;
           
            n.right=head;
            head=n;
        }
    }
    //Delete Last Node
    public static int deleteLastNode()
    {
        int temp=tail.data;
        if(head==tail)
        {
            head=null;
            tail=null;
        }else
        {
            tail=tail.left;
            tail.right=null;
        }
        return temp;
    }
    
    public static int deleteFirstNode()
    {
        int temp=head.data;
        if(head==tail)
        {
            head=null;
            tail=null;
        }else
        {
            head=head.right;
            head.left=null;
        }
        return temp;
    }
    
    //Peek first
    public static int peekFirst(){
        return (head.data);
    }
    
    //Peek last
    public static int peekLast()
    {
        return (tail.data);
    }
    
    //isListEmpty
    public static int isListEmpty()
    {
        if(head==null)
        return 0;
        return 1;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		//Maximum, for each and every contiguous subarray of size 'k'
		
		/*
		Input: arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 
        Output: 3 3 4 5 5 5 6
        Explanation: 
        Maximum of 1, 2, 3 is 3
        Maximum of 2, 3, 1 is 3
        Maximum of 3, 1, 4 is 4
        Maximum of 1, 4, 5 is 5
        Maximum of 4, 5, 2 is 5 
        Maximum of 5, 2, 3 is 5
        Maximum of 2, 3, 6 is 6
        
        Input: arr[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, K = 4 
        Output: 10 10 10 15 15 90 90
        Explanation:
        Maximum of first 4 elements is 10, similarly for next 4 
        elements (i.e from index 1 to 4) is 10, So the sequence 
        generated is 10 10 10 15 15 90 90
        */
        
        int[] arr={1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k=3;
        
        slidingWindowMax(arr, k);
	}
	
	public static void slidingWindowMax(int[] arr, int k)
	{
	    addNodeToFirst(0);
	    int n=arr.length;
	    for(int i=1;i<k;i++)
	    {
	        while(!(isListEmpty()==0) && arr[i]>=arr[peekLast()])
	        {
	            deleteLastNode();
	        }
	        
	        addNodeToLast(i);
	    }
	    
	    //For rest of Windows
	    for(int i=k;i<n;i++)
	    {
	        //print maximum element of previous window
	        System.out.print(arr[peekFirst()]+" ");
	        if(peekFirst()==(i-k))
	        {
	            deleteFirstNode();
	        }
	        
	        //remove useless elements from previous window
	        while(!(isListEmpty()==0) && arr[i]>=arr[peekLast()])
	        deleteLastNode();
	        addNodeToLast(i);
	        
	        
	        
	    }
	    System.out.print(arr[peekFirst()]+" ");
	}
}
