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
            component.updateBoardLocation(x);
        }
        
        public void mouseDragged(MouseEvent event){}
    }
    
    public BreakerFrame()
    {
        component = new BreakerComponent();
        this.setSize(1680, 1050);
        this.add(component);
        MouseMotionListener listener = new MotionListener();
        component.addMouseMotionListener(listener);
    }
    
    public boolean checkBoardCollision()
    {
        return component.checkBoardCollision();
    }
    
}
