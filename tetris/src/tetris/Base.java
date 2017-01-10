package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Base extends JFrame {

	JLabel nm=new JLabel("NAME :");
	
	JLabel gm=new JLabel("WHAT DO YOU WANT TO PLAY?");
	JLabel wm=new JLabel("WELCOME TO THE GAMERS POINT");
	JTextField n=new JTextField();
	JRadioButton p1=new JRadioButton("   TETRIS");
	JRadioButton p2=new JRadioButton("   BEAT THE TRAFFIC");
	JRadioButton p3=new JRadioButton("   STACK");
	JLabel i1=new JLabel();
	JLabel i2=new JLabel();
	JLabel i3=new JLabel();
	JLabel abtus=new JLabel();
	public Base()
	{
		super("GAMERS POINT");
		setLayout(null);
		
		
		nm.setBounds(145, 110, 100, 40);
		nm.setForeground(new Color(0,52,113));
		nm.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.PLAIN,20));
		add(nm);
		
		
		
		wm.setBounds(0, 20, 600, 40);
		wm.setForeground(new Color(0,52,113));
		wm.setFont(new Font("ROCKWELL",Font.BOLD,25));
		wm.setHorizontalAlignment(JLabel.CENTER);
		add(wm);
		
		gm.setBounds(0, 200, 600, 40);
		gm.setForeground(new Color(0,52,113));
		gm.setFont(new Font("ROCKWELL",Font.BOLD,18));
		gm.setHorizontalAlignment(JLabel.CENTER);
		add(gm);
		
		
		n.setText("");
		n.requestFocusInWindow();
		n.setFont(new Font("ROCKWELL",Font.PLAIN,15));
		n.setBounds(235,115,200,30);
		add(n);
		
		
		
		p1.setBounds(210,265,200,20);
		p1.setForeground(Color.WHITE);
		p1.setBackground(new Color(0,52,113));
		p1.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.BOLD,13));
		add(p1);
		p2.setBounds(210,315,200,20);
		p2.setForeground(Color.WHITE);
		p2.setBackground(new Color(0,52,113));
		p2.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.BOLD,13));
		add(p2);
		p3.setBounds(210,365,200,20);
		p3.setForeground(Color.WHITE);
		p3.setBackground(new Color(0,52,113));
		p3.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.BOLD,13));
		add(p3);
		
		i1.setIcon(new ImageIcon("button.png"));
		i1.setBounds(200, 245, 250, 60);
		add(i1);
		
		i2.setIcon(new ImageIcon("button.png"));
		i2.setBounds(200, 295, 250, 60);
		add(i2);
		
		i3.setIcon(new ImageIcon("button.png"));
		i3.setBounds(200, 345, 250, 60);
		add(i3);
		
		abtus.setIcon(new ImageIcon("ABOUT.png"));
		abtus.setBounds(200,445,250,60);
		add(abtus);
		
		abtus.addMouseListener(
				
				new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						
						Aboutus base2=new Aboutus();
						//base2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						base2.setBounds(100,100, 400, 300);
						base2.setVisible(true);
						base2.getContentPane().setBackground(new Color(179,214,254));
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				
				
				
				);
		
		p1.addItemListener(
				
				new ItemListener(){

					public void itemStateChanged(ItemEvent arg0) {
						
						String s=n.getText();
						dispose();
						Game base2=new Game(s);
						base2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						base2.setSize(800,700);
						base2.setVisible(true);
						base2.getContentPane().setBackground(new Color(179,214,254));
					}
				}
							
				);
		p2.addItemListener(
				
				new ItemListener(){

					public void itemStateChanged(ItemEvent arg0) {
						
						String s=n.getText();
						
						dispose();
						Game2 base2=new Game2(s);
						base2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						base2.setSize(750,650);
						base2.setVisible(true);
						base2.getContentPane().setBackground(new Color(179,214,254));
					}
				}
							
				);
		p3.addItemListener(
		
				new ItemListener(){

					public void itemStateChanged(ItemEvent arg0) {
				
						String s=n.getText();
						dispose();
						Game4 base2=new Game4(s);
						base2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						base2.setSize(1000,700);
						base2.setVisible(true);
						base2.getContentPane().setBackground(new Color(179,214,254));
			}
		}
					
		);

		
	}
}
