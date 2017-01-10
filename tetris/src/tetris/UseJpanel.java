package tetris;
import javax.swing.JPanel;

import java.awt.*;

public class UseJpanel extends JPanel{
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.setBackground(new Color(0,52,113));
		g.setColor(Color.WHITE);
		g.fillRect(25,0,400,700);
		g.setColor(new Color(0,52,117));
		g.fillRect(25,300, 400, 2);
		
		for( int i=0;i<=10;i++)
		{
			g.fillRect(25+40*i, 300, 2, 400);
			g.fillRect(25, 300+40*i, 400, 2);
		}
	}

}
