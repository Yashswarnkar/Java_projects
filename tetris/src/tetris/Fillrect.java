package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.Timer;



public class Fillrect extends JPanel {
	
	private int i;
	private int j;
	Color clr;
	
	
	
	public Fillrect(int a,int b,Color c)
	{
		i=a;
		j=b;
		clr=c;
			
	}
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
				if(j==0){repaint();j=1;}
				if(i==1)
				{
					
					g.setColor(clr);
					g.fillRect(0, 0, 40, 40);}
				else
				{g.setColor(Color.WHITE);
				g.fillRect(0, 0, 40, 40);
				}
	
		
		
	}
	
}
