package topupit;
/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016
*/

public class A2 
{
    public static void main(String[] args) 
    {
        int firstNum, secoundNum;
         int sum;
        firstNum = Integer.parseInt(args[0]);
        secoundNum = Integer.parseInt(args[1]);
        int backUp;
	System.out.println(firstNum +"\n"+ secoundNum);
        for(int i=0; i<13; i++)
        {
		
		backUp = secoundNum;
		sum = firstNum+secoundNum;
            
		firstNum = backUp;
		secoundNum = sum;
		System.out.println(sum);
            
        
        }
    }
    
}
