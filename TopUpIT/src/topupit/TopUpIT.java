package topupit;

    /*
    //@title: ToUPIT Class Works
    //@author: Istyak Rana
    //@email: istyak.rana@gmail.com
    //@date:04-09-2016 
    */

public class TopUpIT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Emp e = new Emp();
        e.setAge(21);
        e.setName("Rana");
        e.setPin(1234);
        
        System.out.println("Name :" + e.getName() +"\n" + "Age "+ e.getAge()+ "\n"+ "PIN "+ e.getPin() );
        
    }
    
    

    
    
    
    
    
    
}
