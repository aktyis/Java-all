package javaapplication2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*@author IstyakRM*/
class MouseSensor2 extends MouseAdapter
{
    MyWindow mW;
    public MouseSensor2(MyWindow mW)
    {
        this.mW = mW;
    }
    
    @Override
    public void mousePressed(MouseEvent me)
    {
        if (mW.bchecker == 0){
            mW.bchecker++;
        int x = me.getX();
        int y = me.getY();
        System.out.println("Mouse Pressed at : "+me.getX()+" - "+ me.getY());
        if( (  x > 0 && x < 1150  &&  y > 0 && y < 180 ) )
             mW.showMessage("   This Area Is Not For Typing        ");
        }
            
    }
}
