/**
 * Tankpvp
 * Starts a local two player tank game 
 * @author Kavin Arasu
 * @author Daniel Gao
 * @date January 25 2020
 */

//Graphics &GUI imports
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

//image imports
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

//Keyboard imports
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//music imports
import javax.sound.sampled.*;

//Mouse imports
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.SwingUtilities;

class TankPvp{
  static int gameRestart = 0;
  
// static variables
  static JFrame gameWindow;
  static GraphicsPanel canvas;
  static final int WIDTH = 1500;
  static final int HEIGHT = 900;
  static int counter = 0;
  static int count = 0;
  static int tankOneX = 50;
  static int tankOneY = 750;
  static int tankTwoX = 1350;
  static int tankTwoY = 50;
  static Rectangle tankbox1 = new Rectangle(tankOneX, tankOneY, 80, 80);
  static Rectangle tankbox2 = new Rectangle(tankTwoX, tankTwoY, 80, 80);
  static Rectangle r1 = new Rectangle(100, 0, 10, 100);
  static Rectangle r2 = new Rectangle(100, 100, 100, 10);
  static Rectangle r3 = new Rectangle(730, 400, 10, 200);
  static Rectangle r4 = new Rectangle(730, 400, 200, 10);
  static Rectangle r5 = new Rectangle(1100, 0, 10, 400);
  static Rectangle r6 = new Rectangle(200, 600, 10, 500);
  static Rectangle r7 = new Rectangle(540, 400, 10, 500);
  static Rectangle r8 = new Rectangle(0, 400, 300, 10);
  static Rectangle r9 = new Rectangle(730, 600, 400, 10);
  
  static Rectangle b1 = new Rectangle(0,0, 1500, 10);
  static Rectangle b2 = new Rectangle(0,0,10,900);
  static Rectangle b3 = new Rectangle(0,851, 1500, 10);
  static Rectangle b4 = new Rectangle(1475, 0, 10, 900);
  
  static Rectangle middle = new Rectangle(750, 0, 10, 900);
  
  static int collision = 0; 
  static int collisionOne = 0;
  static int sandMovement = 10;
  static int sandMovementOne = 10;
  static int tankShot = 0;
  static int tankOneScore = 0;
  static int tankTwoScore = 0;
  static int gameOver = 0;
  
  
  static BufferedImage battlefield;
  static int battlefieldX = 0;
  static int battlefieldY = 0;
  static int battlefieldW = 1500;
  static int battlefieldH = 900;
  
  static BufferedImage sand;
  static int sandX = 0;
  static int sandY = 0;
  static int sandW = 1500;
  static int sandH = 900;
  
  //bullet 1
  static int numBullets = 40;    
  static int[] bulletX = new int[numBullets];
  static int[] bulletY = new int[numBullets];
  static boolean[] bulletVisible = new boolean[numBullets];
  static int bulletW = 6;
  static int bulletH = 10;
  static int bulletSpeed = 10;
  static int currentBullet = 0;
  
  //bullet 2
  static int numBullets2 = 40;    
  static int[] bulletX2 = new int[numBullets2];
  static int[] bulletY2 = new int[numBullets2];
  static boolean[] bulletVisible2 = new boolean[numBullets2];
  static int bulletW2 = 6;
  static int bulletH2 = 10;
  static int bulletSpeed2 = -10;
  static int currentBullet2 = 0;
  
  
  //bullet collision hitboxes
  static Rectangle[] bulletHitBox2 = new Rectangle[numBullets2];
  static Rectangle[] bulletHitBox = new Rectangle[numBullets];
  
  //music 
  static AudioInputStream audioStream;
  static Clip music;
  
  // mouse listeners
  static MyMouseListener mouseListener = new MyMouseListener();
  static MyMouseMotionListener mouseMotionListener = new MyMouseMotionListener(); 
  
  //key listener
  static MyKeyListener keyListener = new MyKeyListener(); 
  
