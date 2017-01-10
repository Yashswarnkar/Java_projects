/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_copying;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author abc
 */
public class interface_copying extends JFrame {
    JTextField n1=new JTextField();
    JTextField n2=new JTextField();
    String S1="t1",S2="t2";
    JRadioButton p1=new JRadioButton("   submit");
    public interface_copying(){
       setLayout(null);
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
                                                  File folderB=new File(S2);
                                            try {
                                                copyDirectory(folderA,folderB);
                                            } catch (IOException ex) {
                                                Logger.getLogger(interface_copying.class.getName()).log(Level.SEVERE, null, ex);
                                            }
						dispose();
						
					}
				}
							
				);

        
    }
     public static void copyDirectory(File sourceLocation , File targetLocation)
    throws IOException {
      // System.out.println("yash");
        if (sourceLocation.isDirectory()) {
        //    System.out.println("kkk");
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }

            String[] children = sourceLocation.list();
            for (int i=0; i<children.length; i++) {
                copyDirectory(new File(sourceLocation, children[i]),
                        new File(targetLocation, children[i]));
            }
        } else if(sourceLocation.lastModified()!=targetLocation.lastModified()) {
       //     System.out.println("manas");
           //  System.out.println(sourceLocation.lastModified());
            InputStream in = new FileInputStream(sourceLocation);
            OutputStream out = new FileOutputStream(targetLocation);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }
    
}
