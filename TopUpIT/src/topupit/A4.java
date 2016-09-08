package topupit;

/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016
*/


public class A4 
{
     public static void main(String[] args) 
    {
        int sum = 0, smallest=99;
        double avg = 0.0;
        int []arr = {3,2,4,5,6,4,5,7,3,2,3,4,7,1,2,0,0,0};
        
        for (int i = 0; i < 15; i++) 
        {
            sum += arr[i];
            if(arr[i] < smallest)
            {
                smallest = arr[i];
            }
        }
        
        
        avg = (sum+sum)/15.00 ;
        
        arr[15] = sum;
        arr[16] = (int)avg;
        arr[17] = smallest;
        for (int i = 0; i < arr.length; i++) 
        {
            System.out.println(arr[i]);
            
        }
        
        
    }
    
}