  static int moveTank1X = 0;
  static int moveTank1Y = 0;
  
  static int moveTank2X = 0;
  static int moveTank2Y = 0;
  
  static int stepTank1 = 5;
  static int stepTank2 = 5;
  
  
//------------------------------------------------------------------------------    
  public static void main(String[] args){
    
    gameWindow = new JFrame("Tank PVP");
    gameWindow.setSize(WIDTH,HEIGHT);
    gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    canvas = new GraphicsPanel();
    canvas.addMouseListener(mouseListener);
    canvas.addMouseMotionListener(mouseMotionListener);
    gameWindow.add(canvas); 
    canvas.addKeyListener(keyListener);
    gameWindow.add(canvas); 
    
    //images
    try {                
      battlefield = ImageIO.read(new File("battlefield.png"));
      sand = ImageIO.read(new File("sand.png"));
    } catch (IOException ex){}    
    
    //music
    try {
      File audioFile = new File("war.wav");
      audioStream = AudioSystem.getAudioInputStream(audioFile);
      music = AudioSystem.getClip();
      music.open(audioStream);
    } catch (Exception ex){} 
    
    FloatControl volumeMusic = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN); 
    volumeMusic.setValue(-15.0f);
    
    music.start();
    music.loop(Clip.LOOP_CONTINUOUSLY);
    
    // generate bullets
    Arrays.fill(bulletX,0);
    Arrays.fill(bulletY,0);
    Arrays.fill(bulletVisible,false);
    
    Arrays.fill(bulletX2,0);
    Arrays.fill(bulletY2,0);
    Arrays.fill(bulletVisible2,false);
    
    gameWindow.setVisible(true);
    runGameLoop();
    
  } // main method end
  
//------------------------------------------------------------------------------   
  public static void runGameLoop(){
    while (true) {
      gameWindow.repaint();
      try  {Thread.sleep(20);} catch(Exception e){}
      
      //middle wall collision
      
      if(middle.intersects(tankbox1)){
        tankOneX = 50;
        tankOneY = 750;
      }
      
      if(middle.intersects(tankbox2)){
        tankTwoX = 1350;
        tankTwoY = 50;
      }
      
      //border for tank 1
      if(b1.intersects(tankbox1)){
        tankOneY = tankOneY + 7 ;
      }
      if(b2.intersects(tankbox1)){
        tankOneX = tankOneX + 7 ;
      }
      if(b3.intersects(tankbox1)){
        tankOneY = tankOneY - 7 ;
      }
      if(b4.intersects(tankbox1)){
        tankOneX = tankOneX - 7 ;
      }
      
      //border for tank 2
      
      if(b1.intersects(tankbox2)){
        tankTwoY = tankTwoY + 7 ;
      }
      if(b2.intersects(tankbox2)){
        tankTwoX = tankTwoX + 7 ;
      }
      if(b3.intersects(tankbox2)){
        tankTwoY = tankTwoY - 7 ;
      }
      if(b4.intersects(tankbox2)){
        tankTwoX = tankTwoX - 7 ;
      }
      
      // move the bullets
      for (int i=0; i<numBullets; i++){
        if (bulletVisible[i]){
          bulletX[i] = bulletX[i] + bulletSpeed;
          if (bulletX[i]<0)
            bulletVisible[i] = false;
          
          //for collision
          bulletX[i] = bulletX[i] + bulletSpeed;
          bulletHitBox[i] = new Rectangle(bulletX[i], bulletY[i], bulletH, bulletW);
          
          if (bulletHitBox[i].intersects(tankbox2)) {
            bulletVisible[i] = false;
            while(tankShot == 0){
              if (tankTwoScore == 0){
                tankTwoScore = 1;
                tankShot = 1;
              }
              else if (tankTwoScore == 1){
                tankTwoScore = 2;
                tankShot = 1;
              }
              else if (tankTwoScore == 2){
                tankTwoScore = 3;
                tankShot = 1;
              }
              else if (tankTwoScore == 3){
                tankTwoScore = 4;
                tankShot = 1;
              }
              else if (tankTwoScore == 4){
                tankTwoScore = 5;
                tankShot = 1;
              }
            }
          }
        }
      }
      
      //move bullets for tank 2
      for (int i=0; i<numBullets2; i++){
        if (bulletVisible2[i]){
          bulletX2[i] = bulletX2[i] + bulletSpeed2;
          if (bulletX2[i]<0)
            bulletVisible2[i] = false;
          
          //for collision
          bulletX2[i] = bulletX2[i] + bulletSpeed2;
          bulletHitBox2[i] = new Rectangle(bulletX2[i], bulletY2[i], bulletH2, bulletW2);
          
          if (bulletHitBox2[i].intersects(tankbox1)) {
            bulletVisible2[i] = false;
            while(tankShot == 0){
              if (tankOneScore == 0){
                tankOneScore = 1;
                tankShot = 1;
              }
              else if (tankOneScore == 1){
                tankOneScore = 2;
                tankShot = 1;
              }
              else if (tankOneScore == 2){
                tankOneScore = 3;
                tankShot = 1;
              }
              else if (tankOneScore == 3){
                tankOneScore = 4;
                tankShot = 1;
              }
              else if (tankOneScore == 4){
                tankOneScore = 5;
                tankShot = 1;
              }
            }
            
            
            
          }
        }
      }
      
    
      
      tankMovement();
      
    }
    
  } // runGameLoop method end
  
  public static void tankMovement(){
      if (checkCollisionWall(tankbox1)){
        stepTank1 = 1;
      } else {
        stepTank1 = 7;
      }
      
      if (checkCollisionWall(tankbox2)){
        stepTank2 = 1;
      } else {
        stepTank2 = 7;
      }
      
      tankOneX = tankOneX + moveTank1X;
      tankOneY = tankOneY + moveTank1Y;
      tankbox1.setLocation(tankOneX,tankOneY);
      
      tankTwoX = tankTwoX + moveTank2X;
      tankTwoY = tankTwoY + moveTank2Y;
      tankbox2.setLocation(tankTwoX,tankTwoY); 
  }
  
