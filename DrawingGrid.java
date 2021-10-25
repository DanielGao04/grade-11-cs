/* DrawingGrid
 * Desc: Demonstrates how to draw grid
 * @author ICS3U
 * @version Dec 2017
 */

// These imports are required to draw
import javax.swing.*;
import java.awt.*;

class DrawingGrid{ 
    // Declare graphics panel as static class variable
    static GraphicsPanel canvas;
   
    public static void main(String[] args) {
        JFrame frame = new JFrame("This is a frame with canvas for drawing.");
        frame.setSize(800,600);
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
            
            g.setColor(Color.gray);
                g.drawLine(1,0,600);
                g.drawLine(0,800,1); 
            

            // do all your drawings here   
            
        } // paintComponent method end
    } // GraphicsPanel class end
    
} // DrawingGrid class end