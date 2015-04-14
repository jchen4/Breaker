import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BreakerFrame extends JFrame
{
    private BreakerComponent component;
    
    public class MotionListener implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent event)
        {
            int x = event.getX();
            int y = event.getY();
            //updates board x value to mouse's x value
            board.updateLocation(x);
        }
        
        public void mouseDragged(MouseEvent event){}
    }
    
    public BreakerFrame()
    {
        component = new BreakerComponent();
        this.setSize(1680, 1050);
        this.add(component);
        MouseMotionListener listener = new MotionListener();
        MouseMotionListener listener2 = new MotionListener();
        board.addMouseMotionListener(listener);
    }

}
