import javax.swing.*;
import java.awt.*;

class DrawingBasicShapes{ 
    // Declare graphics panel as static class variable
    static GraphicsPanel canvas;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("This is a frame with canvas for drawing.");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new GraphicsPanel();  //this is a custom panel to draw graphics
        frame.add(canvas); 
        
        frame.setVisible(true);
        
    } // main method end
    
//------------------------------------------------------------------------------  
    /* GraphicsPanel class
     * Desc: An internal class that contains all the graphics code. It can be used as any other JPanel. 
     *       However, to draw in the panel it has to be customized - a paint method is added. 
     */
    static class GraphicsPanel extends JPanel {
        public void paintComponent(Graphics g) { 
            super.paintComponent(g); //required

            g.setColor(Color.red);
            g.fillRect(300, 300, 100, 100);
           
            
            
        } 
    } 
    
} 