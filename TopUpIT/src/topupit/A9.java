package topupit;

import java.util.Scanner;

/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016 
*/
public class A9
{
    public static void main(String[] args) 
    {
        System.out.println("Input Distance Between Dhaka to your City:");
        Scanner sc = new Scanner(System.in);
        double distanceKM = sc.nextDouble();
        
        double meter = distanceKM* 1000;
        double feet = distanceKM * 3280.8;
        double ince = feet* 12;
        double cm = meter * 100;
        
        System.out.println("Dhaka to Your City :" +meter +" Meter");
        System.out.println("Dhaka to Your City :" + feet+" Feet");
        System.out.println("Dhaka to Your City :" + ince+" Ince");
        System.out.println("Dhaka to Your City :" +cm +" CM");
       
        
       
       
       
    }
    
}
