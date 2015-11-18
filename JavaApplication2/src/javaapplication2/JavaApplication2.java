package javaapplication2;

/* @author IstyakRM */
public class JavaApplication2 
{
    public static void main(String[] args) 
    {   PublicKeyExchange test= new PublicKeyExchange();
        MyWindow mw ;
        mw = new MyWindow(test);
        mw.setVisible(true);  
    }
}

