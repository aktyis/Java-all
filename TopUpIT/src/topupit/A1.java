package topupit;

import java.util.Scanner;
/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016
*/
public class A1 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine() ;
        
        char []arr = str.toCharArray();
        int position = arr.length;
        int count = 0;
       
        for(int i =0; i <arr.length;i++)
        {
           
            if(arr[i] != arr[position-i-1] || i > position/2)
            {
                System.out.println("String Is not Palindrom");
                break;
            } 
            else 
            {
                count++;
                if( count == position/2)
                {
                    System.out.println("String Is Palindrom");
                    break;
                }
            }
            
        }
        
        
    }
    
}
