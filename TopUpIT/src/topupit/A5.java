package topupit;
/*
//@title: Assignment-1 of TopUpIT 
//@author: Istyak Rana
//@email: istyak.rana@gmail.com
//@date:07-09-2016
*/
public class A5 
{
     public static void main(String[] args) 
    {
        double investment = 14000;
        
        double firstYear = investment*0.4 ;
        investment += firstYear;
        System.out.println("After First Year Investment worth is :"+investment);
        double secoundYear = 1500 ;
        investment -= secoundYear;
        System.out.println("After Secound Year Investment worth is :"+investment);
        double thirdYear = investment*0.12 ;
        investment += thirdYear;
        System.out.println("After Third Year Investment worth is :"+investment);
    }
    
}
