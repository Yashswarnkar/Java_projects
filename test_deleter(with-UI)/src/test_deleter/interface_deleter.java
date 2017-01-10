/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_deleter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static test_deleter.Test_deleter.deleter;

/**
 *
 * @author abc
 */
public class interface_deleter extends JFrame  {
    String S1=null,S2=null;
     JLabel  nw = new JLabel("Enter Source and threshold date for deletion in (MM/dd/yyyy) - avoid brackets ");
     JTextField n1=new JTextField();
    JTextField n2=new JTextField();
     JRadioButton p1=new JRadioButton("   submit");
     
     public interface_deleter(){
         setLayout(null);
      nw.setBounds(35, 60, 590, 30);
       nw.setForeground(Color.red);
       nw.setFont(new Font("COPPERPLATE GOTHIC LIGHT",Font.PLAIN,20));
       add(nw);
       
       
        n1.setText("");
		n1.requestFocusInWindow();
		n1.setFont(new Font("ROCKWELL",Font.PLAIN,15));
		n1.setBounds(135,115,400,30);
		add(n1);		
        
        n2.setText("");
		n2.requestFocusInWindow();
		n2.setFont(new Font("ROCKWELL",Font.PLAIN,15));
		n2.setBounds(135, 165, 400, 30);
		add(n2);
                
                  p1.setBounds(135,265,200,20);
		p1.setForeground(Color.GREEN);
		p1.setBackground(new Color(0,52,113));
		p1.setFont(new Font("ROCKWELL",Font.BOLD,13));
		add(p1);     
                
                
                
                 p1.addItemListener(
				
				new ItemListener(){

					public void itemStateChanged(ItemEvent arg0) {
						
						S1=n1.getText();
                                                 S2=n2.getText();
                                                  File folderA= new File(S1);
                                                String date= S2.substring(0, 10);
                                                 Date threshold = new Date();
                                                 DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
                                            try {
                                                threshold=df.parse(date);
                                            } catch (ParseException ex) {
                                                Logger.getLogger(interface_deleter.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            deleter(folderA.listFiles(),threshold);
						dispose();
						
					}
				}
							
				);

     }
    
}
