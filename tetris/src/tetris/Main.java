package tetris;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {

	public static void main(String args[])
	{
		rungame();
		
	}
	public static void rungame()
	{
		Base base1=new Base();
		base1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base1.setSize(600,600);
		base1.setVisible(true);
		base1.getContentPane().setBackground(new Color(179,214,254));
		
	}
}
