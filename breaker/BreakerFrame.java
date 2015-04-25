import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BreakerFrame extends JFrame
{
    private BreakerComponent component;
    
    public class MotionListener implements MouseMotionListener
    {
        /*
         * Updates board location based on mouse location
         * 
         * @param   mouse event
         */
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
    
    /*
     * Checks if game won or lost
     * 
     * @return  won or lost, 0 = neither, 1 = won, 2 = lost
     */
    public int getWin()
    {
        return component.getWin();
    }
}