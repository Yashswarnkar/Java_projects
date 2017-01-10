package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Aboutus extends JFrame{
	
	private JButton b;
	
	public Aboutus()	
	{
		
		
		setLayout(null);
		
		
		Font credit=new Font("Serif",Font.BOLD,20);
		
	 JLabel c1=new JLabel("MADE BY:");
	 c1.setFont(credit);
	 c1.setForeground(new Color(0,52,113));
	 c1.setBounds(10, 10, 400, 30);
	 add(c1);
	 JLabel c2=new JLabel("VAIBHAV SAXENA  - 379/COE/14");
	 c2.setFont(credit);
	 c2.setForeground(new Color(0,52,113));
	 c2.setBounds(10, 40, 400, 30);
	 add(c2);
	 JLabel c3=new JLabel("YASH SWARNKAR  - 394/COE/14");
	 c3.setFont(credit);
	 c3.setForeground(new Color(0,52,113));
	 c3.setBounds(10, 70, 400, 30);
	 add(c3);
	 
	 b=new JButton("BACK");
	 b.setForeground(Color.white);
	 b.setBackground(new Color(0,52,113));
	 b.setBounds(150,200,100,40);
	 add(b);
	 
	 b.addActionListener(
			 
			 new ActionListener()
			 {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
				 
			 }
			 
			 
			 
			 
			 
			 
			 
			 );
	 
	}
	
	
	
	
}
