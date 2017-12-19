
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zbaraszewski-n
 */
public class Skater {
    
    private static int nextID = 1000;
    private int MAXPERLINE = 10;
    
    private Time[] timesList = new Time[MAXPERLINE];
    private int ID;
    
   
    
    
    
    public Skater(){
        ID = nextID++;
        
        for(int i=0; i<MAXPERLINE; i++){
            
             timesList[i] = new Time();
             
         }
    }
    
    //*****ACCESSORS*****
    
   
    public int giveMeID(){
        return ID;
    }
    
    
    public int giveMeMinutes(int i){
        return timesList[i].getMinutes();
    }
    
    public int giveMeSeconds(int i){
        return timesList[i].getSeconds();
    }
    
    //will turn minutes into seconds and add both of them
    public int giveMeTotalSeconds(int i){
        return timesList[i].getTotalSeconds();
    }
    
    
    //gives you the average time across all races
    public String giveMeAverageTime(){
        int temp = timesList[0].getTotalSeconds();
        int total = 0;
        int counter = 0;
        int minutes = 0;
        int seconds = 0;
        
        while (temp != 0 && counter!=10) {
            
            total += temp;
            temp = timesList[counter].getTotalSeconds();
            counter++;
        }
            
        total = total/counter;
        
        minutes = (total/60);
        seconds = (total-(60*minutes));
        
        return "ID:" +ID +" Average times was " +minutes +":" +seconds;
    }
    
    
    //gives you a single time
    public String giveMeTime(int i){
        int minutes = 0;
        int seconds = 0;
        
        minutes = timesList[i].getMinutes();
        seconds = timesList[i].getSeconds();
        
        
        return "ID:" +ID +" time for race " +(i+1) +" was " +minutes +":" +seconds;
        
    }
    
    //gives you a single speed
    public String giveMeSpeed(int i){
        double kmph = 0;
        double seconds = 0;
        seconds = timesList[i].getTotalSeconds();
        
        kmph = (seconds/3600)/5;
        DecimalFormat f = new DecimalFormat("###.####");
        
        
        return "ID:" +ID +" speed for race " +(i+1) +" was " +f.format(kmph) +" km per hour";
        //return "Speed for race " +(i+1) +" was " +kmph +" km per hour.";
        
    }
    
    //gives you the average speed across all races
    public String giveMeAverageSpeed(){
        int temp = timesList[0].getTotalSeconds();
        double total = 0;
        int counter = 0;
        double seconds = 0;
        double kmph = 0;
        
        while (temp != 0 && counter!=10) {
            total += temp;
            temp = timesList[counter].getTotalSeconds();
            counter++;
        }
        
        seconds = total;
        kmph = ((seconds/3600)/5)/counter;
        DecimalFormat f = new DecimalFormat("###.####");
        
        return "ID:" +ID +" average speed: " +f.format(kmph) +" km per hour";
        //return "average speed of all races = " +kmph +" km per hour ";
    }
    
    
    
    //add a time, if the array is already capped at 10, the first will be deleted and the rest move down one
    public void addATime(int a, int b){
        boolean bool = false;
        int temp = 0;
        
        for(int i=0; i<10; i++){
            
            temp = timesList[i].getTotalSeconds();
            if (temp == 0){
                bool = true;
                timesList[i].setBoth(a,b);
                i = 100;
            }
            
            //If the array is full with 10 times
            if (i == 9){
                int counterTwo = 0;
                int counterTwoExtra = 1;
                int minutes;
                int seconds;
                
            for(int p=0; p<9; p++){
                
                
                changeTime(counterTwo,timesList[counterTwoExtra].getMinutes(),timesList[counterTwoExtra].getSeconds());
                
                counterTwo++;
                counterTwoExtra++;
                
            }
            timesList[9].setBoth(a,b);
            
            
            }
        }
        
    }
    
    
    
    //prints all of a skaters times
    public String printTimes(){
        int minutes;
        int seconds;
        String output = "ID:" +giveMeID()+" ";
        int temp = 0;
        
        
        for(int i = 0; i<10; i++){
            
            if (timesList[i].getTotalSeconds() != 0){
            output += timesList[i].getMinutes()+":";
            output += timesList[i].getSeconds()+" ";
            } else {
                //hi
            }
            
        }
        
        return output;
    }
    
    
    
    
    //*****CHANGERS*****
    
    //changes both minutes and seconds
    public void changeTime(int i, int a, int b){
         timesList[i].setBoth(a,b);
     }
    
    public void changeMinutes(int i, int a){
        timesList[i].setMinutes(a);
    }
    
    public void changeSeconds(int i, int a){
        timesList[i].setSeconds(a);
    }
    
    
    
}
