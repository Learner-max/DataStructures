/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Stack<Integer> stack=new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println(stack);
		reverseStack(stack);
		System.out.println(stack);
	}
	
	public static void reverseStack(Stack<Integer> stack)
	{
	  if(stack.isEmpty())
	  {
	      return ;
	  }
	  
	  int item=stack.pop();
	  
	  reverseStack(stack);
	  
	  insertAtBottom(stack, item);
	    
	}
	
	public static void insertAtBottom(Stack<Integer> stack,int item)
	{
	    if(stack.isEmpty())
	    {
	        stack.push(item);
	        return;
	    }
	    else
	    {
	        int topItem=stack.pop();
	        insertAtBottom(stack, item);
	        stack.push(topItem);
	        
	    }
	}
}
