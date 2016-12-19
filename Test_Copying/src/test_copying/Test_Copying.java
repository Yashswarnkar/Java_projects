/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_copying;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author abc
 */
public class Test_Copying {

    /**
     * @param args the command line arguments
     */
  
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
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String[] inp = null;
BufferedReader br = new BufferedReader(new FileReader("test"));
String line=null,line1=null,temp = null;
    int count=0;
    while((temp=br.readLine())!=null){
    //    System.out.println(" ll ");
      if(count==0)  {line=temp;
      
      }
        else if(count==1){line1=temp;
      
      }
        count++;
    }
      //System.out.println(line);
       //  System.out.println(line1);
  //  line="/home/abc/testfolder";
  //  line1="/home/abc/test1/testfolder";
      //  System.out.println(line);
       //  System.out.println(line1);
        File folderA= new File(line);
        File folderB=new File(line1);
        copyDirectory(folderA,folderB);
    }
    
}
