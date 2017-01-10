package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;






import java.util.Timer;
import java.util.TimerTask;

public class Game4 extends JFrame implements KeyListener{

	
	private int i;
	private int k;
	private int v;
	private int x1,y1,x2,y2;
	private int X1,Y1,X2,Y2;
	private int w1,w2;
	private int score;
	Fillrect2 f=new Fillrect2(100,100,1);
	Fillrect2 b=new Fillrect2(100,100,2);
	JLabel wl=new JLabel();
	JLabel j1=new JLabel("SCORE :");
	JLabel e = new JLabel("PRESS SPACEBAR TO START");
	JTextField tx=new JTextField("0");
	String s;
	
	public Game4(String st)
	{
		setLayout(null);
		
		addKeyListener(this);
		
		UseJpanel4 p=new UseJpanel4();
		p.setBounds(0,0,600,900);
		add(p);
		i=0;
		v=1;
		score=0;
		k=0;
		X1=275;
		Y1=275;
		X2=375;
		Y2=375;
		w1=X2-X1;
		w2=Y2-Y1;
		b.setBounds(X1,Y1,X2-X1,Y2-Y1);
		add(b);
		
		tx.setBounds(770, 100, 100, 40);
		tx.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.PLAIN,20));
		tx.setFocusable(false);
		add(tx);
		
		j1.setBounds(660,100,100,40);
		j1.setForeground(new Color(0,52,117));
		j1.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.PLAIN,20));
		add(j1);
		
		e.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.PLAIN,20));
		e.setBounds(650,100,400,400);
		add(e);
		
		s=st;
		wl.setText("         WELCOME  "+s);
		wl.setForeground(new Color(0,52,117));
		wl.setFont(new Font("ROCKWELL",Font.BOLD,20));
		wl.setBounds(620,20,500,40);
		add(wl);

		
		p.addMouseListener(
				
				new MouseListener()
				{

					@Override
					public void mousePressed(MouseEvent arg0) {
						v=v^1;
						i=0;
						k=10;
						x1=f.getX();
						y1=f.getY();
						x2=x1+f.getWidth();
						y2=y1+f.getHeight();
						X1=b.getX();
						Y1=b.getY();
						X2=X1+b.getWidth();
						Y2=Y1+b.getHeight();
						if((x2<X1||x1>X2||y2<Y1||y1>Y2))
							gover();
						else
							{score+=100;tx.setText(Integer.toString(score));}
						w1=min(X2,x2)-max(X1,x1);						
						w2=min(Y2,y2)-max(Y1,y1);
						if((w1<0.5&&w1>=0)||(w2<0.5&&w2>=0))
							gover();
						b.setBounds(275,275,w1,w2);
						
						
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
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				}
				
				
				
				);
		
		
		Timer timer= new Timer();
		timer.scheduleAtFixedRate(
				
				new TimerTask()
				{
					public void run()
					{
						if(v==0){
						f.setBounds(i,275,w1,w2);
						add(f);
						}
						if(v==1){
							f.setBounds(275,i,w1,w2);
							add(f);
						}
						i+=k;
						if(i==500||i==0)
							k=-1*k;
							
					}
					
				}
				
				,60,60);
		
	}
	public void keyPressed(KeyEvent e) {
		 
		
	}
	public void keyReleased(KeyEvent arg0) {
		
	}
	public void keyTyped(KeyEvent e) {
		
		k=10;
		
	}
	public void gover()
	{
		k=0;
		Object[] options1 =  {"START NEW GAME"};
		JOptionPane.showOptionDialog(null,"                    FINAL SCORE IS: "+"    "+ score,"GAME OVER",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,options1,null);
		dispose();
		Main.rungame();
		score=0;
		//tx.setText("0");
		//j=0;
	}
	public int max(int x,int y)
	{
		if(x>y)
			return x;
		return y;
	}
	public int min(int x,int y)
	{
		if(x<y)
			return x;
		return y;
	}
	

}
