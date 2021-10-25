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


static int numBullets2 = 40;    
static int[] bulletX2 = new int[numBullets2];
static int[] bulletY2 = new int[numBullets2];
static boolean[] bulletVisible2 = new boolean[numBullets2];
static int bulletW2 = 6;
static int bulletH2 = 10;
static int bulletSpeed2 = -10;
static int currentBullet2 = 0;

Arrays.fill(bulletX2,0);
Arrays.fill(bulletY2,0);
Arrays.fill(bulletVisible2,false);

for (int i=0; i<numBullets2; i++){
  if (bulletVisible2[i]){
    bulletX2[i] = bulletX2[i] + bulletSpeed2;
    if (bulletX2[i]<0)
      bulletVisible2[i] = false;
  }
  
  bulletX2[currentBullet2] = tankTwoX;
  bulletY2[currentBullet2] = tankTwoY + 40;
  bulletVisible2[currentBullet2] = true;
  currentBullet2 = (currentBullet2 + 1)%numBullets2;
}