/* KeyboardAndMouseControl
 * Desc: Demonstrates how to implement key and mouse listeners and process different events
 * @author ICS3U
 * @version Dec 2017
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyboardAndMouseControl{ 
    // Game Window properties
    static JFrame gameWindow;
    static GraphicsPanel canvas;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    // key listener
    static MyKeyListener keyListener = new MyKeyListener();    
    // mouse listeners
    static MyMouseListener mouseListener = new MyMouseListener();
    static MyMouseMotionListener mouseMotionListener = new MyMouseMotionListener(); 
    
    // box properties
    static int boxX = WIDTH/2;
    static int boxY = HEIGHT/2;
    static int boxW = 50;
    static int boxH = 50;
    static int stepX = 10;
    static int stepY = 10;
    static Color boxColor = Color.blue;
    
//------------------------------------------------------------------------------    
    public static void main(String[] args){
        gameWindow = new JFrame("Game Window");
        gameWindow.setSize(WIDTH,HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new GraphicsPanel();
        canvas.addMouseListener(mouseListener);
        canvas.addMouseMotionListener(mouseMotionListener);
        canvas.addKeyListener(keyListener);
        gameWindow.add(canvas); 
        
        gameWindow.setVisible(true);
        runGameLoop();
        
    } // main method end
    
//------------------------------------------------------------------------------   
    public static void runGameLoop(){
        while (true) {
            gameWindow.repaint();
            try  {Thread.sleep(20);} catch(Exception e){}

        }
    } // runGameLoop method end
    
//------------------------------------------------------------------------------  
    static class GraphicsPanel extends JPanel{
        public GraphicsPanel(){
            setFocusable(true);
            requestFocusInWindow();
        }
        public void paintComponent(Graphics g){ 
            super.paintComponent(g); //required
            g.setColor(boxColor);
            g.fillRect(boxX,boxY,boxW,boxH);
            // do all your drawings here 
            
        } // paintComponent method
    } // GraphicsPanel class end
    
//------------------------------------------------------------------------------     
    static class MyKeyListener implements KeyListener{   
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT){
                boxX = boxX - stepX;
            } else if (key == KeyEvent.VK_RIGHT){
                boxX = boxX + stepX;
            } else if (key == KeyEvent.VK_UP){
                boxY = boxY - stepY;
            } else if (key == KeyEvent.VK_DOWN){
                boxY = boxY + stepY;
            }            
        }
        public void keyReleased(KeyEvent e){ 
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ESCAPE){
                gameWindow.dispose();
            }
        }   
        public void keyTyped(KeyEvent e){
            char keyChar = e.getKeyChar();
            if (keyChar == 'a'){
                boxX = boxX - stepX;
            } else if (keyChar == 'd'){
                boxX = boxX + stepX;
            } else if (keyChar == 'w'){
                boxY = boxY - stepY;
            } else if (keyChar == 's'){
                boxY = boxY + stepY;
            }             
        }           
    } // MyKeyListener class end
    
//------------------------------------------------------------------------------ 
    static class MyMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent e){
            int mouseX = e.getX();
            int mouseY = e.getY();
            boxX = mouseX - boxW/2;
            boxY = mouseY - boxH/2; 
        }
        public void mousePressed(MouseEvent e){   // changes box color and places the box at the mouse location
            int mouseX = e.getX();
            int mouseY = e.getY();
            if (mouseX>boxX && mouseX<boxX+boxW && mouseY>boxY && mouseY<boxY+boxH){
                boxColor = Color.red;
                boxX = mouseX - boxW/2;
                boxY = mouseY - boxH/2;
            }
        }
        public void mouseReleased(MouseEvent e){  // restores box color
            boxColor = Color.blue;
        }
        public void mouseEntered(MouseEvent e){
            System.out.println("Mouse entered at X:"+e.getX() + " Y:"+e.getY());
        }
        public void mouseExited(MouseEvent e){
            System.out.println("Mouse exited at X:"+e.getX() + " Y:"+e.getY());
        }
    } // MyMouseListener class end
    
//------------------------------------------------------------------------------     
    static class MyMouseMotionListener implements MouseMotionListener{
        public void mouseMoved(MouseEvent e){
            System.out.println("Mouse moved to X:"+e.getX() + " Y:"+e.getY());
        }
        public void mouseDragged(MouseEvent e){   // drags the box with the mouse
            int mouseX = e.getX();
            int mouseY = e.getY();
            boxX = mouseX - boxW/2;
            boxY = mouseY - boxH/2;            
        }         
    } // MyMouseMotionListener class end
    
} // KeyboardAndMouseControl class end