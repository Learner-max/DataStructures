/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    
    static class Stack{
        int[] arr;
        int size;
        int top;
        
        Stack(int size){
            
            this.size=size;
            this.arr=new int[this.size];
            this.top=-1;
        }
        
        public void push(int data)
        {
            if(this.size-this.top>1)
            {
                this.top++;
                this.arr[this.top]=data;
            }else{
                System.out.println("StackOverFlow Exception");
                return;
            }
        }
        
        public void pop()
        {
            if(this.top>0)
            {
                int val=this.arr[this.top];
                this.top--;
                System.out.println(val);
            }else{
                System.out.println("StackUnderFlow Exception");
                return;
            }
        }
        
        public void peek()
        {
            if(this.top>0 )
            {
                int val=this.arr[this.top];
                System.out.println(val);
                
            }else{
                System.out.println("StackUnderFlow Exception");
                return;
            }
        }
        
        public boolean isEmpty(){
            if(this.top==-1)
            {
                return true;
            }else
            {
                return false;
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Stack s=new Stack(5);
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		
	//	s.pop();
		s.peek();
		
		System.out.println(s.isEmpty());
	}
}
