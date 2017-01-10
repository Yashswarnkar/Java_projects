package tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class Game extends JFrame{
	
	private int a;
	private int time;
	private int cntplc;
	private JButton left;
	private JButton rgt;
	private JButton rotc;
	private JButton plc;
	private int height[]=new int[10];
	private int l;
	private int h;
	private int w;
	JTextField tx=new JTextField();
	JTextField tx2=new JTextField();
	private JLabel item1;
	private JLabel item2;
	JLabel wl=new JLabel();
	private int score;
	Color clr;
	Font myFont;
	String s;

	public Game(String st)
	{
				
		
		super("JAVA PROJECT -> THE GREAT TETRIS");
		
		setLayout(null);
		
		
		UseJpanel p=new UseJpanel();
		p.setBounds(0, 0, 450, 700);
		add(p);		
	
		newobj();
			
		for(int i=0;i<10;i++)
			height[i]=0;
		score=0;
		time=10000;
		cntplc=0;
		
		
		left=new JButton("LEFT");
		 rgt=new JButton("RIGHT");
		 rotc=new JButton("ROTATE");
		 plc=new JButton("PLACE");
		
		left.addActionListener(
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						if(l>0)
							l--;
						for(int i=0;i<h;i++)
						{
							for(int j=0;j<w;j++)
							{
								repaint();
								Fillrect f=new Fillrect(1,0,clr);
								f.setBounds(27+(l+j)*40,52+i*40,38,38);
								add(f);
							}
						}
						disp();
						
						
					}
				}
				
				
				);
		
		rgt.addActionListener(
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						if(l+w<10)
							l++;
						for(int i=0;i<h;i++)
						{
							for(int j=0;j<w;j++)
							{
								repaint();
								Fillrect f=new Fillrect(1,0,clr);
								f.setBounds(27+(l+j)*40,52+i*40,38,38);
								add(f);
							}
						}
						disp();
					}
				}
				
				
				);
		rotc.addActionListener(
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						for(int i=0;i<h;i++)
						{
							for(int j=0;j<w;j++)
							{
								repaint();
								Fillrect f=new Fillrect(0,1,clr);
								f.setBounds(27+(l+j)*40,52+i*40,38,38);
								add(f);
							}
						}
						int temp;
						temp=h;
						h=w;
						w=temp;
						
						if(l>5&&h<4)
							l-=(w-1);
						for(int i=0;i<h;i++)
						{
							for(int j=0;j<w;j++)
							{
								repaint();
								Fillrect f=new Fillrect(1,0,clr);
								f.setBounds(27+(l+j)*40,52+i*40,38,38);
								add(f);
							}
						}
						disp();
					}
				}
				
				
				);
		plc.addActionListener(
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						for(int i=l;i<l+w;i++)
							height[i]=height[i]+h;
						chrow();
						disp();
						gover();
						newobj();
						cntplc++;
						time=10000-(2000*(cntplc/5));
						if(time<6000)
							time=6000;
						
						

						
					}
				}
				
				
				);
		 left.setBounds(485, 90, 125, 40);
		 rgt.setBounds(625, 90, 125, 40);
		 rotc.setBounds(485, 145, 125, 40);
		 plc.setBounds(625, 145,125, 40);
		 
		 tx.setBounds(625, 240, 125, 40);
		 tx2.setBounds(625,310,125,40);
		 
		 
		 myFont = new Font("Comic Sans MS", Font.BOLD, 14);
		 
		 
		 rgt.setBackground(new Color(0,52,117));
		 rotc.setBackground(new Color(0,52,117));
		 left.setBackground(new Color(0,52,117));
		 plc.setBackground(new Color(0,52,117));
		 rgt.setForeground(Color.WHITE);
		 rotc.setForeground(Color.WHITE);
		 left.setForeground(Color.WHITE);
		 plc.setForeground(Color.WHITE);
		 rgt.setFont(myFont);
		 left.setFont(myFont);
		 rotc.setFont(myFont);
		 plc.setFont(myFont);
		 add(rgt);
		 add(rotc);
		 add(plc);
		 add(left);
		 add(tx);
		 add(tx2);
		 
		 myFont = new Font("COPPERPLATE GOTHIC LIGHT", Font.BOLD, 20);
		 
		 String str=new String("SCORE:");
		 item1=new JLabel(str);
		 item1.setFont(myFont);
		 item1.setForeground(new Color(0,52,117));
		 item1.setBounds(500, 210, 200, 100);
		 add(item1);
		 
		 String str2=new String("TIMER:");
		 item2=new JLabel(str2);
		 item2.setFont(myFont);
		 item2.setForeground(new Color(0,52,117));
		 item2.setBounds(500, 280, 200, 100);
		 add(item2);
		 
		 
		 	s=st;
			wl.setText("WELCOME  "+s);
			wl.setForeground(new Color(0,52,117));
			wl.setFont(new Font("ROCKWELL",Font.BOLD,20));
			wl.setBounds(470,20,500,40);
			add(wl);
			
		 
		 tx.setForeground(Color.BLACK);
		 tx.setHorizontalAlignment(SwingConstants.CENTER);
		 upscore(0);
		 
		 tx2.setForeground(Color.BLACK);
		 tx2.setHorizontalAlignment(SwingConstants.CENTER);
		 
		 
		 	 
		 
		
	
	Timer timer=new Timer();
	
	timer.scheduleAtFixedRate( new TimerTask() {  
		@Override 
		  
		  public void run() {
			 
			
				tx2.setText(Integer.toString(time/1000));
				time-=1000;
				tx2.setFont(myFont);
				if(time==-1000)
					gover2();
				
				
			
		    
		  }
		}, 1000, 1000);
	
	
	}
	
	
	public void newobj()
	{
		
		a=randomnumgenerator();
		gencolor();
		l=0;
		if(a==0){
			h=2;
			w=2;
				}
		else if(a==1){
			
			h=4;
			w=1;
			}
		else if(a==2){
			
			h=1;
			w=4;
			}
		else if(a==3){
			
			h=3;
			w=2;
			}
		else if(a==4){
			
			h=2;
			w=3;
			}
		
		
		for(int i=0;i<h;i++)
		{
			for(int j=0;j<w;j++)
			{
				repaint();
				Fillrect f=new Fillrect(1,0,clr);
				f.setBounds(27+(l+j)*40,52+i*40,38,38);
				add(f);
			}
		}
		
		
	}
	
	
	public void disp()
	{
		for(int i=0;i<10;i++){
			
			for(int j=0;j<height[i];j++)
			{
				repaint();
				Fillrect f=new Fillrect(1,0,Color.YELLOW);
				f.setBounds(27+(i)*40,622-j*40,38,38);
				add(f);
				
			}
			
			}
			
	}
	
	
	public void chrow()
	{
		int x=minh();
		if(x!=0)
		{
			for(int i=0;i<10;i++)
			{
				height[i]-=x;
				upscore(x);
			}
			
		}
	}
	
	
	public void gover2()
	{
		Object[] options1 =  {"START NEW GAME"};
		JOptionPane.showOptionDialog(null,"                    FINAL SCORE IS: "+"    "+ score,"GAME OVER",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,options1,null);
		
		dispose();

		Main.rungame();

	}
	
	
	public void gover()
	{
		int x=maxh();
		if(x>=9)
		{
			Object[] options1 =  {"START NEW GAME"};
			JOptionPane.showOptionDialog(null,"                    FINAL SCORE IS: "+"    "+ score,"GAME OVER",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE,null,options1,null);
			
			dispose();

			Main.rungame();
			
		}
	}
	
	
	public void upscore(int x)
	{
		if(x!=0)
		score=Integer.parseInt(tx.getText());
		score=score+x*10;
		tx.setText(Integer.toString(score));
		tx.setFont(myFont);
		
	}
	
	
	public int maxh()
	{
		int max=0;
		for(int i=0;i<10;i++)
		{
			if(height[i]>max)
				max=height[i];
		}
		return max;
	}
	
	
	public int minh()
	{
		int min=100;
		for(int i=0;i<10;i++)
		{
			if(height[i]<min)
				min=height[i];
		}
		return min;
	}
	
	public void gencolor()
	{
		int a=randomnumgenerator();
		if(a==0)
			clr=Color.BLUE;
		if(a==1)
			clr=Color.RED;
		if(a==2)
			clr=Color.ORANGE;
		if(a==3)
			clr=Color.GREEN;
		if(a==4)
			clr=Color.CYAN;
		
	}
	
	
	public int randomnumgenerator()
	{
		Random n=new Random();
		int num;
		num=n.nextInt(999999);
		
		num%=5;
		return num;
	}
	
	
	
}
