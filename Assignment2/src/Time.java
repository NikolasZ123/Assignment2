/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zbaraszewski-n
 */
public class Time {
    
    private int minutes;
    private int seconds;
    
    
    public Time(){
        minutes = 0;
        seconds = 0;
    }
    
    //*****ACCESSORS*****
    public int getMinutes(){
        return minutes;
    }
    
    public int getSeconds(){
        return seconds;
    }
    
    //converts minutes and seconds to seconds
    public int getTotalSeconds(){
        return (seconds) + (minutes*60);
    }
    
    
    
    
    //*****CHANGERS*****
    public void setMinutes(int a){
        minutes = a;
    }
    
    public void setSeconds(int a){
        seconds = a;
    }
    
    public void setBoth(int a, int b){
        minutes = a;
        seconds = b;
    }
    
    
    
    
    
}
