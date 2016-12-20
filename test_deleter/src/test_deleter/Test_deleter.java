/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_deleter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author abc
 */ 
public class Test_deleter {
    
public static void deleter(File[] paths,Date threshold){
    for(int i=0;i<paths.length;i++){
  //  System.out.println(paths.length);
    if(paths[i].isFile()) {
       // System.out.println("File " + paths[i].getName());
       
        Date lastModified1 = new Date(paths[i].lastModified()); 
        
if(lastModified1.before(threshold)){
     System.out.println("delete  " + paths[i].getName());
    paths[i].delete();
}
 
     
    } 
    else if(paths[i].isDirectory()) {
        deleter(paths[i].listFiles(),threshold);
    }
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
        String[] inp = null;
BufferedReader br = new BufferedReader(new FileReader("test"));
String line=null,line1=null,temp = null;
    int count=0;
    while((temp=br.readLine())!=null){
    //    System.out.println(" ll ");
      if(count==0)  {line=temp;
      
      }
      else if(count==1) {line1=temp;
      
      }
        count++;
    }
    String date ;
  date= line1.substring(0, 10);
        
     //   System.out.println(inp[0]);
     File folder = new File(line);
     // String date="07/01/2016";
     Date threshold = new Date();
     DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
     threshold=df.parse(date);
    
  
  //   int[] date1= {0,1,0,7,2,0,1,6};
     deleter(folder.listFiles(),threshold);
       File[] paths = folder.listFiles();
     /*  for(int i=0;i<paths.length;i++){
           System.out.println(paths[i].getName());
       }*/
        
       
        // TODO code application logic here
    }
    
}