//method for collision tank1
  public static boolean checkCollisionWall(Rectangle collisionObject){
    if (r1.intersects(collisionObject)){
      return true;
    } else if (r2.intersects(collisionObject)){
      return true;
    } else if (r3.intersects(collisionObject)){
      return true;
    } else if (r4.intersects(collisionObject)){
      return true;
    } else if (r5.intersects(collisionObject)){
      return true;
    } else if (r6.intersects(collisionObject)){
      return true;
    } else if (r7.intersects(collisionObject)){
      return true;
    } else if (r8.intersects(collisionObject)){
      return true;
    } else if (r9.intersects(collisionObject)){
      return true;
    }return false;  
  }
  
  
  
  
//-----------------------------------------------------------------------------  
  static class GraphicsPanel extends JPanel{
    public GraphicsPanel(){
      setFocusable(true);
      requestFocusInWindow();
    }
    public void paintComponent(Graphics g){ 
      super.paintComponent(g); //required
      g.setColor(Color.black);
      
      //Main screen title page
      if(counter == 0){ 
        g.drawImage(battlefield,battlefieldX,battlefieldY,this);
        
        //how to play button 
        g.setColor(Color.black);
        g.fillRect(975, 380, 300, 100);
        
        //play button 
        g.setColor(Color.white);
        g.fillRect(200, 380, 300, 100);
        
        //tank 1
        g.setColor(Color.white);
        g.fillRect(120, 120, 100, 100);
        
        g.setColor(Color.gray);
        g.fillRect(100, 130, 20, 90);
        
        g.setColor(Color.gray);
        g.fillRect(220, 130, 20, 90);
        
        g.setColor(Color.gray);
        g.fillRect(160, 50, 20, 90);
        
        g.setColor(Color.darkGray);
        for (int y=130; y<220; y += 10)
          g.drawLine(100,y,120,y); 
        
        g.setColor(Color.darkGray);
        for (int y=130; y<220; y += 10)
          g.drawLine(220,y,240,y); 
        
        //tank 2
        g.setColor(Color.black);
        g.fillRect(1260, 120, 100, 100);
        
        g.setColor(Color.gray);
        g.fillRect(1240, 130, 20, 90);
        
        g.setColor(Color.gray);
        g.fillRect(1360, 130, 20, 90);
        
        g.setColor(Color.gray);
        g.fillRect(1300, 50, 20, 90);
        
        g.setColor(Color.darkGray);
        for (int y=130; y<220; y += 10)
          g.drawLine(1240,y,1260,y); 
        
        for (int y=130; y<220; y += 10)
          g.drawLine(1360,y,1380,y); 
        
        
        
        //title words
        g.setColor(Color.white);
        int largeSize = 108;
        Font largeFont = new Font("Times New Roman", Font.BOLD, largeSize);
        g.setFont(largeFont); 
        g.drawString("Tank", 350, 250);
        
        g.setColor(Color.black);
        g.setFont(largeFont); 
        g.drawString("PVP", 900, 250);
        
        g.setColor(Color.white);
        int smallSize = 48;
        Font smallFont = new Font("Times New Roman", Font.BOLD, smallSize);
        g.setFont(smallFont);
        g.drawString("How to Play", 1000, 450);
        
        g.setColor(Color.black);
        g.setFont(smallFont);
        g.drawString("Start Game", 225, 450);
        
        
      }
      
      //how to play page 
      if(counter == 1){ 
        g.setColor(Color.black);
        g.fillRect(0, 0, 1500, 900);
        
        //title
        g.setColor(Color.white);
        int wordSize = 72;
        Font wordFont = new Font("Times New Roman", Font.BOLD, wordSize);
        g.setFont(wordFont);
        g.drawString("How to Play", 550, 220);
        
        //instructions and controls
        g.setColor(Color.white);
        int smallSize = 40;
        Font smallFont = new Font("Times New Roman", Font.BOLD, smallSize);
        g.setFont(smallFont);
        g.drawString("Player 1 Controls:", 100, 450);
        g.drawString("Player 2 Controls:", 100, 550);
        
        g.setColor(Color.white);
        int wSize = 30;
        Font wFont = new Font("Times New Roman", Font.BOLD, wSize);
        g.setFont(wFont);
        g.drawString("The main objective of this game is to destroy the opposing player's tank!", 100, 300);
        g.drawString("Try your best to avoid the walls of quicksand as they will slow you down if stuck inside", 100, 330);
        g.drawString("To do so use the controls below to move and shoot your opponent:", 100, 360);
        g.drawString(" \"W\" = Forward, \"A\" = Left, \"S\" = Down, \"D\" = Right, \"Space\" = Shoot ", 410, 450);
        g.drawString(" \"5\" = Forward, \"1\" = Left, \"2\" = Down, \"3\" = Right, \"ENTER\" = Shoot ", 410, 550);
        g.drawString("Each game will end when a player reaches a score of 5 ", 410,650);
        g.drawString("Hitting the middle of the map will make a tank respawn", 410, 690);
        
        //back button
        g.setColor(Color.white);
        g.fillRect(1200, 600, 200, 100);
        
        g.setColor(Color.black);
        smallSize = 56;
        smallFont = new Font("Times New Roman", Font.BOLD, smallSize);
        g.setFont(smallFont);
        g.drawString("Back", 1230, 670);
        
        
      }
      
      //After your click play
      if (counter == 2){
        
        //maze
        g.fillRect(100, 0, 10, 100);
        g.fillRect(100, 100, 100, 10);
        g.fillRect(730, 400, 10, 200);
        g.fillRect(730, 400, 200, 10);
        g.fillRect(730, 600, 400, 10);
        g.fillRect(1100, 0, 10, 400);
        g.fillRect(200, 600, 10, 500);
        g.fillRect(540, 400, 10, 500);
        g.fillRect(0, 400, 300, 10);
        
        //middle wall
        g.setColor (Color.black);
        g.fillRect(750, 0, 10, 900);
        
        g.drawImage(sand,sandX,sandY,this);
        
        
        
        //borders
        g.setColor(Color.gray);
        g.fillRect(0,0, 1500, 10);
        g.fillRect(0,0,10,900);
        g.fillRect(0,851, 1500, 10);
        g.fillRect(1475, 0, 10, 900);
        
        
        //tank 1
        g.setColor(Color.black);
        g.fillRect(tankOneX, tankOneY, 80, 80);
        
        g.setColor(Color.gray);
        g.fillOval(tankOneX+20, tankOneY+20, 40, 40);
        g.setColor(Color.black);
        
        g.setColor(Color.gray);
        g.fillRect(tankOneX+40, tankOneY+35, 60, 10);
        
        //tank 2
        g.setColor(Color.green);
        g.fillRect(tankTwoX, tankTwoY, 80, 80);
        
        g.setColor(Color.gray);
        g.fillOval(tankTwoX+20, tankTwoY+20, 40, 40);
        
        g.setColor(Color.gray);
        g.fillRect(tankTwoX-20, tankTwoY+35, 60, 10);
        
        g.setColor(Color.red);
        for (int i=0; i<numBullets; i++){
          if (bulletVisible[i])
            g.fillOval(bulletX[i],bulletY[i],bulletW,bulletH);
        }
        
        g.setColor(Color.red);
        for (int i=0; i<numBullets2; i++){
          if (bulletVisible2[i])
            g.fillOval(bulletX2[i],bulletY2[i],bulletW2,bulletH2);
        }
        
        //scoreboard
        if (tankShot == 1){
          g.setColor(Color.black);
          g.fillRect(0, 0, 1500, 900);
          g.setColor(Color.white);
          int wSize = 46;
          Font wFont = new Font("Times New Roman", Font.BOLD, wSize);
          g.setFont(wFont);
          g.drawString("Tank One =" + " " + tankOneScore + " " + "Tank Two =" + " " + tankTwoScore, 460, 400); 
          g.drawString("Please click SHIFT to continue", 440, 500);
          //tank 1
          g.setColor(Color.white);
          g.fillRect(120, 120, 100, 100);
          
          g.setColor(Color.gray);
          g.fillRect(100, 130, 20, 90);
          
          g.setColor(Color.gray);
          g.fillRect(220, 130, 20, 90);
          
          g.setColor(Color.gray);
          g.fillRect(160, 50, 20, 90);
          
          g.setColor(Color.darkGray);
          for (int y=130; y<220; y += 10)
            g.drawLine(100,y,120,y); 
          
          g.setColor(Color.darkGray);
          for (int y=130; y<220; y += 10)
            g.drawLine(220,y,240,y); 
          
          //tank 2
          g.setColor(Color.green);
          g.fillRect(1260, 120, 100, 100);
          
          g.setColor(Color.gray);
          g.fillRect(1240, 130, 20, 90);
          
          g.setColor(Color.gray);
          g.fillRect(1360, 130, 20, 90);
          
          g.setColor(Color.gray);
          g.fillRect(1300, 50, 20, 90);
          
          g.setColor(Color.darkGray);
          for (int y=130; y<220; y += 10)
            g.drawLine(1240,y,1260,y); 
          
          for (int y=130; y<220; y += 10)
            g.drawLine(1360,y,1380,y); 
          
        }
        //game over
        if ((tankOneScore == 5) || (tankTwoScore == 5)){
          g.setColor(Color.black);
          g.fillRect(0, 0, 1500, 900);
          
          //button
          g.setColor(Color.white);
          g.fillRect(600, 380, 275, 100);
          
          g.setColor(Color.black);
          int smallSize = 60;
          Font smallFont = new Font("Times New Roman", Font.BOLD, smallSize);
          g.setFont(smallFont);
          g.drawString("Restart", 640, 450);
          
          g.setColor(Color.white);
          int wordSize = 72;
          Font wordFont = new Font("Times New Roman", Font.BOLD, wordSize);
          g.setFont(wordFont);
          g.drawString("Game Over", 550, 200);
          
          gameOver = 1;
          
          
        }
        
      }
      
      
      
      
      
      // do all your drawings here      
      
    } // paintComponent method end
  } // GraphicsPanel class end
  
