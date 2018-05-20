import java.util.*;
public class Solution_11 
{
	private int maxSize;
	private int[] stackArray;
	private int top;

	public Solution_11(int s) 
	{
		maxSize = s;
		stackArray = new int[maxSize];
		top = -1;
	}
	public void push(int j) 
	{
		System.out.println(j);
		stackArray[++top] = j;
	}
	public void pop() 
	{
		if (top > -1 &&  top < this.maxSize)
		{
			System.out.println(stackArray[top--]);
			if (this.isEmpty())
			{}
		}
	}
	public boolean isEmpty() 
	{
		if (top > -1)
		{
			return  true;
		}
		else 
		{
			System.out.println("EMPTY");
			return  false;
		}
	}		
	public void incElements(int k, int e) 
	{
		for (int i =0; i<k; i++)
		{
			this.stackArray[i] += e ;
		}
	}
	public void show() 
	{
		System.out.println( Arrays.toString( stackArray ) + " top = { " + top + "  }");
	}
	public static void main(String[] args) 
	{
		Solution_11 theStack = new Solution_11(10); 
		theStack.push(4);
		theStack.pop();
		theStack.push(3);
		theStack.push(5);
		theStack.push(2);
		theStack.incElements(3,1);
		theStack.pop();
		//~ theStack.show();
		theStack.push(1);
		//~ theStack.show();
		theStack.incElements(2,2);
		//~ theStack.show();
		theStack.push(4);
		//~ theStack.show();
		theStack.pop();
		theStack.pop();
		//~ theStack.show();
		}
}
