package tetris;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.TimerTask;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.util.Timer;

public class Game2 extends JFrame implements KeyListener{
	
	private int pos; 
	private int x1;
	private int y1;
	private int flag;
	Fillrect2 f2=new Fillrect2(2);
	private int score;
	String s;
	JTextField tx=new JTextField("0");
	JLabel j=new JLabel("SCORE :");
	JLabel wl=new JLabel();
	JLabel e=new JLabel("PRESS SPACEBAR TO START THE GAME");
	int k;
	public Game2(String st)
	{
		setLayout(null);
		
		
		UseJPanel2 p=new UseJPanel2();
		p.setBounds(0, 0, 400, 642);
		add(p);
		
		e.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.PLAIN,20));
		e.setBounds(420,100,400,400);
		add(e);
		
		tx.setBounds(570, 100, 100, 40);
		tx.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.PLAIN,20));
		tx.setFocusable(false);
		add(tx);
		
		j.setBounds(450,100,100,40);
		j.setForeground(new Color(0,52,117));
		j.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.PLAIN,20));
		add(j);
		
		s=st;
		wl.setText("         WELCOME  "+s);
		wl.setForeground(new Color(0,52,117));
		wl.setFont(new Font("ROCKWELL",Font.BOLD,20));
		wl.setBounds(400,20,500,40);
		add(wl);
		
		
		pos=182;
		x1=0;
		y1=0;
		k=0;
		score=0;
		flag=0;
		//Fillrect2 f2=new Fillrect2();
		f2.setBounds(pos,440,38,38);
		add(f2);
		addKeyListener(this);
	    		
		
		Timer timer=new Timer();
		
		timer.scheduleAtFixedRate( new TimerTask() {
			Fillrect2 f1=new Fillrect2(1);
			@Override 
			  
			  public void run() {
				  
				if(y1==0)
					x1=randomnumgenerator();
				if(y1==440){
					
				if(x1==pos&&y1==440)
				{
					if(flag==0)gover();
				}
					
				else
					{score+=100;tx.setText(Integer.toString(score));}
				}
					repaint();
					
					f1.setBounds(x1,y1+2,38,38);
					add(f1);
					y1=(y1+k)%480;
					//f=f1;
			    
			  }
			}, 50, 50);

		
	
	}
	public int randomnumgenerator()
	{
		Random n=new Random();
		int num;
		num=n.nextInt(999999);
		
		num%=3;
		return (num)*100+82;
	}
	public void keyPressed(KeyEvent e) {
		 if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	            if(pos>82)pos-=100;f2.setBounds(pos,440,38,38);add(f2);
	        }
	        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	            if(pos<282)pos+=100;f2.setBounds(pos,440,38,38);add(f2);
	        }
		
	}
	public void keyReleased(KeyEvent arg0) {
		
	}
	public void keyTyped(KeyEvent e) {
		
		k=40;
		
	}
	
	public void gover()
	{
		Object[] options1 =  {"START NEW GAME"};
		JOptionPane.showOptionDialog(null,"                    FINAL SCORE IS: "+"    "+ score,"GAME OVER",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,options1,null);
		flag=1;
		dispose();
		Main.rungame();
		
	}



}
