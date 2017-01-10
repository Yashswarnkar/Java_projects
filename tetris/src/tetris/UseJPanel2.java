package tetris;

import javax.swing.JPanel;

import java.awt.*;

public class UseJPanel2 extends JPanel{
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(new Color(8,93,10));
		g.setColor(Color.WHITE);//new Color(255,150,150));
		
		g.fillRect(75, 0, 50, 800);
		g.fillRect(175, 0, 50, 800);
		g.fillRect(275, 0, 50, 800);
		
		g.setColor(Color.BLACK);
		g.fillRect(74, 0, 2, 800);
		g.fillRect(174, 0, 2, 800);
		g.fillRect(274, 0, 2, 800);
		g.fillRect(126, 0, 2, 800);
		g.fillRect(226, 0, 2, 800);
		g.fillRect(326, 0, 2, 800);
		
	}
	

}
