/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classs;

import java.awt.Color;
import java.io.*;
import java.util.*;


public class proccess {
    public String PName;
    public int Waiting_Time;
    public int Arrival_Time;
    public int Turn_Time;
    public int Burst_Time;
    public int Response_Time;
    public static int n;
    public ArrayList<Integer> Start_time=new ArrayList<Integer>();
    public ArrayList<Integer> End_time=new ArrayList<Integer>();
    public proccess(){
    this.Waiting_Time=0;
    this.Burst_Time=0;
    this.Response_Time=0;
    this.Turn_Time=0;
    this.Arrival_Time=0;
    }
    
    void create_process(int arrivaltime , int bursttime)
    {
        this.PName = "P"+String.valueOf(n);
        n++; 
        this.Arrival_Time = arrivaltime;
        this.Burst_Time=bursttime;
    }
    
    public void calculate_wait(){
    for(int i=0;i<Start_time.size();i++){
    if(i==0){
        Waiting_Time=Start_time.get(i)-Arrival_Time;
        Response_Time=Waiting_Time;
        //System.out.println("Start1 "+Start_time.get(i)+" size "+Start_time.size());
    }
    else{
    Waiting_Time=(Start_time.get(i)-End_time.get(i-1))+Waiting_Time;
            //System.out.println("Start "+Start_time.get(i));
                    //System.out.println("end "+End_time.get(i-1));
            
    }
    }
    }
    
    public void turn_around_time()
    {
        //System.out.println("size "+End_time.size());
        for(int i=0;i<End_time.size();i++)
        {

            if(i==(End_time.size()-1)){
                Turn_Time = End_time.get(i) - Arrival_Time;
            //System.out.println("end "+End_time.get(i)+"arr "+Arrival_Time);
            }
                
        }
    }
   
    
    
}
 