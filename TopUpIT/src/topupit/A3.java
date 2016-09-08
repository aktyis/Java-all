package topupit;
/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016
*/

public class A3 
{
     public static void main(String[] args) 
    {
        int firstNum, secoundNum;
        int []arr = {5,9,36,24,17};
        firstNum = Integer.parseInt(args[0]);
        secoundNum = Integer.parseInt(args[1]);
        int found = 0;
        
        for (int i = 0; i < arr.length; i++) 
        {
            if(arr[i] == firstNum )
            {
               
                for (int j = 0; j < arr.length; j++) 
		{
                    if(arr[j] == secoundNum)
                    {
			    found = 1;
                         System.out.println("Its Bingo! ");
			    break;
                    }
			found = 0;			    
                   
                } 
		
	   }		
	}
	
	if(found ==0)
		System.out.println("Not FOund ");
        
    }
    
}
