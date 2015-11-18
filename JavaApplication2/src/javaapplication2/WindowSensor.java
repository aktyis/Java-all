package javaapplication2;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* @author IstyakRM */
class WindowSensor extends WindowAdapter
{
        @Override
	public void windowClosing(WindowEvent we)
        {
            System.exit(0);
	}
}