//------------------------------------------------------------------------------ 
  static class MyMouseListener implements MouseListener{
    public void mouseClicked(MouseEvent e){
      System.out.println("Mouse clicked at X:"+e.getX() + " Y:"+e.getY());
    }
    public void mousePressed(MouseEvent e){   
      int mouseX = e.getX();
      int mouseY = e.getY();
      if (counter == 0){
        if ((mouseX >= 975) && (mouseX <= 1275)){
          if ((mouseY >= 380) && (mouseY <= 480)){
            counter = 1;
          }
        }
        
        if ((mouseX >= 200) && (mouseX <= 500)){
          if ((mouseY >= 380) && (mouseY <= 480)){
            counter = 2;
          }
        }
      }
      
      if (counter == 1){
        if ((mouseX >= 1200) && (mouseX <= 1400)){
          if ((mouseY >= 600) && (mouseY <= 700)){
            counter = 0;
          }
        }
      }
      
      if ((tankOneScore == 5) || (tankTwoScore == 5)){
        if ((mouseX >= 600 ) && (mouseX <= 875 )){
          if ((mouseY >= 380 ) && (mouseY <= 480 )){
            //restart game variables
            gameRestart = 0;
            counter = 0;
            count = 0;
            tankOneX = 50;
            tankOneY = 750;
            tankTwoX = 1350;
            tankTwoY = 50;
            tankbox1 = new Rectangle(tankOneX, tankOneY, 80, 80);
            tankbox2 = new Rectangle(tankTwoX, tankTwoY, 80, 80);
            r1 = new Rectangle(100, 0, 10, 100);
            r2 = new Rectangle(100, 100, 100, 10);
            r3 = new Rectangle(730, 400, 10, 200);
            r4 = new Rectangle(730, 400, 200, 10);
            r5 = new Rectangle(1100, 0, 10, 400);
            r6 = new Rectangle(200, 600, 10, 500);
            r7 = new Rectangle(540, 400, 10, 500);
            r8 = new Rectangle(0, 400, 300, 10);
            r9 = new Rectangle(730, 600, 400, 10);
            
            b1 = new Rectangle(0,0, 1500, 10);
            b2 = new Rectangle(0,0,10,900);
            b3 = new Rectangle(0,851, 1500, 10);
            b4 = new Rectangle(1475, 0, 10, 900);
            
            collision = 0; 
            collisionOne = 0;
            sandMovement = 10;
            sandMovementOne = 10;
            tankShot = 0;
            tankOneScore = 0;
            tankTwoScore = 0;
            gameOver = 0;
            
            //bullet 1
            numBullets = 40;    
            bulletX = new int[numBullets];
            bulletY = new int[numBullets];
            bulletVisible = new boolean[numBullets];
            bulletW = 6;
            bulletH = 10;
            bulletSpeed = 10;
            currentBullet = 0;
            
            //bullet 2
            numBullets2 = 40;    
            bulletX2 = new int[numBullets2];
            bulletY2 = new int[numBullets2];
            bulletVisible2 = new boolean[numBullets2];
            bulletW2 = 6;
            bulletH2 = 10;
            bulletSpeed2 = -10;
            currentBullet2 = 0;
            bulletHitBox2 = new Rectangle[numBullets2];
            bulletHitBox = new Rectangle[numBullets];
            
            
            
            moveTank1X = 0;
            moveTank1Y = 0;
            
            moveTank2X = 0;
            moveTank2Y = 0;
            
            stepTank1 = 5;
            stepTank2 = 5;
            
          }
        }
      }
    }
    
    
    public void mouseReleased(MouseEvent e){ 
      
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
    }
    public void mouseDragged(MouseEvent e){  
      
    }        
  } // MyMouseMotionListener class end
  
