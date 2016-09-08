package topupit;

import java.util.Scanner;

/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016 
*/
public class A8
{
    public static void main(String[] args) 
    {
        System.out.println("Input Number (one-ten):");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine() ;
        str = str.toLowerCase();
        switch(str)
        {
            case "one" :
            {
                System.out.println("1");
                break;
            }
            case "two" :
            {
                System.out.println("2");
                break;
            }
            case "three" :
            {
                System.out.println("3");
                break;
            }
            case "four" :
            {
                System.out.println("4");
                break;
            }
            case "five" :
            {
                System.out.println("5");
                break;
            }
            case "six" :
            {
                System.out.println("6");
                break;
            }
            case "seen" :
            {
                System.out.println("7");
                break;
            }
            case "eight" :
            {
                System.out.println("8");
                break;
            }
            case "ninne" :
            {
                System.out.println("9");
                break;
            }
            case "ten" :
            {
                System.out.println("10");
                break;
            }
            default:
            {
                System.out.println("Invalid Input");
                break;
            }
           
        }
       
       
    }
    
}
