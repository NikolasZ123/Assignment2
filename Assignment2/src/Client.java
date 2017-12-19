
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zbaraszewski-n
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        String temp;    //used to read in the text file                 
        int counter = 0;    //counts which skater we are on
        
        String[] tokens;    
        String delim = "[ ]+"; 
        
        Skater[] Skaters = null;    //creating a variable called "Skaters" which is an array of size 10, each array piece is a skater object
        Skaters = new Skater[10];   
        
        BufferedReader fin = new BufferedReader(new FileReader("Data.txt"));
        
        
        
        
        temp = fin.readLine();
        
        while (temp != null){
            
            //creating a skater object in the Skaters array
            Skaters[counter] = new Skater(); 
            
            //splitting into tokens (xx:yy)
            tokens = temp.split(delim);
                 
                for(int i=0; i<tokens.length; i++){
      
                    //the split tokens will be put in this temp string (xx) and (yy)
                    String[] times = tokens[i].split(":");
            
                    //filling in the time so time[i] will be minutes(xx) and seconds(yy)
                    Skaters[counter].changeTime(i,(Integer.parseInt(times[0])),(Integer.parseInt(times[1])));
            
            }
           
            counter++;
            temp = fin.readLine();
            
        }
        
        System.out.println("\nPrinting all the skaters times.");
        for(int i=0; i<counter; i++){
            System.out.println(Skaters[i].printTimes());
        }
        
        System.out.println("\nPrinting the average of the skaters times.");
        for(int i=0; i<counter; i++){
           System.out.println(Skaters[i].giveMeAverageTime());
        }
        
        System.out.println("\nAdding the times 5:34, 9:24, 5:12, 7:13, and 2:27 to the first skater.");
        Skaters[0].addATime(5, 34);
        Skaters[0].addATime(9, 24);
        Skaters[0].addATime(5, 12);
        Skaters[0].addATime(7, 13);
        Skaters[0].addATime(2, 27);
        System.out.println(Skaters[0].printTimes());
        
        System.out.println("\nPrinting the skaters average speed across all races");
        for(int i=0; i<counter; i++){
            System.out.println(Skaters[i].giveMeAverageSpeed());
        }
        
        System.out.println("\nPrinting the skaters speed for the first race");
        for (int i=0; i<counter; i++){
            System.out.println(Skaters[i].giveMeSpeed(0));
        }
        
        System.out.println("\nPrinting the first recorded time of the skaters.");
        for(int i=0; i<counter; i++){
            System.out.println(Skaters[i].giveMeTime(0));
        }
        
     
    }
    
}
