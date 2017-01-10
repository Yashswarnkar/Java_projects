package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Fillrect2 extends JPanel {
	
	private int h,l,f;
	Color clr;
	public Fillrect2(int a)
	{
		f=a;
			
	}
	public Fillrect2(int w,int x,int q)
	{
		f=0;
		h=w;l=x;
		if(q==1)
		clr=new Color(148,8,1);
		if(q==2)
		clr=new Color(251,222,27);
	}
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		
			if(f==0){	
				g.setColor(clr);
				g.fillRect(0, 0, h, l);
				repaint();		
			}
			else if(f==1)
			{
				
				BufferedImage image;
				try {
					image = ImageIO.read(new File("C:\\Users\\vaibhav\\Desktop\\codes\\eclipse workspace\\tetris\\bluecar.png"));
				} catch (IOException e) {
					e.printStackTrace();
					image=null;
				};
				g.drawImage(image,0,0,null);
				repaint();
						
			}
			else if(f==2)
			{
				BufferedImage image;
				try {
					image = ImageIO.read(new File("C:\\Users\\vaibhav\\Desktop\\codes\\eclipse workspace\\tetris\\redcar.png"));
				} catch (IOException e) {
					e.printStackTrace();
					image=null;
				};
				g.drawImage(image,0,0,null);
				repaint();
			}
	}
	

}
