import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {   
  
    public static void main(String args[]) {
      
        //reading file line by line in Java using BufferedReader       
        FileInputStream fis = null;
        BufferedReader reader = null;
      
        //try {
        // fis = new FileInputStream("C:/sample.txt");
          /*  reader = new BufferedReader(new InputStreamReader(fis));
          */
          //Reading File line by line using BufferedReader
          
        	Scanner sc =  new Scanner(System.in);
       //   String line = reader.readLine();
        	String line = sc.nextLine();
            Parser parser = new Parser();
            parser.parse(line);
           // sc.next();
         /*   while(line != null){
               // System.out.println(line);
            	parser.parse(line);
               // line = reader.readLine();
            	line = sc.nextLine();
            } */
            line = sc.nextLine();
            parser.parse(line);
            parser.separateConcepts();            
          sc.close();
        /*} catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
          
        } finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
  }
}


