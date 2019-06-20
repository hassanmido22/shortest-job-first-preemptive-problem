/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classs;

import java.awt.Color;
import java.io.*;
import java.util.*;
import static oracle.jrockit.jfr.events.Bits.intValue;


public class CPU {
public ArrayList<proccess> Processes=new ArrayList<proccess>();
public ArrayList<Integer> IDL=new ArrayList<Integer>();
public double wAverage;
public double tAverage;
double Total;
public CPU(){
    this.wAverage=0;
    this.tAverage=0;
    this.Total=0;
}
public int Total_Burst_Time(){
int i;
int total=0;
for(i=0;i<Processes.size();i++){
    total=Processes.get(i).Burst_Time+total;
}
return total;
}
public int Arrival_time(){
int i;
int Arrival=Processes.get(0).Arrival_Time;
for(i=0;i<Processes.size();i++){
    if(Arrival<Processes.get(i).Arrival_Time){
        Arrival=Processes.get(i).Arrival_Time;
    }
}
return Arrival;
}
public int Arrival_time_short(){
int i;
int Arrival=Processes.get(0).Arrival_Time;
for(i=0;i<Processes.size();i++){
    if(Arrival>Processes.get(i).Arrival_Time){
        Arrival=Processes.get(i).Arrival_Time;
    }
}
return Arrival;
}


public void Calculate_Process(){
boolean check=true;
int i,m,Check_First_Process=0;
int Burst_Timee=0,Current_process=0,Prev_Burst=0,Check_new_Proc=0;
Total=Total_Burst_Time();
int arrive=Arrival_time();
int shortest=Arrival_time_short();
Total=shortest+Total;
//System.out.println("total "+Total+" Short "+shortest);
for(i=shortest;i<Total;i++){
    if(arrive>=i){
    if(Check_First_Process<1){
        for(m=0;m<Processes.size();m++){
    if(i==Processes.get(m).Arrival_Time ){
    if(Burst_Timee > Processes.get(m).Burst_Time ||Burst_Timee==0 ){
    Burst_Timee=Processes.get(m).Burst_Time;
    Current_process=m;
    Check_First_Process++;
    }
    
    }
        }
    //System.out.println("ads "+i);
    Processes.get(Current_process).Start_time.add(i);
    }
    else{
    for(m=0;m<Processes.size();m++){
           // System.out.println("arr "+Processes.get(m).Arrival_Time +" I"+i);

            if((i>=Processes.get(m).Arrival_Time) && (Processes.get(m).Burst_Time!=0)){
            if(Burst_Timee > Processes.get(m).Burst_Time || Burst_Timee==0){
            Burst_Timee=Processes.get(m).Burst_Time;
            Check_new_Proc++;
            shortest=m;
            }
            }
                    }

    if(Check_new_Proc>=1){
   // System.out.println("y "+y+"x "+x+"i "+i +" "+c);
    Prev_Burst=Current_process;
    Current_process=shortest;
    if(check==true){
    Processes.get(Prev_Burst).End_time.add(i);
    Processes.get(Current_process).Start_time.add(i);
    Check_new_Proc=0;
    }
    else{
    Processes.get(Current_process).Start_time.add(i);
    IDL.add(i);
    Check_new_Proc=0;
    check=true;
    }
    }
    }
    if(Burst_Timee==0){
    Total++;
    if(check==true){
            Processes.get(Current_process).End_time.add(i);
            IDL.add(i);
            check=false;
    }
    }
    else{
    --Processes.get(Current_process).Burst_Time;
    --Burst_Timee;
    }
    }   
    
    
    else{
            for(m=0;m<Processes.size();m++){
    if((Burst_Timee > Processes.get(m).Burst_Time || Burst_Timee==0) && (Processes.get(m).Burst_Time!=0)){
    Burst_Timee=Processes.get(m).Burst_Time;
    Check_new_Proc++;
    shortest=m;
    }
    
            }
    if(Check_new_Proc>=1){
    //System.out.println("y "+y+"x "+x+"i "+i);
    Prev_Burst=Current_process;
    Current_process=shortest;
    Processes.get(Prev_Burst).End_time.add(i);
    Processes.get(Current_process).Start_time.add(i);
    Check_new_Proc=0;
    }
    --Processes.get(Current_process).Burst_Time;
    --Burst_Timee;
    }
       
    
    
}
Processes.get(Current_process).End_time.add(intValue(Total));


}

public void turnaroundtime ()
{
    for(int i = 0;i<Processes.size();i++)
    {
        Processes.get(i).turn_around_time();
    }
}
public void waiting_time(){
    for(int i = 0;i<Processes.size();i++)
    {
        //System.out.println(" size "+Processes.size());
        Processes.get(i).calculate_wait();
    }
}

public double waitAverage(){
    double total=0;
    for(int i = 0;i<Processes.size();i++)
    {
        total=total+Processes.get(i).Waiting_Time;
    }
    return wAverage=total/Processes.size();
}

/* hassan edit */

public double turnAverage(){
    double total=0;
    for(int i = 0;i<Processes.size();i++)
    {
        total=total+Processes.get(i).Turn_Time;
    }
    return tAverage=total/Processes.size();
}

/* hassan end edit */


public void Create_Process(int arrivaltime , int bursttime){
proccess x=new proccess();
x.create_process(arrivaltime, bursttime);
Processes.add(x);
}
public int Arr_calculate(){
int x=0;
for(int i=0;i<Processes.size();i++){
    x=x+Processes.get(i).Start_time.size();
}
   x=x+IDL.size();
return x;
}
}

