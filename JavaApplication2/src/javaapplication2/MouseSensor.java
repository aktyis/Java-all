package javaapplication2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*@author IstyakRM*/
class MouseSensor extends MouseAdapter
{
    MyWindow mW;
    public static int check =0;
    public MouseSensor(MyWindow mW)
    {
        this.mW = mW;
    }
    
    @Override
    public void mousePressed(MouseEvent me)
    {
        if (check ==0){
            check++;
        int x = me.getX();
        int y = me.getY();
        System.out.println("Mouse Pressed at : "+me.getX()+" - "+ me.getY());
        if( (  x > 0 && x < 500  &&  y > 0 && y < 30 ) )
             mW.showTextField(" ");
        }
            
    }
}