//keyboard
  static class MyKeyListener implements KeyListener{   
    // method to process key pressed events (when a key goes down, i.e. immediately)
    public void keyPressed(KeyEvent e){            
      
      int key = e.getKeyCode();
      
      
      if (tankShot == 0){
        if (key == KeyEvent.VK_LEFT){
          moveTank1X = -stepTank1;
        } 
        
        else if (key == KeyEvent.VK_RIGHT){
          moveTank1X = stepTank1;
        } 
        
        else if (key == KeyEvent.VK_UP){
          moveTank1Y = -stepTank1;
        } 
        
        else if (key == KeyEvent.VK_DOWN){
          moveTank1Y = stepTank1;
        }
        
        if (key == KeyEvent.VK_A){
          moveTank2X = -stepTank2;
        } 
        
        else if (key == KeyEvent.VK_D){
          moveTank2X = stepTank2;
        } 
        
        if (key == KeyEvent.VK_W){
          moveTank2Y = -stepTank2;
        } 
        
        else if (key == KeyEvent.VK_S){
          moveTank2Y = stepTank2;
        }
      }
      if (tankShot == 1){
        if (key == 16){
          tankShot = 0;
          tankOneX = 50;
          tankOneY = 750;
          tankTwoX = 1350;
          tankTwoY = 50;
        }
      }
      
      sandMovement = 10;
    }
    
    // method to process key released events (when a key goes up)
    public void keyReleased(KeyEvent e){ 
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_ESCAPE){
        gameWindow.dispose();
      }
      if (tankShot == 0){
        if (key == KeyEvent.VK_LEFT){
          moveTank1X = 0;
        } 
        
        else if (key == KeyEvent.VK_RIGHT){
          moveTank1X = 0;
        } 
        
        else if (key == KeyEvent.VK_UP){
          moveTank1Y = 0;
        } 
        
        else if (key == KeyEvent.VK_DOWN){
          moveTank1Y = 0;
        }
        if (key == KeyEvent.VK_A){
          moveTank2X = 0;
        } 
        
        else if (key == KeyEvent.VK_D){
          moveTank2X = 0;
        } 
        
        if (key == KeyEvent.VK_W){
          moveTank2Y = 0;
        } 
        
        else if (key == KeyEvent.VK_S){
          moveTank2Y = 0;
        }
        char keyChar = e.getKeyChar();
        
        //shooting
        if (tankShot == 0){
          if (keyChar == KeyEvent.VK_ENTER){
            // assign the coordinates of the top middle point of the ship to the current bullet
            bulletX[currentBullet] = tankOneX + 75;
            bulletY[currentBullet] = tankOneY + 35;
            bulletVisible[currentBullet] = true;
            currentBullet = (currentBullet + 1)%numBullets;
          }
        }
        
        //shooting
        if (tankShot == 0){
          if (keyChar == KeyEvent.VK_SPACE){
            // assign the coordinates of the top middle point of the ship to the current bullet
            bulletX2[currentBullet2] = tankTwoX-5;
            bulletY2[currentBullet2] = tankTwoY + 35;
            bulletVisible2[currentBullet2] = true;
            currentBullet2 = (currentBullet2 + 1)%numBullets2;
          }
        }
        
      }
    }   
    // method to process key typed events (only typeable/printable keys)
    public void keyTyped(KeyEvent e){
    }
    
  } // MyKeyListener class end   
  
} // TankPvp class end





