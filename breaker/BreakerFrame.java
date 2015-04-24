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
        this.setSize(1280, 800);
        this.add(component);
        MouseMotionListener listener = new MotionListener();
        component.addMouseMotionListener(listener);
    }
    
    public boolean getWin()
    {
        return component.getWin();
    }
}